package com.ingenia.service;

import com.ingenia.model.Tag;
import com.ingenia.payload.request.TagRequest;

import java.util.List;

public interface TagService {

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


    // otros métodos

    /**
     * Transforma los datos de la petición de creación de etiqueta en objeto 'Tag' (modelo).
     * @param request
     * @return Etiqueta
     */
    public Tag transformToTag(TagRequest request);


    /**
     * Comprueba si el nombre de la etiqueta ya existe en la BD.
     * @return Tru si existe y false en caso contrario.
     */
    public boolean nameTagAlreadyExists(String name);

}
