package com.ingenia.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Expert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @CreatedDate
    private LocalDate created_at = LocalDate.now();

    @LastModifiedDate
    private LocalDate updated_at = LocalDate.now();

    private String estado_motivo;

    private String disponibilidad;

    private String modalidad;

    private Boolean autonomo;

    private String contacto_telefono;

    private String contacto_email;

    private String contacto_ciudad;

    private String contacto_linkedin;

    private String condiciones_porcentaje;

    private String condiciones_precio_hora;

    private Integer puntuacion;

    private String nif;

    private String credenciales_correo;

    private String credenciales_correo_password;

    private String credenciales_zoom;

    private String credenciales_zoom_password;

    private String fichero_foto;

    private String fichero_cv;

    private String observaciones;

    private String origen;

    private State estado;

    @ManyToMany
    @JoinTable(
            name = "expert_tag",
            joinColumns = {@JoinColumn(name="expert_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="tag_id", referencedColumnName = "id")}
    )
    private List<Tag> etiquetas = new ArrayList<>();

    public Expert() {
    }

    public Expert(String nombre, String estado_motivo, String disponibilidad, String modalidad, Boolean autonomo, String contacto_telefono, String contacto_email, String contacto_ciudad, String contacto_linkedin, String condiciones_porcentaje, String condiciones_precio_hora, Integer puntuacion, String nif, String credenciales_correo, String credenciales_correo_password, String credenciales_zoom, String credenciales_zoom_password, String fichero_foto, String fichero_cv, String observaciones, String origen, State estado) {
        this.nombre = nombre;
        this.estado_motivo = estado_motivo;
        this.disponibilidad = disponibilidad;
        this.modalidad = modalidad;
        this.autonomo = autonomo;
        this.contacto_telefono = contacto_telefono;
        this.contacto_email = contacto_email;
        this.contacto_ciudad = contacto_ciudad;
        this.contacto_linkedin = contacto_linkedin;
        this.condiciones_porcentaje = condiciones_porcentaje;
        this.condiciones_precio_hora = condiciones_precio_hora;
        this.puntuacion = puntuacion;
        this.nif = nif;
        this.credenciales_correo = credenciales_correo;
        this.credenciales_correo_password = credenciales_correo_password;
        this.credenciales_zoom = credenciales_zoom;
        this.credenciales_zoom_password = credenciales_zoom_password;
        this.fichero_foto = fichero_foto;
        this.fichero_cv = fichero_cv;
        this.observaciones = observaciones;
        this.origen = origen;
        this.estado = estado;
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

    public LocalDate getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDate updated_at) {
        this.updated_at = updated_at;
    }

    public String getEstado_motivo() {
        return estado_motivo;
    }

    public void setEstado_motivo(String estado_motivo) {
        this.estado_motivo = estado_motivo;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public Boolean getAutonomo() {
        return autonomo;
    }

    public void setAutonomo(Boolean autonomo) {
        this.autonomo = autonomo;
    }

    public String getContacto_telefono() {
        return contacto_telefono;
    }

    public void setContacto_telefono(String contacto_telefono) {
        this.contacto_telefono = contacto_telefono;
    }

    public String getContacto_email() {
        return contacto_email;
    }

    public void setContacto_email(String contacto_email) {
        this.contacto_email = contacto_email;
    }

    public String getContacto_ciudad() {
        return contacto_ciudad;
    }

    public void setContacto_ciudad(String contacto_ciudad) {
        this.contacto_ciudad = contacto_ciudad;
    }

    public String getContacto_linkedin() {
        return contacto_linkedin;
    }

    public void setContacto_linkedin(String contacto_linkedin) {
        this.contacto_linkedin = contacto_linkedin;
    }

    public String getCondiciones_porcentaje() {
        return condiciones_porcentaje;
    }

    public void setCondiciones_porcentaje(String condiciones_porcentaje) {
        this.condiciones_porcentaje = condiciones_porcentaje;
    }

    public String getCondiciones_precio_hora() {
        return condiciones_precio_hora;
    }

    public void setCondiciones_precio_hora(String condiciones_precio_hora) {
        this.condiciones_precio_hora = condiciones_precio_hora;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getCredenciales_correo() {
        return credenciales_correo;
    }

    public void setCredenciales_correo(String credenciales_correo) {
        this.credenciales_correo = credenciales_correo;
    }

    public String getCredenciales_correo_password() {
        return credenciales_correo_password;
    }

    public void setCredenciales_correo_password(String credenciales_correo_password) {
        this.credenciales_correo_password = credenciales_correo_password;
    }

    public String getCredenciales_zoom() {
        return credenciales_zoom;
    }

    public void setCredenciales_zoom(String credenciales_zoom) {
        this.credenciales_zoom = credenciales_zoom;
    }

    public String getCredenciales_zoom_password() {
        return credenciales_zoom_password;
    }

    public void setCredenciales_zoom_password(String credenciales_zoom_password) {
        this.credenciales_zoom_password = credenciales_zoom_password;
    }

    public String getFichero_foto() {
        return fichero_foto;
    }

    public void setFichero_foto(String fichero_foto) {
        this.fichero_foto = fichero_foto;
    }

    public String getFichero_cv() {
        return fichero_cv;
    }

    public void setFichero_cv(String fichero_cv) {
        this.fichero_cv = fichero_cv;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public List<Tag> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Tag> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
