package com.ngsc.takeover.repository;

import com.ngsc.takeover.model.Post;
import com.ngsc.takeover.model.Subreddit;
import com.ngsc.takeover.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
