package com.gestor.eventos.repository;

import com.gestor.eventos.model.Artista;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    //@Query("SELECT COUNT(e) FROM Evento e WHERE e.artista.codigoArtista = ?1")
	//public Long countEventosByArtista(Long codigoArtista);

	//@Query("SELECT SUM(e.numeroEntradas) FROM Evento e WHERE e.artista.codigoArtista = ?1")
	//public Long countEntradasVendidasByArtista(Long codigoArtista);
}
