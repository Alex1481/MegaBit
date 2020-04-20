package michael.dev.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import michael.dev.app.model.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

}
