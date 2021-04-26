package com.ingenia.dao.impl;

import com.ingenia.dao.ExpertDAO;
import com.ingenia.model.Expert;
import com.ingenia.payload.request.ExpertEditRequest;
import com.ingenia.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
     * Obtener todos los expertos de la BD con paginación.
     * @return Lista de expertos paginada.
     */
    @Override
    public Page<Expert> getAllExpertsPaging(Pageable paging) {
        return repository.findAll(paging);
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
     * @param expertUpdated petición de actualización del experto
     * @return Experto actualizado. Si no se encuentra en la BD, devuelve un experto con parámetros vacíos.
     */
    @Override
    public Expert updateExpert(Long id, ExpertEditRequest expertUpdated) {
        Optional<Expert> expertoBD = Optional.empty();
        if(id != null){
            expertoBD = repository.findById(id);
        }

        if(expertoBD.isPresent()){
            //
            if(expertUpdated.getNombre() != null){
                expertoBD.get().setNombre(expertUpdated.getNombre());
            }
            if(expertUpdated.getNif() != null){
                expertoBD.get().setNif(expertUpdated.getNif());
            }
            if(expertUpdated.getContacto_telefono() != null){
                expertoBD.get().setContacto_telefono(expertUpdated.getContacto_telefono());
            }
            if(expertUpdated.getContacto_email() != null){
                expertoBD.get().setContacto_email(expertUpdated.getContacto_email());
            }

            expertoBD.get().setUpdated_at(new Date());
            return repository.save(expertoBD.get());
        }else{
            return new Expert();
        }

    }


    // --------------------------
    // Eliminar
    // --------------------------

    /**
     * Elimina un experto de la BD. También elimina todas las asociaciones de ese experto y etiquetas relacionadas.
     * @param id
     * @return True si se ha eliminado y false si no se ha encontrado en la BD.
     */
    @Override
    public boolean deleteExpert(Long id) {
        Optional<Expert> expertoBD = repository.findById(id);

        if(expertoBD.isPresent()){
            expertoBD.get().setEtiquetas(null);   // para eliminar todas las asociaciones entre el experto y las etiquetas relacionadas
            repository.delete(expertoBD.get());
            return true;
        }else{
            return false;
        }
    }
}
