package com.musica.apimusica.controller;

import com.musica.apimusica.dto.ArtistaDTO;
import com.musica.apimusica.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @Operation(summary = "Cria um novo artista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Artista criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArtistaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PostMapping
    public ArtistaDTO criar(@RequestBody ArtistaDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os artistas")
    @GetMapping
    public Iterable<ArtistaDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um artista por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArtistaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Artista não encontrado", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public ArtistaDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza um artista existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ArtistaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public ArtistaDTO atualizar(@PathVariable Long id, @RequestBody ArtistaDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Exclui um artista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Artista excluído com sucesso", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Artista não encontrado", content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
