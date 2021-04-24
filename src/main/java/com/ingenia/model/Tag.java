package com.ingenia.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Date created_at;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creador;

    //@ManyToMany(mappedBy = "etiquetas")   // si lo hago así no sería 'owner' (más problemas luego para desasociar relaciones con expertos desde la entidad etiqueta)
    @ManyToMany
    @JoinTable(
            name = "expert_tag",
            joinColumns = {@JoinColumn(name="tag_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="expert_id", referencedColumnName = "id")}
    )
    @JsonIgnore    // Para evitar en la respuesta json la recursión infinita en relaciones bidireccionales
    private List<Expert> expertos = new ArrayList<>();

    public Tag() {
    }

    public Tag(String nombre, Date created_at, User creador) {
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

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
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
