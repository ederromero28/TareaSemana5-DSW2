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

import pe.idat.ejercicio.model.Usuario;
import pe.idat.ejercicio.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(path = "listar", method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> listar(){
		return new ResponseEntity<List<Usuario>>(usuarioService.listar(), HttpStatus.OK);
	}
	
	@RequestMapping(path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<?> guardar(@RequestBody Usuario usuario){
		
		usuarioService.guardar(usuario);
		return new ResponseEntity<>("¡Usuario registrado!", HttpStatus.OK);

	}
	
	@RequestMapping(path = "/buscarxid/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
		
		Usuario usuario = usuarioService.obtener(id);
		
		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡Usuario no encontrado!", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> editar(@RequestBody Usuario usuario){
		
		Usuario user = usuarioService.obtener(usuario.getId());
		
		if (user != null) {
			usuarioService.actualizar(usuario);
			
			return new ResponseEntity<>("¡Usuario actualizado correctamente!", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡Usuario no actualizado!", HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		
		Usuario usuario = usuarioService.obtener(id);
		
		if (usuario != null) {
			usuarioService.eliminar(id);
			return new ResponseEntity<>("¡Usuario eliminado correctamente!",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("¡Usuario no se pudo encontrar para eliminar!", HttpStatus.NOT_FOUND);
		}
		
		
	}
	

}
