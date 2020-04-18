package michael.dev.app.service;

import java.util.List;

import michael.dev.app.model.Pelicula;

public interface IPeliculasService {
	List<Pelicula> buscarTodas();
	Pelicula buscaPorId(int idPelicula);
}
