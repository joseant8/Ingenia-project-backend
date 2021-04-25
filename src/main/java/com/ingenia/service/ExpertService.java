package com.ingenia.service;

import com.ingenia.model.Expert;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpertService {

    // recuperar/filtros

    /**
     * Obtener todos los expertos de la BD.
     * @return Lista de expertos.
     */
    public List<Expert> getAllExperts();

    /**
     * Obtener todos los expertos de la BD con paginación.
     * @return Lista de expertos paginada.
     */
    public Page<Expert> getAllExpertsPaging(Pageable paging);

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
     * @param expert experto
     * @return Experto actualizado. Si no se encuentra en la BD, devuelve un experto con parámetros vacíos (no se guarda en la BD).
     */
    public Expert updateExpert(Long id, Expert expert);

    // eliminar

    /**
     * Elimina un experto de la BD. También elimina todas las asociaciones entre ese experto y las etiquetas relacionadas.
     * @param id
     * @return True si se ha eliminado y false si no se ha encontrado en la BD.
     */
    public boolean deleteExpert(Long id);
}
