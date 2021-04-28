package com.ingenia.controller;

import com.ingenia.model.Expert;
import com.ingenia.payload.request.ExpertEditRequest;
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
@CrossOrigin(origins = {"http://localhost:4200", "https://ingenia-project-frontend-app.vercel.app/login"}, methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
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
    public List<Expert> getAllExperts(@RequestParam(name="nombre", required = false) String nombre,
                                      @RequestParam(name="estado", required = false) String estado,
                                      @RequestParam(name="etiqueta", required = false) String etiqueta,
                                      @RequestParam(name="valoracion", required = false) Integer valoracion){

        if(nombre != null){
            return service.filterByNameContains(nombre);
        }else if(estado != null){    // todos, validado, pendiente
            return service.filterByState(estado);
        }else if(etiqueta != null){
            return service.filterByTag(etiqueta);
        }else if(valoracion != null){
            return service.filterByPunctuation(valoracion);
        }
        return service.getAllExperts();
    }



    @GetMapping("/expertos/{id}")
    public ResponseEntity<Expert> getExpert(@PathVariable Long id){
        Expert expertoBD = service.getExpert(id);
        if(expertoBD != null){
            return ResponseEntity.ok().body(expertoBD);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public ResponseEntity<Expert> updateExpert(@PathVariable Long id, @RequestBody ExpertEditRequest request){

        Expert expertoActualizado = service.updateExpert(id, request);

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
