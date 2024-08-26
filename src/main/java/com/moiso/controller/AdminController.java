package com.moiso.controller;

import com.moiso.dto.RegisterReq;
import com.moiso.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AnnounceService announceService;

    @PostMapping("/register")
    public void register(
            @RequestBody RegisterReq req
    ){
        announceService.register(req);
    }

}
