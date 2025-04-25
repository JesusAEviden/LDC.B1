package com.gestor.eventos.controller;

import com.gestor.eventos.model.Artista;
import com.gestor.eventos.service.ArtistaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ArtistaController { 
	
	@Autowired
    private ArtistaService artistaService;

    
    public Artista crearArtista(String nombre, String email) {
        return artistaService.create(nombre, email);
    }

    public Artista buscarArtistaPorId(Long id) {
        return artistaService.getArtistaById(id);
    }

    public List<Artista> obtenerTodosArtistas() {
        return artistaService.saveAll(artistaService.saveAll(null));  // Este método es un ejemplo. Reemplazar por findAll.
    }

    public void eliminarArtista(Long id) {
        artistaService.delete(id);
    }

    public void eliminarTodosArtistas() {
        artistaService.deleteAll();
    }

    public long contarArtistas() {
        return artistaService.count();
    }

    //public Long obtenerCantidadDeEventos(Long codigoArtista) {
    //    return artistaService.getCantidadDeEventos(codigoArtista);
    //}

    //public Long obtenerEntradasVendidas(Long codigoArtista) {
    //    return artistaService.getEntradasVendidas(codigoArtista);
    //}

    public List<Artista> guardarArtistas(List<Artista> artistas) {
        return artistaService.saveAll(artistas);
    }
}
