package com.ingenia.dao.impl;

import com.ingenia.dao.ExpertDAO;
import com.ingenia.model.Expert;
import com.ingenia.model.State;
import com.ingenia.model.Tag;
import com.ingenia.payload.request.ExpertEditRequest;
import com.ingenia.repository.ExpertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    /**
     * Filtra los expertos según el estado.
     * @param state estado
     * @return Lista de expertos filtrada.
     */
    @Override
    public List<Expert> filterByState(String state) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        State estado;
        if(state.equals("validado")){
            estado = State.VALIDADO;
        }else if(state.equals("pendiente")){
            estado = State.PENDIENTE;
        }else{
            return getAllExperts();
        }

        criteria.where(builder.equal(root.get("estado"), estado));

        return manager.createQuery(criteria).getResultList();
    }

    /**
     * Filtra los expertos que contengan la etiqueta indicada.
     * @param nameTag nombre etiqueta
     * @return Lista de expertos filtrada o lista vacía si no se ha encontrado la etiqueta.
     */
    @Override
    public List<Expert> filterByTag(String nameTag) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Tag> criteria = builder.createQuery(Tag.class);
        Root<Tag> root = criteria.from(Tag.class);

        criteria.where(builder.equal(root.get("nombre"), nameTag));
        Tag etiqueta = manager.createQuery(criteria).getSingleResult();

        if(etiqueta != null){
            return etiqueta.getExpertos();
        }else{
            return new ArrayList<>();
        }

    }

    /**
     * Filtra los expertos con la puntuación indicada.
     * @param puntuacion
     * @return Lista de expertos filtrada.
     */
    @Override
    public List<Expert> filterByPunctuation(Integer puntuacion) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Expert> criteria = builder.createQuery(Expert.class);
        Root<Expert> root = criteria.from(Expert.class);

        criteria.where(builder.equal(root.get("puntuacion"), puntuacion));

        return manager.createQuery(criteria).getResultList();
    }

    /**
     * Obtiene la todas los expertos de la BD ordenadas ASC o DESC según se indique por parámeto.
     * @param order ordenado (ASC o DESC)
     * @return Lista ordenada de expertos.
     */
    @Override
    public List<Expert> getAllExpertsOrdered(String order) {
        if(order.equals("DESC")){
            return repository.findAll(Sort.by(Sort.Direction.DESC, "nombre"));
        }else{
            return repository.findAll(Sort.by(Sort.Direction.ASC, "nombre"));
        }
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
            if(expertUpdated.getEtiqueta_add_id() != null){
                Tag tag = manager.find(Tag.class, expertUpdated.getEtiqueta_add_id());
                expertoBD.get().getEtiquetas().add(tag);
            }
            if(expertUpdated.getEtiqueta_delete_id() != null){
                Tag tag = manager.find(Tag.class, expertUpdated.getEtiqueta_delete_id());
                expertoBD.get().getEtiquetas().remove(tag);
            }
            if(expertUpdated.getDireccion() != null){
                expertoBD.get().setDireccion(expertUpdated.getDireccion());
            }
            if(expertUpdated.getContacto_linkedin() != null){
                expertoBD.get().setContacto_linkedin(expertUpdated.getContacto_linkedin());
            }
            if(expertUpdated.getDisponibilidad() != null){
                expertoBD.get().setDisponibilidad(expertUpdated.getDisponibilidad());
            }
            if(expertUpdated.getEstado() != null){
                expertoBD.get().setEstado(expertUpdated.getEstado());
            }
            if(expertUpdated.getPuntuacion() != null){
                expertoBD.get().setPuntuacion(expertUpdated.getPuntuacion());
            }
            if(expertUpdated.getObservaciones() !=null){
                expertoBD.get().setObservaciones(expertUpdated.getObservaciones());
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
