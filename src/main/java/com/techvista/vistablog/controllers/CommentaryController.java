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
            return commentaryService.saveCommentary(commentary);
        }

        @GetMapping("/getAll")
        private @ResponseBody List<CommentaryModel> getAlCommentaries() {
            return commentaryService.getAllCommentaries();
        }

        @GetMapping(path = "/get")
        private @ResponseBody CommentaryModel getCommentary(@RequestParam final Long commentaryId) {
            return commentaryService.getCommentary(commentaryId);
        }

        @PostMapping(path = "/update")
        private @ResponseBody CommentaryModel updateCommentary(@RequestBody final Long commentaryId, PostModel post) {
            return commentaryService.updateCommentary(commentaryId, post);
        }

        @PostMapping(path = "/delete")
        private ResponseEntity<?> deleteCommentary(@RequestParam final Long commentaryId) {
            commentaryService.deleteCommentary(commentaryId);
            return ResponseEntity.noContent().build();
        }

        @GetMapping(path = "/")
        public @ResponseBody String authentication(){
            return "888";
        }

}
