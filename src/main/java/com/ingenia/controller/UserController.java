package com.ingenia.controller;

import com.ingenia.model.User;
import com.ingenia.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/API")
@CrossOrigin(origins = "https://ingenia-project-frontend-app.vercel.app", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    // --------------------------
    // Recuperar
    // --------------------------

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        User usuarioBD = service.getUser(id);
        if(usuarioBD != null){
            return ResponseEntity.ok().body(usuarioBD);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // --------------------------
    // Crear
    // --------------------------

    @PostMapping("/usuarios")
    public ResponseEntity<User> createExpert(@RequestBody User usuario) throws URISyntaxException {
        if(usuario.getId() != null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User usuarioCreado = service.createUser(usuario);
        return ResponseEntity.created(new URI("/API/usuarios/" + usuarioCreado.getId())).body(usuarioCreado);
    }

}
