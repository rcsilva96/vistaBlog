package com.techvista.vistablog.controllers;

import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path = "/posts")
    public class PostController {

        @Autowired
        private PostService postService;

        @PostMapping("/save")
        private @ResponseBody PostModel savePost(@RequestBody PostModel post) {
            return postService.savePost(post);
        }

        @GetMapping("/getAll")
        private @ResponseBody List<PostModel> getAllPosts() {
            return postService.getAllPosts();
        }

        @GetMapping(path = "/get")
        private @ResponseBody PostModel getPost(@RequestParam final Long postId) {
            return postService.getPost(postId);
        }

        @PostMapping(path = "/update")
        private @ResponseBody PostModel updatePost(@RequestBody final Long postId, PostModel post) {
            return postService.updatePost(postId, post);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deletePost(@RequestParam final Long postId) {
            postService.deletePost(postId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

    }