package com.gestor.eventos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gestor.eventos.model.*;

public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long>{
}
