package com.ingenia.dao.impl;

import com.ingenia.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class TagDAOImpl {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository repository;
}
