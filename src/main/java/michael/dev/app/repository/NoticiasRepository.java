package michael.dev.app.repository;

import org.springframework.data.repository.CrudRepository;

import michael.dev.app.model.Noticia;

public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {

}
