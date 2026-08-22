package crmforartist.controller;

import crmforartist.dto.ParticipacionEventoRequestDTO;
import crmforartist.dto.ParticipacionEventoResponseDTO;
import crmforartist.dto.ParticipacionEventoUpdateDTO;
import crmforartist.service.ParticipacionEventoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ParticipacionEventoController {

    private final ParticipacionEventoService participacionEventoService;

    @GetMapping("/eventos/{eventoId}/tablon")
    public List<ParticipacionEventoResponseDTO> verTablon(@PathVariable Long eventoId) {
        return participacionEventoService.verTablon(eventoId);
    }

    @PostMapping("/participaciones")
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipacionEventoResponseDTO anadirGrupoAEvento(@Valid @RequestBody ParticipacionEventoRequestDTO datos) {
        return participacionEventoService.anadirGrupoAEvento(datos.getEventoId(), datos.getGrupoId());
    }

    @PatchMapping("/participaciones/{id}")
    public ParticipacionEventoResponseDTO actualizarMiParte(
            @PathVariable Long id,
            @Valid @RequestBody ParticipacionEventoUpdateDTO datos) {
        return participacionEventoService.actualizarMiParte(id, datos);
    }

    @DeleteMapping("/participaciones/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void quitarGrupoDeEvento(@PathVariable Long id) {
        participacionEventoService.quitarGrupoDeEvento(id);
    }
}