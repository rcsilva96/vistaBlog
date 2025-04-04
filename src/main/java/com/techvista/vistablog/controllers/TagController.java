package com.techvista.vistablog.controllers;

import com.techvista.vistablog.models.TagModel;
import com.techvista.vistablog.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path = "/tags")
    public class TagController {

        @Autowired
        private TagService tagService;

        @PostMapping("/save")
        private @ResponseBody TagModel saveTag(@RequestBody TagModel tag) {
            return tagService.save(tag);
        }

        @GetMapping("/getAll")
        private @ResponseBody List<TagModel> getAllTags() {
            return tagService.getAll();
        }

        @GetMapping(path = "/get")
        private @ResponseBody TagModel getTag(@RequestParam final Long tagId) {
            return tagService.get(tagId);
        }

        @PostMapping(path = "/update")
        private @ResponseBody TagModel updateTag(@RequestBody final Long tagId, TagModel tag) {
            return tagService.update(tagId, tag);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deleteUser(@RequestParam final Long tagId) {
            tagService.delete(tagId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

}

