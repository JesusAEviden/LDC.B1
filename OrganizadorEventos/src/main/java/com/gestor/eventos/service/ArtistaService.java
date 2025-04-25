package com.gestor.eventos.service;

import com.gestor.eventos.model.Artista;
import com.gestor.eventos.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    //public Long getCantidadDeEventos(Long codigoArtista) {
    //    return artistaRepository.countEventosByArtista(codigoArtista);
    //}

    //public Long getEntradasVendidas(Long codigoArtista) {
    //    return artistaRepository.countEntradasVendidasByArtista(codigoArtista);
    //}

    public Artista save(Artista artista) {
        return artistaRepository.save(artista);
    }

    public List<Artista> saveAll(List<Artista> artistas) {
        return artistaRepository.saveAll(artistas);
    }

    public void delete(Long codigoArtista) {
        artistaRepository.deleteById(codigoArtista);
    }

    public void deleteAll() {
        artistaRepository.deleteAll();
    }

    public long count() {
        return artistaRepository.count();
    }

    public Artista getArtistaById(Long codigoArtista) {
        return artistaRepository.findById(codigoArtista).orElse(null);
    }

    public Artista create(String nombre, String email) {
        return save(new Artista(nombre, email));
    }
}
