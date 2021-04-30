package com.ingenia.payload.request;

import com.ingenia.model.State;
import com.ingenia.model.Tag;

import java.util.List;

public class ExpertEditRequest {

    private String nombre;

    private String nif;

    private String contacto_telefono;

    private String contacto_email;

    private Long etiqueta_add_id;

    private Long etiqueta_delete_id;

    private String direccion;

    private String contacto_linkedin;

    private String disponibilidad;

    private State estado;

    private Integer puntuacion;

    private String observaciones;

    public ExpertEditRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
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

    public Long getEtiqueta_add_id() {
        return etiqueta_add_id;
    }

    public void setEtiqueta_add_id(Long etiqueta_add_id) {
        this.etiqueta_add_id = etiqueta_add_id;
    }

    public Long getEtiqueta_delete_id() {
        return etiqueta_delete_id;
    }

    public void setEtiqueta_delete_id(Long etiqueta_delete_id) {
        this.etiqueta_delete_id = etiqueta_delete_id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContacto_linkedin() {
        return contacto_linkedin;
    }

    public void setContacto_linkedin(String contacto_linkedin) {
        this.contacto_linkedin = contacto_linkedin;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public State getEstado() {
        return estado;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
