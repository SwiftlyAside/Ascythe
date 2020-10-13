package com.ngsc.ascythe.repository;

import com.ngsc.ascythe.model.Post;
import com.ngsc.ascythe.model.User;
import com.ngsc.ascythe.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}
