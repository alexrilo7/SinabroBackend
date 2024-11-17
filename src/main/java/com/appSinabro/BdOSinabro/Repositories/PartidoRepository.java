package com.appSinabro.BdOSinabro.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.appSinabro.BdOSinabro.model.Partido;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long>{
	 @Query("SELECT p FROM Partido p WHERE p.equipoLocal.id = :equipoId OR p.equipoVisitante.id = :equipoId")
	    List<Partido> findByEquipoId(@Param("equipoId") Long equipoId);
}
