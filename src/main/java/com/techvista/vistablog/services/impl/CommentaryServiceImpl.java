package com.techvista.vistablog.services.impl;

import com.techvista.vistablog.models.CommentaryModel;
import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.repositories.CommentaryRepository;
import com.techvista.vistablog.services.CommentaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentaryServiceImpl implements CommentaryService {

    private final CommentaryRepository commentaryRepository;

    @Override
    public CommentaryModel saveCommentary(CommentaryModel commentary) {

        CommentaryModel existingCommentary = commentaryRepository.findById(commentary.getCommentaryId()).orElse(null);
        if (existingCommentary != null) {
            throw new RuntimeException("Comentário já existe!");
        }
        CommentaryModel entity = new CommentaryModel(commentary.getCommentaryId(), commentary.getContent(), commentary.getDate(),commentary.getUser(), commentary.getPost());
        CommentaryModel newCommentary = commentaryRepository.save(entity);
        commentaryRepository.save(newCommentary);
        return newCommentary;
    }

    @Override
    public CommentaryModel getCommentary(Long commentaryId) {

        return commentaryRepository.findById(commentaryId).orElse(null);

    }

    @Override
    public CommentaryModel updateCommentary(Long commentaryId, PostModel post) {

        CommentaryModel existingCommentary = commentaryRepository.findById(commentaryId).orElse(null);
        if (existingCommentary == null) {
            throw new RuntimeException("Comentário não encontrado!");
        }

        existingCommentary.setContent(post.getPostContent());
        existingCommentary.setDate(post.getPostDate());
        existingCommentary.setUser(post.getUserID());
        existingCommentary.setPost(post);
        return commentaryRepository.save(existingCommentary);

    }

    @Override
    public void deleteCommentary(Long commentaryId) {

    }

    @Override
    public List<CommentaryModel> getAllCommentaries() {
        return List.of();
    }
}
