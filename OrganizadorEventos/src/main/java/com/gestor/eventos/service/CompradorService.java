package com.gestor.eventos.service;

import com.gestor.eventos.model.Comprador;
import com.gestor.eventos.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    //public Comprador getCompradorByEntrada(Long codigoEntrada) {
    //    return compradorRepository.findByEntrada(codigoEntrada);
    //}

    public Comprador save(Comprador comprador) {
        return compradorRepository.save(comprador);
    }

    public List<Comprador> saveAll(List<Comprador> compradores) {
        return compradorRepository.saveAll(compradores);
    }

    public void delete(Long codigoComprador) {
        compradorRepository.deleteById(codigoComprador);
    }

    public void deleteAll() {
        compradorRepository.deleteAll();
    }

    public long count() {
        return compradorRepository.count();
    }

    public Comprador getCompradorById(Long codigoComprador) {
        return compradorRepository.findById(codigoComprador).orElse(null);
    }

    public Comprador create(Comprador comprador) {
        return save(comprador);
    }
}
