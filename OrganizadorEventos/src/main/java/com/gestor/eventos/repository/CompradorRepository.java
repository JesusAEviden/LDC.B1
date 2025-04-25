package com.gestor.eventos.repository;

import com.gestor.eventos.model.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {

	//public Comprador findByEntrada(Long codigoEntrada);
}
