package com.ngsc.takeover.service;

import com.ngsc.takeover.dto.PostRequest;
import com.ngsc.takeover.dto.PostResponse;
import com.ngsc.takeover.exceptions.PostNotFoundException;
import com.ngsc.takeover.exceptions.TopicNotFoundException;
import com.ngsc.takeover.mapper.PostMapper;
import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.Topic;
import com.ngsc.takeover.model.User;
import com.ngsc.takeover.repository.PostRepository;
import com.ngsc.takeover.repository.TopicRepository;
import com.ngsc.takeover.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final AuthService authService;
    private final PostMapper postMapper;

    public void save(PostRequest postRequest) {
        Topic topic = topicRepository.findByName(postRequest.getTopicName())
                .orElseThrow(() -> new TopicNotFoundException(postRequest.getTopicName()));
        postRepository.save(postMapper.map(postRequest, topic, authService.getCurrentUser()));
    }

    @Transactional(readOnly = true)
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id.toString()));
        return postMapper.mapToDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll()
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByTopic(Long topicId) {
        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new TopicNotFoundException(topicId.toString()));
        List<Post> posts = postRepository.findAllByTopic(topic);
        return posts.stream().map(postMapper::mapToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return postRepository.findByUser(user)
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
