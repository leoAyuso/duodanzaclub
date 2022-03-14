package com.mindhub.duodanzaclub;

import com.mindhub.duodanzaclub.models.*;
import com.mindhub.duodanzaclub.repositories.AcademiaRepository;
import com.mindhub.duodanzaclub.repositories.ClaseRepository;
import com.mindhub.duodanzaclub.repositories.ProductoRepository;
import com.mindhub.duodanzaclub.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@SpringBootApplication
public class DuodanzaclubApplication {

	@Autowired
	private PasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(DuodanzaclubApplication.class, args);
	}

	@Bean
	public CommandLineRunner initData(UsuarioRepository usuarioRepository, AcademiaRepository academiaRepository,
									  ProductoRepository productoRepository, ClaseRepository claseRepository){

		return (args) -> {
			Usuario nacho = usuarioRepository.save(new Usuario("Nacho", "Molina", "1144332211", "nacho@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario mati = usuarioRepository.save(new Usuario("Mati", "Voro", "1122993493", "mati@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario tomi = usuarioRepository.save(new Usuario("Tomi", "Voro", "11442910249", "tomi@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Usuario lauti = usuarioRepository.save(new Usuario("Lauti", "Molina", "1157284919", "lauti@gmail.com", passwordEncoder.encode("123456"), LocalDate.now()));
			Academia academia1 = academiaRepository.save(new Academia("La academia del chona", "Buenos cyphers"));
			Academia academia2 = academiaRepository.save(new Academia("Racing club", "Mar del plata"));
			Usuario admin = usuarioRepository.save(new Usuario("admin@admin.com", passwordEncoder.encode("123456")));
			Productos producto1 = productoRepository.save(new Productos("Zapatos de Salsa", "Zapatos de cuero", 12000.0, "Insert path", Estilos.BACHATA, TipoProducto.CALZADOS));
			Clase clase = claseRepository.save(new Clase("Clase de ballet", new ArrayList<Double>(), academia1));
			Clase clase2 = claseRepository.save(new Clase("Clase de tango", new ArrayList<Double>(), academia1));
		};
	}
}
