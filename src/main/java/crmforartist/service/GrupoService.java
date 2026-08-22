package crmforartist.service;

import crmforartist.Error.RecursoNoEncontradoException;
import crmforartist.entity.Grupo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import crmforartist.repository.GrupoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GrupoService {

    private final GrupoRepository grupoRepository;

    public List<Grupo> listarTodos(){
        return grupoRepository.findAll();
    }

    public Grupo buscarPorId(Long id){
        return grupoRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("Grupo no encontrado"));
    }

    public Grupo crear(Grupo grupo){
        return grupoRepository.save(grupo);
    }

    public Grupo actualizar(Long id, Grupo datos) {
        Grupo existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setEmail(datos.getEmail());
        existente.setTelefono(datos.getTelefono());
        existente.setPersonaContacto(datos.getPersonaContacto());
        return grupoRepository.save(existente);
    }

    public void eliminar(Long id){
        grupoRepository.delete(buscarPorId(id));
    }

}
