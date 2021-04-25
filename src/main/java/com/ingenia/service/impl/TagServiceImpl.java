package com.ingenia.service.impl;

import com.ingenia.dao.TagDAO;
import com.ingenia.model.Tag;
import com.ingenia.model.User;
import com.ingenia.payload.request.TagRequest;
import com.ingenia.repository.UserRepository;
import com.ingenia.service.TagService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    private TagDAO tagDAO;

    private UserRepository userRepository;

    public TagServiceImpl(TagDAO tagDAO, UserRepository userRepository) {
        this.tagDAO = tagDAO;
        this.userRepository = userRepository;
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

    @Override
    public Tag transformToTag(TagRequest request) {
        Tag etiqueta = new Tag();
        if(request.getNombreTag() != null){
            etiqueta.setNombre(request.getNombreTag());
        }
        if(request.getUsernameCreador() != null){
            Optional<User> creador = userRepository.findByUsername(request.getUsernameCreador());
            etiqueta.setCreador(creador.get());
        }
        return etiqueta;
    }
}
