package com.musica.apimusica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class AlbumDTO {

    public Long id;

    @NotBlank
    @Size(max = 255)
    public String nome;

    @NotNull
    public Long artistaId;

    public List<Long> musicas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(Long artistaId) {
        this.artistaId = artistaId;
    }

    public List<Long> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Long> musicas) {
        this.musicas = musicas;
    }
}
