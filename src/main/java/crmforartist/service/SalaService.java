package crmforartist.service;

import crmforartist.Error.RecursoNoEncontradoException;
import crmforartist.entity.Sala;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import crmforartist.repository.SalaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaService {

    private final SalaRepository salaRepository;

    public List<Sala> listarTodas(){
     return salaRepository.findAll();
    }

    public Sala crear(Sala sala){
        return salaRepository.save(sala);
    }

    public Sala buscarPorId(Long id){
        return salaRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Sala no encontrada con id " + id));
    }

    public Sala actualizar(Long id, Sala datos){
        Sala existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setCiudad(datos.getCiudad());
        existente.setEmail(datos.getEmail());
        existente.setTelefono(datos.getTelefono());
        existente.setPersonaContacto(datos.getPersonaContacto());
        return salaRepository.save(existente);
    }

    public void eliminar(Long id){
        salaRepository.delete(buscarPorId(id));
    }


}
