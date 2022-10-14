package pe.idat.ejercicio.service;

import java.util.List;

import pe.idat.ejercicio.model.Alumno;

public interface AlumnoService {
	
	void guardar(Alumno alumno);
	void actualizar(Alumno alumno);
	void eliminar(Integer id);
	List<Alumno> listar();
	Alumno buscar(Integer id);

}
