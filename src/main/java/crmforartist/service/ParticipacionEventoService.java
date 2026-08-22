package crmforartist.service;

import crmforartist.Error.RecursoNoEncontradoException;
import crmforartist.dto.ParticipacionEventoResponseDTO;
import crmforartist.dto.ParticipacionEventoUpdateDTO;
import crmforartist.entity.Evento;
import crmforartist.enums.EstadoParticipacion;
import crmforartist.entity.Grupo;
import crmforartist.entity.ParticipacionEvento;
import crmforartist.repository.EventoRepository;
import crmforartist.repository.GrupoRepository;
import crmforartist.repository.ParticipacionEventoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipacionEventoService {

    private final ParticipacionEventoRepository participacionRepository;
    private final EventoRepository eventoRepository;
    private final GrupoRepository grupoRepository;

    public List<ParticipacionEventoResponseDTO> verTablon(Long eventoId) {
        return participacionRepository.findByEventoId(eventoId).stream()
                .map(ParticipacionEventoResponseDTO::desde)
                .toList();
    }

    public ParticipacionEventoResponseDTO anadirGrupoAEvento(Long eventoId, Long grupoId) {
        if (participacionRepository.findByEventoIdAndGrupoId(eventoId, grupoId).isPresent()) {
            throw new IllegalStateException("Este grupo ya esta apuntado a este evento");
        }

        Evento evento = eventoRepository.findById(eventoId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Evento no encontrado con id " + eventoId));
        Grupo grupo = grupoRepository.findById(grupoId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Grupo no encontrado con id " + grupoId));

        ParticipacionEvento nueva = ParticipacionEvento.builder()
                .evento(evento)
                .grupo(grupo)
                .estado(EstadoParticipacion.PENDIENTE)
                .build();

        return ParticipacionEventoResponseDTO.desde(participacionRepository.save(nueva));
    }

    public ParticipacionEventoResponseDTO actualizarMiParte(Long participacionId, ParticipacionEventoUpdateDTO datos) {
        ParticipacionEvento existente = participacionRepository.findById(participacionId)
                .orElseThrow(() -> new RecursoNoEncontradoException("Participacion no encontrada con id " + participacionId));

        existente.setEstado(datos.getEstado());
        existente.setNotas(datos.getNotas());

        return ParticipacionEventoResponseDTO.desde(participacionRepository.save(existente));
    }

    public void quitarGrupoDeEvento(Long participacionId) {
        if (!participacionRepository.existsById(participacionId)) {
            throw new RecursoNoEncontradoException("Participacion no encontrada con id " + participacionId);
        }
        participacionRepository.deleteById(participacionId);
    }
}