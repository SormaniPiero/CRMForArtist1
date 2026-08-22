package crmforartist.dto;

import crmforartist.entity.ParticipacionEvento;
import crmforartist.enums.EstadoParticipacion;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParticipacionEventoResponseDTO {
    private Long id;
    private Long grupoId;
    private String grupoNombre;
    private EstadoParticipacion estado;
    private String notas;

    public static ParticipacionEventoResponseDTO desde(ParticipacionEvento p){
        return ParticipacionEventoResponseDTO.builder()
                .id(p.getId())
                .grupoId(p.getGrupo().getId())
                .grupoNombre(p.getGrupo().getNombre())
                .estado(p.getEstado())
                .notas(p.getNotas())
                .build();
    }


}
