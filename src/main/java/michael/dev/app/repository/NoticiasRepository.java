package michael.dev.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import michael.dev.app.model.Noticia;

@Repository
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
