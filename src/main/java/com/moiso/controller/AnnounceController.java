package com.moiso.controller;

import com.moiso.dto.AnnounceList;
import com.moiso.dto.AnnounceRes;
import com.moiso.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/announce")
@RequiredArgsConstructor
public class AnnounceController {

    private final AnnounceService announceService;

    @GetMapping("/list")
    public ResponseEntity<List<AnnounceList>> announceList(){
        return ResponseEntity.ok(announceService.announceList());
    }

    @GetMapping("/search")
    public ResponseEntity<List<AnnounceList>> announceSearch(
            @RequestParam String title
    ){
        return ResponseEntity.ok(announceService.announceSearch(title));
    }

    @GetMapping("")
    public AnnounceRes announceInfo(
            @RequestParam Long id
    ){
        return announceService.announceInfo(id);
    }



}
