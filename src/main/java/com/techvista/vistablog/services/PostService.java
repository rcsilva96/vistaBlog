package com.techvista.vistablog.services;

import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.models.TagModel;

import java.util.List;

public interface PostService {

    PostModel savePost(PostModel post);

    List<PostModel> getAllPosts();

    PostModel getPost(Long postId);

    PostModel updatePost(Long postId, PostModel post);

    void deletePost(Long postId);
}
