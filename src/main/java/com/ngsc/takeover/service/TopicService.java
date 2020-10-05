package com.ngsc.takeover.service;

import com.ngsc.takeover.dto.TopicDto;
import com.ngsc.takeover.model.Topic;
import com.ngsc.takeover.repository.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TopicService {
    private final TopicRepository topicRepository;

    @Transactional
    public TopicDto save(TopicDto topicDto) {
        Topic save = topicRepository.save(mapTopicDto(topicDto));
        topicDto.setId(save.getId());
        return topicDto;
    }

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private TopicDto mapToDto(Topic topic) {
        return TopicDto.builder().name(topic.getName())
                .id(topic.getId())
                .numberOfPosts(topic.getPosts().size())
                .build();
    }

    private Topic mapTopicDto(TopicDto topicDto) {
        return Topic.builder().name(topicDto.getName())
                .description(topicDto.getDescription())
                .build();
    }
}
