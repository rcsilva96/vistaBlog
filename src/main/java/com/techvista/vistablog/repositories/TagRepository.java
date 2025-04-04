package com.techvista.vistablog.repositories;

import com.techvista.vistablog.models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Long> {
    TagModel findByName(String name);

    boolean existsByName(String name);

    void deleteByName(String name);
}
