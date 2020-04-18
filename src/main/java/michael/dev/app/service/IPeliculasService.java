package michael.dev.app.service;

import java.util.List;

import michael.dev.app.model.Pelicula;

public interface IPeliculasService {
	void insertar(Pelicula pelicula); 
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
}
