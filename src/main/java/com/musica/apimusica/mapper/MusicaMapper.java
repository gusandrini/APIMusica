package com.musica.apimusica.mapper;

import com.musica.apimusica.dto.MusicaDTO;
import com.musica.apimusica.model.Artista;
import com.musica.apimusica.model.Musica;
import com.musica.apimusica.model.Album;

public class MusicaMapper {

    public static MusicaDTO toDTO(Musica m) {
        MusicaDTO dto = new MusicaDTO();
        dto.id = m.getId();
        dto.titulo = m.getTitulo();
        dto.duracaoSegundos = m.getDuracaoSegundos();
        dto.artistaId = m.getArtista().getId();
        dto.albumId = m.getAlbum().getId();
        return dto;
    }

    public static Musica toEntity(MusicaDTO dto, Artista artista, Album album) {
        Musica m = new Musica();
        m.setId(dto.id);
        m.setTitulo(dto.titulo);
        m.setDuracaoSegundos(dto.duracaoSegundos);
        m.setArtista(artista);
        m.setAlbum(album);
        return m;
    }
}
