package com.ngsc.ascythe.repository;

import com.ngsc.ascythe.model.Post;
import com.ngsc.ascythe.model.Topic;
import com.ngsc.ascythe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByTopic(Topic topic);

    List<Post> findByUser(User user);
}
