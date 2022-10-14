package pe.idat.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.ejercicio.model.Alumno;
import pe.idat.ejercicio.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	
	@Autowired
	private AlumnoRepository alumnoRepository;

	@Override
	public void guardar(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.save(alumno);
	}

	@Override
	public void actualizar(Alumno alumno) {
		// TODO Auto-generated method stub
		alumnoRepository.saveAndFlush(alumno);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		alumnoRepository.deleteById(id);
	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return alumnoRepository.findAll();
	}

	@Override
	public Alumno buscar(Integer id) {
		// TODO Auto-generated method stub
		return alumnoRepository.findById(id).orElse(null);
	}

}
