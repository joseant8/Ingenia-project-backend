package com.ingenia.dao.impl;

import com.ingenia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Entity
public class UserDAOImpl {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private UserRepository repository;
}
