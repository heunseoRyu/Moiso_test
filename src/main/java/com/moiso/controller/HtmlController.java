package com.moiso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class HtmlController {

    @GetMapping("/sign-in")
    public String signIn() {
        return "signin1";
    }

    @GetMapping("/upload-article")
    public String uploadArticle() {
        return "UploadArticle";
    }
}
