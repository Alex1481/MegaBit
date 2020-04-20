package michael.dev.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

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
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> optional = peliculasRepo.findById(idPelicula);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		
		return null;
	}

	@Override
	public List<Pelicula> buscarTodas() {
		return peliculasRepo.findAll();		
	}
	
	
	

	@Override
	public List<String> buscarGeneros() {
		// Nota: Esta lista podria ser obtenida de una BD
				List<String> generos = new LinkedList<>();
				generos.add("Accion y Aventura");
				generos.add("Clasicas");
				generos.add("Cristianas");
				generos.add("Drama");
				generos.add("Terror");
				generos.add("Infantil");
				generos.add("Romantica");
				generos.add("Ciencia Ficcion");
						
				return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		peliculasRepo.deleteById(idPelicula);
		
	}



}
