package crmforartist.repository;

import crmforartist.entity.ParticipacionEvento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ParticipacionEventoRepository extends JpaRepository<ParticipacionEvento, Long> {

    List<ParticipacionEvento> findByEventoId(Long eventoId);

    List<ParticipacionEvento> findByGrupoId(Long grupoId);

    Optional<ParticipacionEvento> findByEventoIdAndGrupoId(Long eventoId, Long grupoId);

}
