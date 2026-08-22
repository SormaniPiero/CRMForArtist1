package crmforartist.controller;

import crmforartist.entity.Sala;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import crmforartist.service.SalaService;

import java.util.List;

@RestController
@RequestMapping("/api/salas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class SalaController {
    private final SalaService salaService;

    @GetMapping
    public List<Sala> listar(){
        return salaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Sala buscarPorId(@PathVariable Long id){
        return salaService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sala crear(@Validated @RequestBody Sala sala)
    {
        return salaService.crear(sala);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id)
    {
        salaService.eliminar(id);
    }
}
