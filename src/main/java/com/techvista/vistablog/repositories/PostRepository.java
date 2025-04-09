package com.techvista.vistablog.repositories;

import com.techvista.vistablog.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Long> {
    PostModel findByPostTitle(String postTitle);

    boolean existsByPostTitle(String postTitle);

    void deleteByPostTitle(String postTitle);
}
