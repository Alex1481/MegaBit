package michael.dev.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import michael.dev.app.model.Pelicula;
import michael.dev.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService{
	
	@Autowired
	private PeliculasRepository peliculasRepo;

	@Override
	public void insertar(Pelicula pelicula) {
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		// Nota: Esta lista podria ser obtenida de una BD
				List<String> generos = new LinkedList<>();
				generos.add("Accion");
				generos.add("Aventura");
				generos.add("Clasicas");
				generos.add("Comedia Romantica");
				generos.add("Drama");
				generos.add("Terror");
				generos.add("Infantil");
				generos.add("Accion y Aventura");
				generos.add("Romantica");
				generos.add("Ciencia Ficcion");
						
				return generos;
	}
	

}
