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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ExpertDAOImpl implements ExpertDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private ExpertRepository repository;


    // --------------------------
    // Recuperar/filtros
    // --------------------------

    /**
     * Obtener todos los expertos de la BD.
     * @return Lista de expertos.
     */
    @Override
    public List<Expert> getAllExperts() {
        List<Expert> lista = manager.createQuery("from Expert", Expert.class).getResultList();
        return lista;
    }

    /**
     * Obtener un experto por su id.
     * @param id
     * @return Experto de la BD. Si no lo encuentra o se produce algún error, devuelve experto con parámetros vacíos.
     */
    @Override
    public Expert getExpert(Long id) {
        try{
            Expert expertoBD = manager.find(Expert.class, id);
            if(expertoBD == null){
                return new Expert();
            }else{
                return expertoBD;
            }
        }catch(Exception e){
            return new Expert();
        }
    }

    /**
     * Filtra los expertos con el nombre o parte de él que se pasa como parámetro.
     * @param substring nombre o subnombre
     * @return Lista de expertos filtrada.
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
     * Crea un experto nuevo.
     * @param expert experto
     * @return El experto creado.
     */
    @Override
    public Expert createExpert(Expert expert) {
        return repository.save(expert);
    }


    // --------------------------
    // Actualizar
    // --------------------------

    /**
     * Actualiza un experto ya existente.
     * @param id
     * @param expertUpdated experto
     * @return Experto actualizado. Si no se encuentra en la BD, devuelve un experto con parámetros vacíos.
     */
    @Override
    public Expert updateExpert(Long id, Expert expertUpdated) {
        Optional<Expert> expertoBD = Optional.empty();
        if(id != null){
            expertoBD = repository.findById(id);
        }

        if(expertoBD.isPresent()){
            expertUpdated.setUpdated_at(new Date());
            return repository.save(expertUpdated);
        }else{
            return new Expert();
        }

    }


    // --------------------------
    // Eliminar
    // --------------------------

    /**
     * Elimina un experto de la BD.
     * @param id
     * @return True si se ha eliminado y false si no se ha encontrado en la BD.
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
