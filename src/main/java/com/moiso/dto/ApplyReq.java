package com.moiso.dto;

import com.moiso.entity.Apply;
import lombok.Getter;

@Getter
public class ApplyReq {
    private String userEmail;
    private Long announceId;

    public Apply toEntity(){
        return Apply.builder()
                .userId(this.userEmail)
                .announceId(this.announceId).build();
    }
}
