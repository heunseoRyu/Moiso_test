package com.moiso.dto;

import com.moiso.entity.Announce;
import lombok.Getter;

@Getter
public class RegisterReq {
    private String title;
    private String userEmail;
    private String content;
    private String reward;
    private String caution;
    private String condition;

    public Announce toEntity(){
        return Announce.builder()
                .title(this.title)
                .userId(userEmail)
                .content(this.content)
                .reward(this.reward)
                .caution(this.caution)
                .condition(this.condition).build();
    }
}
