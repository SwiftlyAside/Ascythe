package com.ngsc.takeover.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {
    private Long id;

    private String postName;

    private String url;

    private String description;

    private String userName;

    private String topicName;

    private Integer voteCount;

    private Integer commentCount;

    private String duration;

    private boolean upVote;

    private boolean downVote;

}
