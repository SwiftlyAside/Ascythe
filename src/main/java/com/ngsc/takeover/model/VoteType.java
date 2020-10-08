package com.ngsc.takeover.model;

import com.ngsc.takeover.exceptions.TakeoverException;

import java.util.Arrays;

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1),
    ;

    private int direction;

    VoteType(int direction) {
    }

    public static VoteType lookup(Integer direction) {
        return Arrays.stream(VoteType.values())
                .filter(value -> value.getDirection().equals(direction))
                .findAny()
                .orElseThrow(() -> new TakeoverException("추천수가 존재하지 않습니다."));
    }

    public Integer getDirection() {
        return direction;
    }
}
