package com.musica.apimusica.service;

import com.musica.apimusica.dto.AlbumDTO;
import com.musica.apimusica.mapper.AlbumMapper;
import com.musica.apimusica.model.Album;
import com.musica.apimusica.model.Artista;
import com.musica.apimusica.model.Musica;
import com.musica.apimusica.repository.AlbumRepository;
import com.musica.apimusica.repository.ArtistaRepository;
import com.musica.apimusica.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepo;

    @Autowired
    private ArtistaRepository artistaRepo;

    @Autowired
    private MusicaRepository musicaRepo;

    public AlbumDTO criar(AlbumDTO dto) {
        Artista artista = artistaRepo.findById(dto.artistaId)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado com ID: " + dto.artistaId));

        Album album = AlbumMapper.toEntity(dto, artista);

        if (dto.musicas != null) {
            for (Long musicaId : dto.musicas) {
                Musica musica = musicaRepo.findById(musicaId)
                        .orElseThrow(() -> new RuntimeException("Música não encontrada com ID: " + musicaId));
                album.adicionarMusica(musica);
            }
        }

        return AlbumMapper.toDTO(albumRepo.save(album));
    }

    public List<AlbumDTO> listarTodos() {
        return albumRepo.findAll().stream().map(AlbumMapper::toDTO).collect(Collectors.toList());
    }

    public AlbumDTO buscarPorId(Long id) {
        return albumRepo.findById(id).map(AlbumMapper::toDTO).orElseThrow();
    }

    public AlbumDTO atualizar(Long id, AlbumDTO dto) {
        Album existente = albumRepo.findById(id).orElseThrow();
        Artista artista = artistaRepo.findById(dto.artistaId).orElseThrow();

        existente.setNome(dto.nome);
        existente.setArtista(artista);



        return AlbumMapper.toDTO(albumRepo.save(existente));
    }

    public void deletar(Long id) {
        albumRepo.deleteById(id);
    }
}
