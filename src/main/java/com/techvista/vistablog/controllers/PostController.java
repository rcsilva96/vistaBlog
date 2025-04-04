package com.techvista.vistablog.controllers;

import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.models.TagModel;
import com.techvista.vistablog.services.PostService;
import com.techvista.vistablog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path = "/tags")
    public class PostController {

        @Autowired
        private PostService postService;

        @PostMapping("/save")
        private @ResponseBody PostModel savePost(@RequestBody PostModel post) {
            return postService.save(post);
        }

        @GetMapping("/getAll")
        private @ResponseBody List<PostModel> getAllPosts() {
            return postService.getAll();
        }

        @GetMapping(path = "/get")
        private @ResponseBody TagModel getTag(@RequestParam final Long postId) {
            return postService.get(postId);
        }

        @PostMapping(path = "/update")
        private @ResponseBody TagModel updateTag(@RequestBody final Long postId, PostModel post) {
            return postService.update(postId, post);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deleteUser(@RequestParam final Long postId) {
            postService.delete(postId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

    }