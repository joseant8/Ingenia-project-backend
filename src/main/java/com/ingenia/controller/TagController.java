package com.ingenia.controller;

import com.ingenia.model.Tag;
import com.ingenia.payload.request.TagRequest;
import com.ingenia.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "https://ingenia-project-frontend-app.vercel.app"}, methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
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
    public List<Tag> getAllTags(@RequestParam(name="nombre", required = false) String nombre, @RequestParam(name="orden", required = false) String orden){
        if(nombre != null){
            return service.tagsFilterByNameContains(nombre);
        }else if(orden != null){
            return service.getAllTagsOrdered(orden);
        }
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
    public ResponseEntity<Tag> createTag(@RequestBody TagRequest tag) throws URISyntaxException {

        if(tag.getNombreTag() != null){
            if(service.nameTagAlreadyExists(tag.getNombreTag())){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Tag etiquetaCreada = service.createTag(service.transformToTag(tag));
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
