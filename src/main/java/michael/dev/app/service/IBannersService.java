package michael.dev.app.service;

import java.util.List;

import michael.dev.app.model.Banner;

public interface IBannersService {
	void insertar(Banner banner); 
	List<Banner> buscarTodos();
}
