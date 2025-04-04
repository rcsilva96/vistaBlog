package com.techvista.vistablog.services;

import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.models.TagModel;

import java.util.List;

public interface PostService {
    PostModel save(PostModel post);

    List<PostModel> getAll();

    TagModel get(Long postId);

    TagModel update(Long postId, PostModel post);

    void delete(Long postId);
}
