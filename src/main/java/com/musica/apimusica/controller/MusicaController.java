package com.musica.apimusica.controller;

import com.musica.apimusica.dto.MusicaDTO;
import com.musica.apimusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @PostMapping
    public MusicaDTO criar(@RequestBody MusicaDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<MusicaDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EntityModel<MusicaDTO> buscar(@PathVariable Long id) {
        MusicaDTO dto = service.buscarPorId(id);
        return EntityModel.of(dto,
                linkTo(methodOn(MusicaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(MusicaController.class).listar()).withRel("musicas"));
    }

    @PutMapping("/{id}")
    public MusicaDTO atualizar(@PathVariable Long id, @RequestBody MusicaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}