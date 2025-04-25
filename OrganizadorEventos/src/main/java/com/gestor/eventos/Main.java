package com.gestor.eventos;

import com.gestor.eventos.config.AppConfig;
import com.gestor.eventos.controller.*;
import com.gestor.eventos.model.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
//import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Iniciar el contexto de Spring
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Obtener los controladores desde el contexto
        ArtistaController artistaController = context.getBean(ArtistaController.class);
        CompradorController compradorController = context.getBean(CompradorController.class);
        EntradaController entradaController = context.getBean(EntradaController.class);
        EventoController eventoController = context.getBean(EventoController.class);
        TipoEventoController tipoEventoController = context.getBean(TipoEventoController.class);

        // Crear un Artista
        Artista artista = artistaController.crearArtista("Carlos Vives", "carlos@email.com");
        System.out.println("Artista creado: " + artista.getNombre());

        // Crear un Tipo de Evento
        TipoEvento tipoEvento = tipoEventoController.crearTipoEvento("Concierto");
        System.out.println("Tipo de evento creado: " + tipoEvento.getDescripcion());

        // Crear un Evento
        Evento evento = eventoController.crearEvento("Concierto en el Estadio", LocalDate.of(2025, 5, 10),
                LocalTime.of(20, 30), artista, tipoEvento, 5000);
        System.out.println("Evento creado: " + evento.getNombreEvento());

        // Crear Entradas para el evento
        Entrada entrada = entradaController.crearEntrada(evento, 100.0f, "disponible");
        System.out.println("Entrada creada: " + entrada.getCodigoEntrada());

        // Crear un Comprador
        Comprador comprador = compradorController.crearComprador("Juan Pérez", "juanperez@email.com", entrada);
        System.out.println("Comprador creado: " + comprador.getNombre());

        // Consultar la cantidad de eventos de un Artista
        //Long cantidadEventos = artistaController.obtenerCantidadDeEventos(artista.getCodigoArtista());
        //System.out.println("Cantidad de eventos del artista " + artista.getNombre() + ": " + cantidadEventos);

        // Consultar las entradas vendidas de un Artista
        //Long entradasVendidas = artistaController.obtenerCantidadDeEventos(artista.getCodigoArtista()); // ¿Debe ser otro método?
        //System.out.println("Entradas vendidas por el artista " + artista.getNombre() + ": " + entradasVendidas);

        // Consultar el dinero recaudado de un evento
        //Float dineroRecaudado = eventoController.obtenerDineroRecaudado(evento.getCodigoEvento());
        //System.out.println("Dinero recaudado del evento " + evento.getNombreEvento() + ": " + dineroRecaudado);

        // Obtener todos los eventos de un tipo
        //List<Evento> eventosPorTipo = eventoController.obtenerEventosPorTipo(tipoEvento.getCodigoTipoEvento());
        //System.out.println("Eventos del tipo '" + tipoEvento.getDescripcion() + "':");
        //for (Evento e : eventosPorTipo) {
        //    System.out.println("- " + e.getNombreEvento());
        //}

        // Contar la cantidad de compradores
        long cantidadCompradores = compradorController.contar();
        System.out.println("Cantidad total de compradores: " + cantidadCompradores);

        // Eliminar un evento
        eventoController.eliminar(evento.getCodigoEvento());
        System.out.println("Evento eliminado.");

        // Eliminar un comprador
        compradorController.eliminar(comprador.getCodigoComprador());
        System.out.println("Comprador eliminado.");

        // Contar la cantidad total de eventos
        long cantidadEventosTotales = eventoController.contar();
        System.out.println("Cantidad total de eventos: " + cantidadEventosTotales);

        // Cerrar el contexto
        context.close();
    }
}
