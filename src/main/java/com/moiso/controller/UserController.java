package com.moiso.controller;

import com.moiso.dto.ApplyReq;
import com.moiso.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final AnnounceService announceService;

    @PostMapping("/apply")
    public void apply(
            @RequestBody ApplyReq req
    ){
        announceService.apply(req);
    }

}
