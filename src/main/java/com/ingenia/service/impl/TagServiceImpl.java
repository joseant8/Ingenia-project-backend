package com.ingenia.service.impl;

import com.ingenia.dao.TagDAO;
import com.ingenia.model.Tag;
import com.ingenia.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    private TagDAO tagDAO;

    public TagServiceImpl(TagDAO tagDAO) {
        this.tagDAO = tagDAO;
    }

    @Override
    public List<Tag> getAllTags() {
        return tagDAO.getAllTags();
    }

    @Override
    public Tag getTag(Long id) {
        return tagDAO.getTag(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagDAO.createTag(tag);
    }

    @Override
    public boolean deleteTag(Long id) {
        return tagDAO.deleteTag(id);
    }
}
