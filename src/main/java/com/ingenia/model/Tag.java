package com.ingenia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private LocalDate created_at;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creador;

    @ManyToMany(mappedBy = "etiquetas")
    @JsonIgnore    // Para evitar en la respuesta json la recursión infinita en relaciones bidireccionales
    private List<Expert> expertos = new ArrayList<>();

    public Tag() {
    }

    public Tag(String nombre, LocalDate created_at, User creador) {
        this.nombre = nombre;
        this.created_at = created_at;
        this.creador = creador;
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

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public User getCreador() {
        return creador;
    }

    public void setCreador(User creador) {
        this.creador = creador;
    }

    public List<Expert> getExpertos() {
        return expertos;
    }

    public void setExpertos(List<Expert> expertos) {
        this.expertos = expertos;
    }
}
