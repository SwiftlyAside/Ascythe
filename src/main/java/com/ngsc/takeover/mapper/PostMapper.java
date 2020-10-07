package com.ngsc.takeover.mapper;

import com.ngsc.takeover.dto.PostRequest;
import com.ngsc.takeover.dto.PostResponse;
import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.Topic;
import com.ngsc.takeover.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "topic", source = "topic")
    @Mapping(target = "voteCount", constant = "0")
    @Mapping(target = "user", source = "user")
    Post map(PostRequest postRequest, Topic topic, User user);

    @Mapping(target = "id", source = "postId")
    @Mapping(target = "topicName", source = "topic.name")
    @Mapping(target = "userName", source = "user.username")
    PostResponse mapToDto(Post post);
}