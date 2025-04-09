package com.musica.apimusica.service;

import com.musica.apimusica.dto.ArtistaDTO;
import com.musica.apimusica.mapper.ArtistaMapper;
import com.musica.apimusica.model.Artista;
import com.musica.apimusica.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistaService {
    @Autowired
    private ArtistaRepository repo;

    public ArtistaDTO criar(ArtistaDTO dto) {
        Artista artista = ArtistaMapper.toEntity(dto);
        return ArtistaMapper.toDTO(repo.save(artista));
    }

    public List<ArtistaDTO> listarTodos() {
        return repo.findAll().stream().map(ArtistaMapper::toDTO).collect(Collectors.toList());
    }

    public ArtistaDTO buscarPorId(Long id) {
        return repo.findById(id).map(ArtistaMapper::toDTO).orElseThrow();
    }

    public ArtistaDTO atualizar(Long id, ArtistaDTO dto) {
        Artista existente = repo.findById(id).orElseThrow();
        existente.setNome(dto.nome);
        existente.setEstilo(dto.estilo);
        existente.setEmail(dto.email);
        return ArtistaMapper.toDTO(repo.save(existente));
    }

    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
