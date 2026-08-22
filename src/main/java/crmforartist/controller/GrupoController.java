package crmforartist.controller;


import crmforartist.entity.Grupo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import crmforartist.service.GrupoService;

import java.util.List;

@RestController
@RequestMapping("/api/grupos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class GrupoController {
    private final GrupoService grupoService;

    @GetMapping
    public List<Grupo> listar(){
        return grupoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Grupo buscarPorId(@PathVariable Long id) {
        return grupoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grupo crear(@Validated @RequestBody Grupo grupo) {
        return grupoService.crear(grupo);
    }

    @PutMapping("/{id}")
    public Grupo actualizar(@PathVariable Long id, @Validated @RequestBody Grupo grupo) {
        return grupoService.actualizar(id, grupo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        grupoService.eliminar(id);
    }
}
