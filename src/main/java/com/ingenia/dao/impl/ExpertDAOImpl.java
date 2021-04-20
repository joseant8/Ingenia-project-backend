package com.ingenia.dao.impl;

import com.ingenia.dao.ExpertDAO;
import com.ingenia.model.Expert;
import com.ingenia.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExpertRepository repository;


    // --------------------------
    // Consultas/filtros
    // --------------------------

    /**
     * Método para obtener todos los expertos de la BD
     * @return lista de expertos
     */
    @Override
    public List<Expert> getAllExperts() {
        List<Expert> lista = manager.createQuery("from Expert", Expert.class).getResultList();
        return lista;
    }

    /**
     * Método para obtener un experto según su id
     * @param id
     * @return
     */
    @Override
    public Expert getExpert(Long id) {
        return manager.find(Expert.class, id);
    }

    /**
     * Obtener los expertos por nombre o parte de él
     * @param substring con el nombre completo o parte de él
     * @return lista filtrada de expertos
     */
    @Override
    public List<Expert> filterByNameContains(String substring) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        criteria.where(builder.like(root.get("nombre"), "%"+substring+"%"));

        return manager.createQuery(criteria).getResultList();
    }


    // --------------------------
    // Crear
    // --------------------------

    /**
     * Método para crear un nuevo experto
     * @param expert
     * @return
     */
    @Override
    public Expert createExpert(Expert expert) {
        return repository.save(expert);
    }


    // --------------------------
    // Actualizar
    // --------------------------

    /**
     * Actualiza un experto ya existente por su id
     * @param id
     * @param expertUpdated
     * @return experto actualizado si se ha podido actualizar y experto sin campos si no se ha encontrado en la BD
     */
    @Override
    public Expert updateExpert(Long id, Expert expertUpdated) {
        Optional<Expert> expertoBD = repository.findById(id);
        if(expertoBD.isPresent()){
            expertUpdated.setUpdated_at(LocalDate.now());
            return repository.save(expertUpdated);
        }
        return new Expert();
    }


    // --------------------------
    // Eliminar
    // --------------------------

    /**
     * Elimina un experto de la BD. Devuelve true si se ha eliminado y false si no se ha encontrado
     * @param id
     * @return boolean
     */
    @Override
    public boolean deleteExpert(Long id) {
        Optional<Expert> expertoBD = repository.findById(id);

        if(expertoBD.isPresent()){
            repository.delete(expertoBD.get());
            return true;
        }else{
            return false;
        }
    }
}
