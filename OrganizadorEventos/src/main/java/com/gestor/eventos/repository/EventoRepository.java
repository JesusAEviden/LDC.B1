package com.gestor.eventos.repository;

import com.gestor.eventos.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

	//@Query("SELECT e FROM Evento e WHERE e.tipoEvento.codigoTipoEvento = ?1")
	//public List<Evento> findEventosByTipo(Long tipoEventoId);

	//@Query("SELECT SUM(e.precio * e.numeroEntradas) FROM Entrada e WHERE e.evento.codigoEvento = ?1")
	//public Float getDineroRecaudado(Long codigoEvento);
    
    
}
