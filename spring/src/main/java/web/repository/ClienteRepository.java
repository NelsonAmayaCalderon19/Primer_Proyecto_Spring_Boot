package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import web.entities.Empleado;

public interface ClienteRepository extends JpaRepository<Empleado, String> {
	

}
