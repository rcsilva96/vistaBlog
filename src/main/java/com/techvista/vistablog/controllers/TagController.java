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
        private @ResponseBody TagModel saveTag(@RequestBody TagModel tag)
        {

            return tagService.saveTag(tag);

        }

        @GetMapping("/getAll")
        private @ResponseBody List<TagModel> getAllTags() {

            return tagService.getAllTags();

        }

        @GetMapping(path = "/get")
        private @ResponseBody TagModel getTag(@RequestParam final Long tagId) {

            return tagService.getTag(tagId);

        }

        @PostMapping(path = "/update")
        private @ResponseBody TagModel updateTag(@RequestBody final Long tagId, TagModel tag) {
            return tagService.updateTag(tagId, tag);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deleteTag(@RequestParam final Long tagId) {
            tagService.deleteTag(tagId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

}

