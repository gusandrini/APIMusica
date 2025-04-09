package com.musica.apimusica.dto;

import jakarta.validation.constraints.*;

public class ArtistaDTO {
    public Long id;

    @NotBlank
    public String nome;

    @Size(max = 255)
    public String estilo;

    @Email
    public String email;

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

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}