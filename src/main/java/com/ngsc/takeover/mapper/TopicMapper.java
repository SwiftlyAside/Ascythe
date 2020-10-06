package com.ngsc.takeover.mapper;

import com.ngsc.takeover.dto.TopicDto;
import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.Topic;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    @Mapping(target = "numberOfPosts", expression = "java(mapPosts(topic.getPosts()))")
    TopicDto mapTopicToDto(Topic topic);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Topic mapDtoToTopic(TopicDto topicDto);
}
