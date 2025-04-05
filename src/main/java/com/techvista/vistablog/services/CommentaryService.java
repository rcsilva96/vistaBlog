package com.techvista.vistablog.services;

import com.techvista.vistablog.models.CommentaryModel;
import com.techvista.vistablog.models.PostModel;

import java.util.List;

public interface CommentaryService {

    void saveCommentary(CommentaryModel commentary);

    CommentaryModel getCommentary(Long commentaryId);

    CommentaryModel updateCommentary(Long commentaryId, PostModel post);

    void deleteCommentary(Long commentaryId);

    List<CommentaryModel> getAllCommentaries();

}
