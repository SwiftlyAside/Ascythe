package com.ngsc.takeover.repository;

import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.Topic;
import com.ngsc.takeover.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByTopic(Topic topic);

    List<Post> findByUser(User user);
}
