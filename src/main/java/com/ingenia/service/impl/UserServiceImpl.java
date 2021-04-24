package com.ingenia.service.impl;

import com.ingenia.dao.UserDAO;
import com.ingenia.model.User;
import com.ingenia.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    /**
     * Devuelve el usuario según el id.
     * @param id
     * @return Usuario. Si no lo encuentra o se produce algún error, devuelve un usuario con parámetros vacíos.
     */
    @Override
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }

    /**
     * Crea un nuevo usuario.
     * @param user
     * @return El usuario creado.
     */
    @Override
    public User createUser(User user) {
        return userDAO.createUser(user);
    }
}
