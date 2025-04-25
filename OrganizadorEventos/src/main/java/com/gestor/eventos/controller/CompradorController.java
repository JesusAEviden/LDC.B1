package com.gestor.eventos.controller;

import com.gestor.eventos.model.*;
import com.gestor.eventos.service.CompradorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CompradorController {

	@Autowired
    private CompradorService compradorService;

    public Comprador crearComprador(String nombre, String email, Entrada codigoEntrada) {
        Comprador comprador = new Comprador();
        comprador.setNombre(nombre);
        comprador.setEmail(email);
        comprador.setEntrada(codigoEntrada);  
        return compradorService.create(comprador);
    }

    public Comprador buscarPorId(Long id) {
        return compradorService.getCompradorById(id);
    }

    public List<Comprador> obtenerTodos() {
        return compradorService.saveAll(null);  
    }

    public void eliminar(Long id) {
        compradorService.delete(id);
    }

    public void eliminarTodos() {
        compradorService.deleteAll();
    }

    public long contar() {
        return compradorService.count();
    }

    //public Comprador buscarPorEntrada(Long codigoEntrada) {
    //    return compradorService.getCompradorByEntrada(codigoEntrada);
    //}

    public List<Comprador> guardarCompradores(List<Comprador> compradores) {
        return compradorService.saveAll(compradores);
    }
}
