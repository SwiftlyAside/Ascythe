package com.ngsc.takeover.repository;

import com.ngsc.takeover.model.Comment;
import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
