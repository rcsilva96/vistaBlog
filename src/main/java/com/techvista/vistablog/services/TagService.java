package com.techvista.vistablog.services;

import com.techvista.vistablog.models.TagModel;

import java.util.List;

public interface TagService {
    TagModel saveTag(TagModel tag);

    List<TagModel> getAllTags();

    TagModel getTag(Long tagId);

    TagModel updateTag(Long tagId, TagModel tag);

    void deleteTag(Long tagId);
}
