package com.ingenia.dao;

import com.ingenia.model.Tag;

import java.util.List;

public interface TagDAO {

    // recuperar

    /**
     * Obtiene todas las etiquetas de la BD.
     * @return Lista de etiquetas.
     */
    public List<Tag> getAllTags();

    /**
     * Obtiene una etiqueta según su id.
     * @param id
     * @return Etiqueta.
     */
    public Tag getTag(Long id);


    // crear

    /**
     * Crea una nueva etiqueta.
     * @param tag
     * @return Etiqueta creada. Si no se encuentra en la BD, devuelve una etiqueta con parámetros vacíos.
     */
    public Tag createTag(Tag tag);


    // eliminar

    /**
     * Elimina una etiqueta de la BD. También elimina todas las asociaciones entre esa etiqueta y los expertos relacionados.
     * @param id
     * @return True si se ha eliminado correctamente y false si no se ha encontrado.
     */
    public boolean deleteTag(Long id);
}
