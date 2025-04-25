package com.gestor.eventos.controller;

import com.gestor.eventos.model.*;
import com.gestor.eventos.service.EntradaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EntradaController {

	@Autowired
    private EntradaService entradaService;

    public Entrada crearEntrada(Evento evento2, float precio, String estado) {
        Evento evento = new Evento();  
        evento.setCodigoEvento(evento2.getCodigoEvento());  
        return entradaService.create(evento, precio, estado);
    }

    public Entrada buscarPorId(Long id) {
        return entradaService.getEntradaById(id);
    }

    public List<Entrada> obtenerTodas() {
        return entradaService.saveAll(null);  
    }

    public void eliminar(Long id) {
        entradaService.delete(id);
    }

    public void eliminarTodas() {
        entradaService.deleteAll();
    }

    public long contar() {
        return entradaService.count();
    }

    public List<Entrada> guardarEntradas(List<Entrada> entradas) {
        return entradaService.saveAll(entradas);
    }
}
