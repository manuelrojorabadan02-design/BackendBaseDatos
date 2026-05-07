package com.example.BackendBaseDatos;

import com.example.BackendBaseDatos.dominio.Pelicula;
import com.example.BackendBaseDatos.repositorio.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class BackendBaseDatosApplicationTests {

	@Autowired
	private PeliculaRepository repository;

	@Test
	void guardarPeliculaTest() {

		// Crear película
		Pelicula peli = new Pelicula(
				null,
				"Interestellar",
				"Ciencia Ficcion",
				2025,
				null
		);

		// Guardar en la base de datos
		Pelicula peliGuardada = repository.save(peli);

		// Verificaciones
		assertNotNull(peliGuardada);
		assertNotNull(peliGuardada.getId());

		assertEquals("Interestellar", peliGuardada.getTitulo());
		assertEquals("Ciencia Ficcion", peliGuardada.getGenero());
		assertEquals(2025, peliGuardada.getAnio());
	}
}