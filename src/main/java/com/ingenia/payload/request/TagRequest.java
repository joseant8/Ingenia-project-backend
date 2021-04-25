package com.ingenia.payload.request;

public class TagRequest {

    private String nombreTag;

    private String usernameCreador;

    public TagRequest(String nombreTag, String usernameCreador) {
        this.nombreTag = nombreTag;
        this.usernameCreador = usernameCreador;
    }

    public String getNombreTag() {
        return nombreTag;
    }

    public void setNombreTag(String nombreTag) {
        this.nombreTag = nombreTag;
    }

    public String getUsernameCreador() {
        return usernameCreador;
    }

    public void setUsernameCreador(String usernameCreador) {
        this.usernameCreador = usernameCreador;
    }
}
