package pe.idat.ejercicio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.idat.ejercicio.model.Alumno;
import pe.idat.ejercicio.service.AlumnoService;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

	@Autowired
	private AlumnoService alumnoService;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ResponseEntity<List<Alumno>> listar() {
		return new ResponseEntity<List<Alumno>>(alumnoService.listar(), HttpStatus.OK);
	}

	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody Alumno alumno) {

		alumnoService.guardar(alumno);
		return new ResponseEntity<>("¡Alumno registrado!", HttpStatus.OK);

	}

	@RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id) {

		Alumno alumno = alumnoService.buscar(id);

		if (alumno != null) {
			return new ResponseEntity<Alumno>(alumno, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡Alumno no encontrado!", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Alumno alumno) {

		Alumno a = alumnoService.buscar(alumno.getIdalumno());

		if (a != null) {
			alumnoService.actualizar(alumno);
			return new ResponseEntity<>("¡ALUMNO ACTUALIZADO CORRECTAMENTE!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡ALUMNO NO ACTUALIZADO!", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {

		Alumno alumno = alumnoService.buscar(id);

		if (alumno != null) {
			alumnoService.eliminar(id);
			return new ResponseEntity<>("Alumno eliminado correctamente", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Alumno no se pudo encontrar para eliminar", HttpStatus.NOT_FOUND);
		}

	}

}
