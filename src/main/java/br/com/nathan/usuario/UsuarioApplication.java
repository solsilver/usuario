package br.com.nathan.usuario;

import br.com.nathan.usuario.Model.Usuario;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@SpringBootApplication
public class UsuarioApplication {

	public static void main(String[] args) {

		SpringApplication.run(UsuarioApplication.class, args);
		Usuario usuario= new Usuario();



	}

}
