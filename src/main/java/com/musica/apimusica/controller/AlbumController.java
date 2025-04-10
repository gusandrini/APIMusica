package com.musica.apimusica.controller;

import com.musica.apimusica.dto.AlbumDTO;
import com.musica.apimusica.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @Operation(summary = "Cria um novo álbum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Álbum criado com sucesso",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlbumDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PostMapping
    public AlbumDTO criar(@RequestBody AlbumDTO dto) {
        return service.criar(dto);
    }

    @Operation(summary = "Lista todos os álbuns")
    @GetMapping
    public Iterable<AlbumDTO> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Retorna um álbum por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Álbum encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlbumDTO.class))),
            @ApiResponse(responseCode = "404", description = "Álbum não encontrado", content = @Content(schema = @Schema()))
    })
    @GetMapping("/{id}")
    public EntityModel<AlbumDTO> buscar(@PathVariable Long id) {
        AlbumDTO dto = service.buscarPorId(id);
        return EntityModel.of(dto,
                linkTo(methodOn(AlbumController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(AlbumController.class).listar()).withRel("albums"));
    }

    @Operation(summary = "Atualiza um álbum existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Álbum atualizado com sucesso", content = @Content(mediaType = "application/json", schema = @Schema(implementation = AlbumDTO.class))),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos", content = @Content(schema = @Schema()))
    })
    @PutMapping("/{id}")
    public AlbumDTO atualizar(@PathVariable Long id, @RequestBody AlbumDTO dto) {
        return service.atualizar(id, dto);
    }

    @Operation(summary = "Exclui um álbum")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Álbum excluído com sucesso", content = @Content(schema = @Schema())),
            @ApiResponse(responseCode = "404", description = "Álbum não encontrado", content = @Content(schema = @Schema()))
    })
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
