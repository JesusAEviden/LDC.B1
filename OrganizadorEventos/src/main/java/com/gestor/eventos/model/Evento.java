package com.gestor.eventos.model;

import java.time.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Eventos")
public class Evento {

    @Id
    @Column(name = "cod_evento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEvento;
    
    @Column(name = "nombre", nullable = false)
    private String nombreEvento;

    @Column(nullable = false)
    private LocalDate fecha;  

    @Column(nullable = false)
    private LocalTime hora;  
    @ManyToOne
    @JoinColumn(name = "artista", nullable = false)
    private Artista artista;  

    @ManyToOne
    @JoinColumn(name = "tipo", nullable = false)
    private TipoEvento tipoEvento;

    @Column(nullable = false)
    private Integer numeroEntradas;  
}
