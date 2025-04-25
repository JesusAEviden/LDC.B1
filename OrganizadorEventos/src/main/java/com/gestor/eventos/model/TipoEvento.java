package com.gestor.eventos.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Tipos")
public class TipoEvento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoTipoEvento;

    @Column(length = 50, nullable = false)
    private String descripcion;
}
