package com.ingenia.dao.impl;

import com.ingenia.dao.UserDAO;
import com.ingenia.model.User;
import com.ingenia.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private UserRepository repository;


    /**
     * Devuelve el usuario según el id.
     * @param id
     * @return Usuario. Si no lo encuentra o se produce algún error, devuelve un usuario con parámetros vacíos.
     */
    @Override
    public User getUser(Long id) {
        try{
            User usuarioBD = manager.find(User.class, id);
            if(usuarioBD == null){
                return new User();
            }else{
                return usuarioBD;
            }
        }catch(Exception e){
            return new User();
        }
    }

    /**
     * Crea un nuevo usuario.
     * @param user
     * @return El usuario creado.
     */
    @Override
    public User createUser(User user) {
        return repository.save(user);
    }
}
