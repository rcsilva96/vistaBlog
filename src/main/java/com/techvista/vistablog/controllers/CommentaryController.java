package com.techvista.vistablog.controllers;

import com.techvista.vistablog.models.CommentaryModel;
import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.models.TagModel;
import com.techvista.vistablog.services.CommentaryService;
import com.techvista.vistablog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping(path = "/tags")
    public class CommentaryController {

        @Autowired
        private CommentaryService commentaryService;

        @PostMapping("/save")
        private @ResponseBody CommentaryModel saveCommentary(@RequestBody CommentaryModel commentary) {
            return commentaryService.save(commentary);
        }

        @GetMapping("/getAll")
        private @ResponseBody List<CommentaryModel> getAlCommentaries() {
            return commentaryService.getAll();
        }

        @GetMapping(path = "/get")
        private @ResponseBody TagModel getTag(@RequestParam final Long commentaryId) {
            return commentaryService.get(commentaryId);
        }

        @PostMapping(path = "/update")
        private @ResponseBody TagModel updateTag(@RequestBody final Long commentaryId, PostModel post) {
            return commentaryService.update(commentaryId, post);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deleteUser(@RequestParam final Long commentaryId) {
            commentaryService.delete(commentaryId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

}
