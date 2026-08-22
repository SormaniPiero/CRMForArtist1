package crmforartist.dto;

import crmforartist.enums.EstadoParticipacion;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
@Data
public class ParticipacionEventoUpdateDTO {

    @NotNull
    private EstadoParticipacion estado;

    private String notas;
}
