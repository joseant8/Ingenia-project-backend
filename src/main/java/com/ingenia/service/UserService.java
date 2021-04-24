package com.ingenia.service;

import com.ingenia.model.User;

public interface UserService {

    /**
     * Devuelve el usuario según el id.
     * @param id
     * @return Usuario. Si no lo encuentra o se produce algún error, devuelve un usuario con parámetros vacíos.
     */
    public User getUser(Long id);

    /**
     * Crea un nuevo usuario.
     * @param user
     * @return El usuario creado.
     */
    public User createUser(User user);
}
