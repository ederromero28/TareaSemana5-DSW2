package pe.idat.ejercicio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.ejercicio.model.Usuario;
import pe.idat.ejercicio.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.save(usuario);
	}

	@Override
	public void actualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario obtener(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).orElse(null);
	}

}
