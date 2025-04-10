package com.musica.apimusica.service;

import com.musica.apimusica.dto.MusicaDTO;
import com.musica.apimusica.mapper.MusicaMapper;
import com.musica.apimusica.model.Artista;
import com.musica.apimusica.model.Musica;
import com.musica.apimusica.model.Album;
import com.musica.apimusica.repository.ArtistaRepository;
import com.musica.apimusica.repository.MusicaRepository;
import com.musica.apimusica.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaService {

    @Autowired
    private MusicaRepository musicaRepo;

    @Autowired
    private ArtistaRepository artistaRepo;

    @Autowired
    private AlbumRepository albumRepo;

    public MusicaDTO criar(MusicaDTO dto) {
        Artista artista = artistaRepo.findById(dto.artistaId)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado com ID: " + dto.artistaId));

        Album album = albumRepo.findById(dto.albumId)
                .orElseThrow(() -> new RuntimeException("Álbum não encontrado com ID: " + dto.albumId));

        Musica musica = MusicaMapper.toEntity(dto, artista, album);
        return MusicaMapper.toDTO(musicaRepo.save(musica));
    }

    public List<MusicaDTO> listarTodos() {
        return musicaRepo.findAll().stream().map(MusicaMapper::toDTO).collect(Collectors.toList());
    }

    public MusicaDTO buscarPorId(Long id) {
        return musicaRepo.findById(id).map(MusicaMapper::toDTO).orElseThrow(() -> new RuntimeException("Música não encontrada com ID: " + id));
    }

    public MusicaDTO atualizar(Long id, MusicaDTO dto) {
        Musica existente = musicaRepo.findById(id).orElseThrow(() -> new RuntimeException("Música não encontrada com ID: " + id));

        Artista artista = artistaRepo.findById(dto.artistaId).orElseThrow(() -> new RuntimeException("Artista não encontrado com ID: " + dto.artistaId));
        Album album = albumRepo.findById(dto.albumId).orElseThrow(() -> new RuntimeException("Álbum não encontrado com ID: " + dto.albumId));

        existente.setTitulo(dto.titulo);
        existente.setDuracaoSegundos(dto.duracaoSegundos);
        existente.setArtista(artista);
        existente.setAlbum(album);

        return MusicaMapper.toDTO(musicaRepo.save(existente));
    }

    public void deletar(Long id) {
        musicaRepo.deleteById(id);
    }
}
