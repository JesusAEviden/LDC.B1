package com.gestor.eventos.controller;

import com.gestor.eventos.model.TipoEvento;
import com.gestor.eventos.service.TipoEventoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class TipoEventoController {
		
	@Autowired
    private TipoEventoService tipoEventoService;

    public TipoEvento crearTipoEvento(String descripcion) {
        return tipoEventoService.create(descripcion);
    }

    public TipoEvento buscarPorId(Long id) {
        return tipoEventoService.getTipoEventoById(id);
    }

    public void eliminar(Long id) {
        tipoEventoService.delete(id);
    }

    public void eliminarTodos() {
        tipoEventoService.deleteAll();
    }

    public long contar() {
        return tipoEventoService.count();
    }

    public TipoEvento guardarTipoEvento(TipoEvento tipoEvento) {
        return tipoEventoService.save(tipoEvento);
    }

    public List<TipoEvento> guardarTodos(List<TipoEvento> tipoEventos) {
        return tipoEventoService.saveAll(tipoEventos);
    }
}
