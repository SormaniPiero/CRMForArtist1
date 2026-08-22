package crmforartist.service;

import crmforartist.Error.RecursoNoEncontradoException;
import crmforartist.entity.Evento;
import crmforartist.entity.Grupo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import crmforartist.repository.EventoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoService {

    private final EventoRepository eventoRepository;

    public List<Evento> listarTodos(){
        return eventoRepository.findAll();
    }

    public Evento buscarPorId(Long id){
        return eventoRepository.findById(id)
                .orElseThrow(()-> new RecursoNoEncontradoException("Evento no encontrado"));
    }




    public Evento actualizar(Long id, Evento datos) {
        Evento existente = buscarPorId(id);
        existente.setNombre(datos.getNombre());
        existente.setFecha(datos.getFecha());
        existente.setSala(datos.getSala());
        existente.setDescripcion(datos.getDescripcion());
        return eventoRepository.save(existente);
    }

    public void eliminar(Long id){
        eventoRepository.delete(buscarPorId(id));
    }

    public Evento crear(Evento grupo){
        return eventoRepository.save(grupo);
    }

}
