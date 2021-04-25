package com.ingenia.controller;

import com.ingenia.model.Expert;
import com.ingenia.service.ExpertService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/API")
public class ExpertController {

    private ExpertService service;

    public ExpertController(ExpertService service) {
        this.service = service;
    }

    // -----------------------------
    // Recuperar/filtros
    // -----------------------------

    @GetMapping("/expertos")
    public List<Expert> getAllExperts(){
        return service.getAllExperts();
    }


    // Paginación
    @GetMapping("/expertos/paginacion")
    public List<Expert> getAllExpertsPaged() {

        Pageable paging = PageRequest.of(1, 5);
        Page<Expert> pagedResult = service.getAllExpertsPaging(paging);
        List<Expert> listP = pagedResult.getContent();
        return listP;
    }


    @GetMapping("/expertos/{id}")
    public ResponseEntity<Expert> getExpert(@PathVariable Long id){
        Expert expertoBD = service.getExpert(id);
        if(expertoBD != null){
            return ResponseEntity.ok().body(expertoBD);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/expertos/nombre/{name}")
    public List<Expert> filterByNameContains(@PathVariable String name){
        return service.filterByNameContains(name);
    }


    // --------------------------
    // Crear
    // --------------------------

    @PostMapping("/expertos")
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException {
        if(expert.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Expert expertoCreado = service.createExpert(expert);
        return ResponseEntity.created(new URI("/API/expertos/" + expertoCreado.getId())).body(expertoCreado);
    }


    // --------------------------
    // Actualizar
    // --------------------------

    @PutMapping("/expertos/{id}")
    public ResponseEntity<Expert> updateExpert(@PathVariable Long id, @RequestBody Expert expert){
        if(expert.getId() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Expert expertoActualizado = service.updateExpert(id, expert);

        if(expertoActualizado.getId() != null){
            return ResponseEntity.ok().body(expertoActualizado);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    // --------------------------
    // Eliminar
    // --------------------------

    @DeleteMapping("/expertos/{id}")
    public ResponseEntity<Void> deleteExpert(@PathVariable Long id){
        if(service.deleteExpert(id)){
            return ResponseEntity.noContent().build();
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
