package com.musica.apimusica.mapper;

import com.musica.apimusica.dto.AlbumDTO;
import com.musica.apimusica.model.Album;
import com.musica.apimusica.model.Artista;

public class AlbumMapper {

    public static AlbumDTO toDTO(Album album) {
        AlbumDTO dto = new AlbumDTO();
        dto.id = album.getId();
        dto.nome = album.getNome();
        dto.artistaId = album.getArtista().getId();
        return dto;
    }

    public static Album toEntity(AlbumDTO dto, Artista artista) {
        Album album = new Album();
        album.setId(dto.id);
        album.setNome(dto.nome);
        album.setArtista(artista);
        return album;
    }
}
