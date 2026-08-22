package crmforartist.repository;


import crmforartist.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

    // Método personalizado para buscar salas por ciudad (útil para el frontend)
    List<Sala> findByCiudadIgnoreCase(String ciudad);
}
