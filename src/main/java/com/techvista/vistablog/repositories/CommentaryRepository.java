package com.techvista.vistablog.repositories;

import com.techvista.vistablog.models.CommentaryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends JpaRepository<CommentaryModel, Long> {

    CommentaryModel findByContent(String content);

    boolean existsByContent(String content);

    void deleteByContent(String content);

}
