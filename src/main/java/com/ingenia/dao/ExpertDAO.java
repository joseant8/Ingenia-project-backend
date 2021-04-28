package com.ingenia.dao;

import com.ingenia.model.Expert;
import com.ingenia.payload.request.ExpertEditRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpertDAO {

    // recuperar/filtros

    /**
     * Obtener todos los expertos de la BD.
     * @return Lista de expertos.
     */
    public List<Expert> getAllExperts();


    /**
     * Obtener un experto por su id.
     * @param id
     * @return Experto de la BD. Si no lo encuentra, devuelve experto con parámetros vacíos.
     */
    public Expert getExpert(Long id);


    /**
     * Filtra los expertos con el nombre o parte de él que se pasa como parámetro.
     * @param name nombre o subnombre
     * @return Lista de expertos filtrada.
     */
    public List<Expert> filterByNameContains(String name);


    /**
     * Filtra los expertos según el estado.
     * @param state estado
     * @return Lista de expertos filtrada.
     */
    public List<Expert> filterByState(String state);


    /**
     * Filtra los expertos que contengan la etiqueta indicada.
     * @param nameTag nombre etiqueta
     * @return Lista de expertos filtrada.
     */
    public List<Expert> filterByTag(String nameTag);


    /**
     * Filtra los expertos con la puntuación indicada.
     * @param puntuacion
     * @return Lista de expertos filtrada.
     */
    public List<Expert> filterByPunctuation(Integer puntuacion);

    // crear

    /**
     * Crea un experto nuevo.
     * @param expert experto
     * @return El experto creado.
     */
    public Expert createExpert(Expert expert);

    // actualizar

    /**
     * Actualiza un experto ya existente.
     * @param id
     * @param expertUpdated request
     * @return Experto actualizado. Si no se encuentra en la BD, devuelve un experto con parámetros vacíos.
     */
    public Expert updateExpert(Long id, ExpertEditRequest expertUpdated);

    // eliminar

    /**
     * Elimina un experto de la BD. También elimina todas las asociaciones de ese experto y etiquetas relacionadas.
     * @param id
     * @return True si se ha eliminado y false si no se ha encontrado en la BD.
     */
    public boolean deleteExpert(Long id);

}
