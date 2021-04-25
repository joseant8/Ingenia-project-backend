package com.ingenia.dao.impl;

import com.ingenia.dao.TagDAO;
import com.ingenia.model.Tag;
import com.ingenia.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class TagDAOImpl implements TagDAO {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private TagRepository repository;

    // --------------------------
    // Recuperar
    // --------------------------

    /**
     * Obtiene todas las etiquetas de la BD.
     * @return Lista de etiquetas.
     */
    @Override
    public List<Tag> getAllTags() {
        return manager.createQuery("from Tag", Tag.class).getResultList();
    }

    /**
     * Obtiene una etiqueta según su id.
     * @param id
     * @return Etiqueta. Si no la encuentra o se produce algún error, devuelve etiqueta con parámetros vacíos.
     */
    @Override
    public Tag getTag(Long id) {
        try{
            Tag etiquetaBD = manager.find(Tag.class, id);
            if(etiquetaBD == null){
                return new Tag();
            }else{
                return etiquetaBD;
            }
        }catch(Exception e){
            return new Tag();
        }
    }

    // --------------------------
    // Crear
    // --------------------------

    /**
     * Crea una nueva etiqueta.
     * @param tag
     * @return Etiqueta creada.
     */
    @Override
    public Tag createTag(Tag tag) {
        tag.setCreated_at(new Date());
        return repository.save(tag);
    }

    // --------------------------
    // Eliminar
    // --------------------------

    /**
     * Elimina una etiqueta de la BD. También elimina todas las asociaciones entre esa etiqueta y los expertos relacionados.
     * @param id
     * @return True si se ha eliminado correctamente y false si no se ha encontrado.
     */
    @Override
    public boolean deleteTag(Long id) {
        Optional<Tag> etiquetaBD = repository.findById(id);
        if(etiquetaBD.isPresent()){
            etiquetaBD.get().setExpertos(null);  // para eliminar todas las asociaciones entre esa etiqueta y los expertos relacionados
            repository.delete(etiquetaBD.get());
            return true;
        }else{
            return false;
        }
    }
}
