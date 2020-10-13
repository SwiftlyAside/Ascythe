package com.ngsc.ascythe.repository;

import com.ngsc.ascythe.model.Comment;
import com.ngsc.ascythe.model.Post;
import com.ngsc.ascythe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
