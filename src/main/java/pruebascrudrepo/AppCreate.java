package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import michael.dev.app.model.Noticia;
import michael.dev.app.repository.NoticiasRepository;

// Aplicacion para persistir (Crear) en la tabla Noticias un objeto de tipo Noticia
public class AppCreate {

	public static void main(String[] args) {
		
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo Estreno: Epidemia");
		noticia.setDetalle("El mes de septiembre se estrena la nueva entrega de Epidemia Covid 19");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo = context.getBean("noticiasRepository", NoticiasRepository.class);
		// Operacion CRUD - Create [metodo save del repositorio]
		repo.save(noticia);
		
		context.close();

	}

}
