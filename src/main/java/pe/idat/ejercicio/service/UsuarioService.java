package pe.idat.ejercicio.service;

import java.util.List;

import pe.idat.ejercicio.model.Usuario;


public interface UsuarioService {
	
	void guardar(Usuario usuario);
	void actualizar(Usuario usuario);
	void eliminar(Integer id);
	List<Usuario> listar();
	Usuario obtener(Integer id);

}
