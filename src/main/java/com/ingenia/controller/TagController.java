package com.ingenia.controller;

import com.ingenia.model.Tag;
import com.ingenia.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/API")
public class TagController {

    private TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    // -----------------------------
    // Recuperar
    // -----------------------------

    @GetMapping("/etiquetas")
    public List<Tag> getAllTags(){
        return service.getAllTags();
    }


    @GetMapping("/etiquetas/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id){
        Tag etiqueta = service.getTag(id);
        if(etiqueta != null){
            return ResponseEntity.ok().body(etiqueta);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // --------------------------
    // Crear
    // --------------------------

    @PostMapping("/etiquetas")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) throws URISyntaxException {
        if(tag.getId() == null){
            System.out.println("Contenido id: "+tag.getId());
            Tag etiquetaCreada = service.createTag(tag);
            System.out.println("Crea etiqueta nueva");
            return ResponseEntity.created(new URI("/API/etiquetas/" + etiquetaCreada.getId())).body(etiquetaCreada);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // --------------------------
    // Eliminar
    // --------------------------

    @DeleteMapping("/etiquetas/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        if(service.deleteTag(id)){
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
