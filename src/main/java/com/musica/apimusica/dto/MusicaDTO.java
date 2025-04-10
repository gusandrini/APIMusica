package com.musica.apimusica.dto;

import jakarta.validation.constraints.*;

public class MusicaDTO {
    public Long id;

    @NotBlank
    public String titulo;

    @Positive
    public int duracaoSegundos;

    @NotNull
    public Long artistaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public Long albumId;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos) {
        this.duracaoSegundos = duracaoSegundos;
    }

    public Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Long artistaId) {
        this.artistaId = artistaId;
    }
}