package com.musica.apimusica.mapper;

import com.musica.apimusica.dto.ArtistaDTO;
import com.musica.apimusica.model.Artista;

public class ArtistaMapper {
    public static ArtistaDTO toDTO(Artista a) {
        ArtistaDTO dto = new ArtistaDTO();
        dto.id = a.getId();
        dto.nome = a.getNome();
        dto.estilo = a.getEstilo();
        dto.email = a.getEmail();
        return dto;
    }

    public static Artista toEntity(ArtistaDTO dto) {
        Artista a = new Artista();
        a.setId(dto.id);
        a.setNome(dto.nome);
        a.setEstilo(dto.estilo);
        a.setEmail(dto.email);
        return a;
    }
}