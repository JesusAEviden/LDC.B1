package com.gestor.eventos.service;

import com.gestor.eventos.model.TipoEvento;
import com.gestor.eventos.repository.TipoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoEventoService {

    @Autowired
    private TipoEventoRepository tipoEventoRepository;

    public TipoEvento save(TipoEvento tipoEvento) {
        return tipoEventoRepository.save(tipoEvento);
    }

    public List<TipoEvento> saveAll(List<TipoEvento> tipoEventos) {
        return tipoEventoRepository.saveAll(tipoEventos);
    }

    public void delete(Long codigoTipoEvento) {
        tipoEventoRepository.deleteById(codigoTipoEvento);
    }

    public void deleteAll() {
        tipoEventoRepository.deleteAll();
    }

    public long count() {
        return tipoEventoRepository.count();
    }

    public TipoEvento getTipoEventoById(Long codigoTipoEvento) {
        return tipoEventoRepository.findById(codigoTipoEvento).orElse(null);
    }

    public TipoEvento create(String descripcion) {
        return save(new TipoEvento(0L, descripcion)); 
    }
}
