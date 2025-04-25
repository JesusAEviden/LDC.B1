package com.gestor.eventos.controller;

import com.gestor.eventos.model.Evento;
import com.gestor.eventos.model.Artista;
import com.gestor.eventos.model.TipoEvento;
import com.gestor.eventos.service.EventoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EventoController {

	@Autowired
    private EventoService eventoService;

    public Evento crearEvento(String nombreEvento, LocalDate fecha, LocalTime hora, Artista artista, TipoEvento tipoEvento, Integer numeroEntradas) {
        return eventoService.create(nombreEvento, fecha, hora, artista, tipoEvento, numeroEntradas);
    }

    public Evento buscarPorId(Long id) {
        return eventoService.getEventoById(id);
    }

    //public List<Evento> obtenerEventosPorTipo(Long tipoEvento) {
    //    return eventoService.getEventosByTipo(tipoEvento);
    //}

    //public Float obtenerDineroRecaudado(Long codigoEvento) {
    //    return eventoService.getDineroRecaudado(codigoEvento);
    //}

    public void eliminar(Long id) {
        eventoService.delete(id);
    }

    public void eliminarTodos() {
        eventoService.deleteAll();
    }

    public long contar() {
        return eventoService.count();
    }

    public List<Evento> guardarEventos(List<Evento> eventos) {
        return eventoService.saveAll(eventos);
    }
}
