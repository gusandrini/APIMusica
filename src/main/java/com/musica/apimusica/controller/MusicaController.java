package com.musica.apimusica.controller;

import com.musica.apimusica.dto.MusicaDTO;
import com.musica.apimusica.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    private MusicaService service;

    @Operation(summary = "Cria uma nova música")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Música criada com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = MusicaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PostMapping
    public MusicaDTO criar(@RequestBody MusicaDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todas as músicas")
    @GetMapping
    public Iterable<MusicaDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna uma música por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Música encontrada", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MusicaDTO.class))),
            @ApiResponse(responseCode = "404", description = "Música não encontrada", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public MusicaDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @Operation(summary = "Atualiza uma música existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Música atualizada com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = MusicaDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public MusicaDTO atualizar(@PathVariable Long id, @RequestBody MusicaDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Exclui uma música")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Música excluída com sucesso", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Música não encontrada", content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
