package com.musica.apimusica.controller;

import com.musica.apimusica.dto.ArtistaDTO;
import com.musica.apimusica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @PostMapping
    public ArtistaDTO criar(@RequestBody ArtistaDTO dto) {
        return service.criar(dto);
    }

    @GetMapping
    public List<ArtistaDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public EntityModel<ArtistaDTO> buscar(@PathVariable Long id) {
        ArtistaDTO dto = service.buscarPorId(id);
        return EntityModel.of(dto,
                linkTo(methodOn(ArtistaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ArtistaController.class).listar()).withRel("artistas"));
    }

    @PutMapping("/{id}")
    public ArtistaDTO atualizar(@PathVariable Long id, @RequestBody ArtistaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
