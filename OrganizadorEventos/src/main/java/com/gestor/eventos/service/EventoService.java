package com.gestor.eventos.service;

import com.gestor.eventos.model.*;
import com.gestor.eventos.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.*;
import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    //public List<Evento> getEventosByTipo(Long tipoEvento) {
    //    return eventoRepository.findEventosByTipo(tipoEvento);
    //}

    //public Float getDineroRecaudado(Long codigoEvento) {
    //    return eventoRepository.getDineroRecaudado(codigoEvento);
    //}

    public Evento save(Evento evento) {
        return eventoRepository.save(evento);
    }

    public List<Evento> saveAll(List<Evento> eventos) {
        return eventoRepository.saveAll(eventos);
    }

    public void delete(Long codigoEvento) {
        eventoRepository.deleteById(codigoEvento);
    }

    public void deleteAll() {
        eventoRepository.deleteAll();
    }

    public long count() {
        return eventoRepository.count();
    }

    public Evento getEventoById(Long codigoEvento) {
        return eventoRepository.findById(codigoEvento).orElse(null);
    }

    public Evento create(String nombreEvento, LocalDate fecha, LocalTime hora, Artista artista, TipoEvento tipoEvento, Integer numeroEntradas) {
        return save(new Evento(null, nombreEvento, fecha, hora, artista, tipoEvento, numeroEntradas));
    }
}
