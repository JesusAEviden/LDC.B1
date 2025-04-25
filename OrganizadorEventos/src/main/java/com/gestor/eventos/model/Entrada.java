package com.gestor.eventos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Entradas")
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoEntrada;

    @ManyToOne
    @JoinColumn(name = "cod_evento", nullable = false)
    private Evento evento;

    @Column(nullable = false)
    private float precio;  

    @Column(nullable = false)
    private String estado; // Usar un Enum para el estado

}
