package com.gestor.eventos.service;

import com.gestor.eventos.model.*;
import com.gestor.eventos.repository.EntradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

    @Autowired
    private EntradaRepository entradaRepository;

    public Entrada save(Entrada entrada) {
        return entradaRepository.save(entrada);
    }

    public List<Entrada> saveAll(List<Entrada> entradas) {
        return entradaRepository.saveAll(entradas);
    }

    public void delete(Long codigoEntrada) {
        entradaRepository.deleteById(codigoEntrada);
    }

    public void deleteAll() {
        entradaRepository.deleteAll();
    }

    public long count() {
        return entradaRepository.count();
    }

    public Entrada getEntradaById(Long codigoEntrada) {
        return entradaRepository.findById(codigoEntrada).orElse(null);
    }

    public Entrada create(Evento evento, Float precio, String estado) {
        return save(new Entrada(null, evento, precio, estado));
    }
}
