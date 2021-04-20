package com.ingenia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "creador", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Tag> etiquetas = new ArrayList<>();

    public User() {
    }

    public User(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
