package pe.idat.ejercicio.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import pe.idat.ejercicio.model.Usuario;
import pe.idat.ejercicio.service.UsuarioService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		for (Usuario usuario : usuarioService.listar()) {
			 auth.inMemoryAuthentication()
			.withUser(usuario.getUsername())
			.password(encriptado().encode(usuario.getPassword()))
			.roles(usuario.getRol());
		}
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET).permitAll()
		.antMatchers("/alumnos/*", "/usuarios/*").access("hasRole('ADMIN')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}


	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}

}
