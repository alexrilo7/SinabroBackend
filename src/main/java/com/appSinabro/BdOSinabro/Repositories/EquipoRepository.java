package com.appSinabro.BdOSinabro.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appSinabro.BdOSinabro.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long>{
	public Equipo findByNombre(String nombre);
}
