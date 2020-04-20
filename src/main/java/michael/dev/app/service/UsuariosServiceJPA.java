package michael.dev.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import michael.dev.app.model.Usuario;
import michael.dev.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuarioService {

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		usuariosRepo.save(usuario);
		
	}

}
