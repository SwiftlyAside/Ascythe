package com.ngsc.takeover.service;

import com.ngsc.takeover.dto.CommentsDto;
import com.ngsc.takeover.exceptions.PostNotFoundException;
import com.ngsc.takeover.mapper.CommentMapper;
import com.ngsc.takeover.model.Comment;
import com.ngsc.takeover.model.NotificationEmail;
import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.User;
import com.ngsc.takeover.repository.CommentRepository;
import com.ngsc.takeover.repository.PostRepository;
import com.ngsc.takeover.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService {
    private static final String POST_URL = "";
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final CommentMapper commentMapper;
    private final CommentRepository commentRepository;
    private final MailContentBuilder mailContentBuilder;
    private final MailService mailService;

    public void save(CommentsDto commentsDto) {
        Post post = postRepository.findById(commentsDto.getPostId())
                .orElseThrow(() -> new PostNotFoundException(commentsDto.getPostId().toString()));
        Comment comment = commentMapper.map(commentsDto, post, authService.getCurrentUser());
        commentRepository.save(comment);

        String message = mailContentBuilder.build(post.getUser().getUsername() + "님이 포스트에 코멘트를 달았어요. " + POST_URL);
        sendCommentNotification(message, post.getUser());
    }

    private void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + "님이 코멘트를 달았어요.", user.getEmail(), message));
    }

    public List<CommentsDto> getAllCommentsForPost(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new PostNotFoundException(postId.toString()));
        return commentRepository.findByPost(post)
                .stream()
                .map(commentMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
