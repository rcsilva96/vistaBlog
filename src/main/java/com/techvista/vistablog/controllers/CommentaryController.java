package com.techvista.vistablog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commentaries")
public class CommentaryController {

    @GetMapping("/{id}")
    public String getCommentary(@PathVariable Long id) {
        return "Commentary ID: " + id;
    }
}