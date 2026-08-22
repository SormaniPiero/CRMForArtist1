package crmforartist.controller;

import crmforartist.entity.Evento;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import crmforartist.service.EventoService;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")

public class EventoController {

    private final EventoService eventoService;

    @GetMapping
    public List<Evento> listar(){
        return eventoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Evento buscarPorId(@PathVariable Long id) {
        return eventoService.buscarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Evento crear(@Validated @RequestBody Evento evento) {
        return eventoService.crear(evento);
    }
}
