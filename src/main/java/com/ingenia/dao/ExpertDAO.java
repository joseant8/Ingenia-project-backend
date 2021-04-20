package com.ingenia.dao;

import com.ingenia.model.Expert;

import java.util.List;

public interface ExpertDAO {

    // consultas y filtros

    /**
     * Método para obtener todos los expertos de la BD
     * @return lista de expertos
     */
    public List<Expert> getAllExperts();

    /**
     * Método para obtener un experto según su id
     * @param id
     * @return
     */
    public Expert getExpert(Long id);

    /**
     * Obtener los expertos por nombre o parte de él
     * @param name nombre completo o parte de él
     * @return lista filtrada de expertos
     */
    public List<Expert> filterByNameContains(String name);

    // crear

    /**
     * Método para crear un nuevo experto
     * @param expert experto
     * @return
     */
    public Expert createExpert(Expert expert);

    // actualizar

    /**
     * Actualiza un experto ya existente por su id
     * @param id
     * @param expertUpdated
     * @return experto actualizado si se ha podido actualizar y null si no se ha encontrado
     */
    public Expert updateExpert(Long id, Expert expertUpdated);

    // eliminar

    /**
     * Elimina un experto de la BD. Devuelve true si se ha eliminado y false si no se ha encontrado
     * @param id
     * @return boolean
     */
    public boolean deleteExpert(Long id);

}
