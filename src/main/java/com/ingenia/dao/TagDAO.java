package com.ingenia.dao;

import com.ingenia.model.Tag;

import java.util.List;

public interface TagDAO {

    // consultas y filtros

    public List<Tag> getAllTags();

    public Tag getTag(Long id);


    // crear

    public Tag createTag(Tag tag);

    // actualizar

    public Tag updataTag(Tag tag);

    // eliminar

    public boolean deleteTag(Long id);
}
