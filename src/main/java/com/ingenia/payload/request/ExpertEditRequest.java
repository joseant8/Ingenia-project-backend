package com.ingenia.payload.request;

public class ExpertEditRequest {

    private String nombre;

    private String nif;

    private String contacto_telefono;

    private String contacto_email;

    private int[] ids_etiquetas;

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

    public int[] getIds_etiquetas() {
        return ids_etiquetas;
    }

    public void setIds_etiquetas(int[] ids_etiquetas) {
        this.ids_etiquetas = ids_etiquetas;
    }
}
