package com.ngsc.ascythe.service;

import com.ngsc.ascythe.dto.TopicDto;
import com.ngsc.ascythe.exceptions.AscytheException;
import com.ngsc.ascythe.mapper.TopicMapper;
import com.ngsc.ascythe.model.Topic;
import com.ngsc.ascythe.repository.TopicRepository;
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
    private final TopicMapper topicMapper;

    @Transactional
    public TopicDto save(TopicDto topicDto) {
        Topic save = topicRepository.save(topicMapper.mapDtoToTopic(topicDto));
        topicDto.setId(save.getId());
        return topicDto;
    }

    @Transactional(readOnly = true)
    public List<TopicDto> getAll() {
        return topicRepository.findAll()
                .stream()
                .map(topicMapper::mapTopicToDto)
                .collect(Collectors.toList());
    }

    public TopicDto getTopic(Long id) {
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new AscytheException("해당 아이디의 토픽이 없습니다."));
        return topicMapper.mapTopicToDto(topic);
    }
}
