package crmforartist.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ParticipacionEventoRequestDTO {

    @NotNull
    private Long eventoId;

    @NotNull
    private Long grupoId;
}