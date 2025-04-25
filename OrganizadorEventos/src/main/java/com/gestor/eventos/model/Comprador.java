package com.gestor.eventos.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Compradores")
public class Comprador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_comprador")  // Especificar el nombre de la columna
    private Long codigoComprador;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true, length = 100) // Añadir longitud para el email
    private String email;

    @ManyToOne
    @JoinColumn(name = "codigo_entrada", nullable = false)
    private Entrada entrada;
}
