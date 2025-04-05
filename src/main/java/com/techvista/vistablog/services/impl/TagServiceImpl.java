package com.techvista.vistablog.services.impl;

import com.techvista.vistablog.models.TagModel;
import com.techvista.vistablog.repositories.TagRepository;
import com.techvista.vistablog.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    @Override
    public TagModel saveTag(final TagModel tag) {

        TagModel existingTag = tagRepository.findByName(tag.getName());
        if (Objects.nonNull(existingTag)) {
            throw new RuntimeException("Tag já existe!");
        }

        TagModel entity = new TagModel(tag.getTagId(), tag.getName());
        TagModel newTag = tagRepository.save(entity);
        return newTag;

    }

    @Override
    public List<TagModel> getAllTags() {

        return tagRepository.findAll();

    }

    @Override
    public TagModel getTag(Long tagId) {
        return tagRepository.findById(tagId).orElse(null);
    }

    @Override
    public TagModel updateTag(Long tagId, TagModel tag) {
        TagModel existingTag = tagRepository.findById(tagId).orElse(null);
        if (existingTag == null) {
            throw new RuntimeException("Tag não encontrada!");
        }
        existingTag.setName(tag.getName());
        return tagRepository.save(existingTag);
    }

    @Override
    public void deleteTag(Long tagId) {
        tagRepository.deleteById(tagId);
    }

}
