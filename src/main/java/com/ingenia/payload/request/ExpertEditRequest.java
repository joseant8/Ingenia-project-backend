package com.ingenia.payload.request;

import com.ingenia.model.State;

import java.util.List;

public class ExpertEditRequest {

    private String nombre;

    private String nif;

    private String contacto_telefono;

    private String contacto_email;

    private List<Long> ids_etiquetas;

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

    public List<Long> getIds_etiquetas() {
        return ids_etiquetas;
    }

    public void setIds_etiquetas(List<Long> ids_etiquetas) {
        this.ids_etiquetas = ids_etiquetas;
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
