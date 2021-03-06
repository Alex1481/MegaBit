package michael.dev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import michael.dev.app.model.Pelicula;

@Repository
public interface PeliculasRepository extends JpaRepository<Pelicula, Integer> {
	
	// Listado de peliculas filtradas por estatus
	//	public List<Pelicula> findByEstatus_OrderByTitulo(String estatus);
	
}
