package com.gestor.eventos.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Artistas")
public class Artista {

    @Id
    @Column(name = "cod_artista")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoArtista;

    @Column(nullable = false, length = 20)
    private String nombre;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    public Artista(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }
}
