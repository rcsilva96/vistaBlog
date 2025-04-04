package com.techvista.vistablog.services;

import com.techvista.vistablog.models.TagModel;

import java.util.List;

public interface TagService {
    TagModel save(TagModel tag);

    List<TagModel> getAll();

    TagModel get(Long tagId);

    TagModel update(Long tagId, TagModel tag);

    void delete(Long tagId);
}
