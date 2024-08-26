package com.moiso.dto;

import com.moiso.entity.Announce;
import com.moiso.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AnnounceRes {
    private String title;
    private String writerName;
    private String phoneNum;
    private String content;
    private String reward;
    private String caution;
    private String condition;

    public static AnnounceRes of(Announce announce, User user) {
        return AnnounceRes.builder()
                .title(announce.getTitle())
                .writerName(user.getName())
                .phoneNum(user.getPhoneNum())
                .content(announce.getContent())
                .reward(announce.getReward())
                .caution(announce.getCaution())
                .condition(announce.getCondition()).build();
    }
}
