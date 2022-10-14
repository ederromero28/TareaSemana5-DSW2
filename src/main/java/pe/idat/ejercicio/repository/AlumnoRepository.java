package pe.idat.ejercicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.idat.ejercicio.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
