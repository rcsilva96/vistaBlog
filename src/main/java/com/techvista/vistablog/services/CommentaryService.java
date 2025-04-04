package com.techvista.vistablog.services;

import com.techvista.vistablog.models.CommentaryModel;
import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.models.TagModel;

import java.util.List;

public interface CommentaryService {
    CommentaryModel save(CommentaryModel commentary);

    List<CommentaryModel> getAll();

    TagModel get(Long commentaryId);

    TagModel update(Long commentaryId, PostModel post);

    void delete(Long commentaryId);
}
