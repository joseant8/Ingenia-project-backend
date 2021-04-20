package com.ingenia.dao.impl;

import com.ingenia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private UserRepository repository;
}
