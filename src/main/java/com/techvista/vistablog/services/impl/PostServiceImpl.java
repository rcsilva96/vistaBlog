package com.techvista.vistablog.services.impl;

import com.techvista.vistablog.models.PostModel;
import com.techvista.vistablog.repositories.PostRepository;
import com.techvista.vistablog.services.PostService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public PostModel savePost(final PostModel post) {

        PostModel existingPost = postRepository.findByTitle(post.getPostTitle());
        if (Objects.nonNull(existingPost)){
            throw new RuntimeException("O post já existe!");
        }

        PostModel entity = new PostModel(post.getPostID(), post.getPostTitle(), post.getPostContent(), post.getUserID());
        PostModel newPost = postRepository.save(entity);
        return newPost;

    }

    @Override
    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public PostModel getPost(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    @Override
    public PostModel updatePost(Long postId, PostModel post) {
        PostModel existingPost = postRepository.findById(postId).orElse(null);
        if (existingPost == null) {
            throw new RuntimeException("Post não encontrado!");
        }
        existingPost.setPostTitle(post.getPostTitle());
        existingPost.setPostContent(post.getPostContent());
        return postRepository.save(existingPost);
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
}
