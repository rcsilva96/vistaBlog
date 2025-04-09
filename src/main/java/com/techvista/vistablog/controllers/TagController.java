package com.techvista.vistablog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController {

    @GetMapping("/{id}")
    public String getTag(@PathVariable Long id) {
        return "Tag ID: " + id;
    }
}
