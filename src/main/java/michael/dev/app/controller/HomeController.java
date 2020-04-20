package michael.dev.app.controller;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import michael.dev.app.model.Pelicula;
import michael.dev.app.service.IBannersService;
import michael.dev.app.service.IPeliculasService;
import michael.dev.app.util.Utileria;
import michael.dev.app.model.Banner;
import michael.dev.app.model.Noticia;
import michael.dev.app.service.INoticiasService;

@Controller
public class HomeController {

	@Autowired
	private IBannersService serviceBanners; // Ejercicio : Solucion
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext
	@Autowired
	private INoticiasService serviceNoticias;

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model) {
		
	List<String> listaFechas = Utileria.getNextDays(4);
	List<Pelicula> peliculas = servicePeliculas.buscarTodas();
	model.addAttribute("fechas", listaFechas);
	model.addAttribute("fechaBusqueda", fecha);
	model.addAttribute("peliculas", peliculas);
	model.addAttribute("banners", serviceBanners.buscarTodos());
		
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);

		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("banners", serviceBanners.buscarTodos());

		return "home";
	}

	@RequestMapping(value = "/detalle/{id}/{fecha}", method = RequestMethod.GET)
	public String mostrarDetalle(Model model, @PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {

		model.addAttribute("pelicula", servicePeliculas.buscarPorId(idPelicula));
		// TODO - Buscar en la base de datos los horarios.

		return "detalle";
	}
	
	@RequestMapping(value = "/about")
	public String mostrarAcerca() {			
		return "acerca";
	}
	
	@RequestMapping(value="/formLogin", method=RequestMethod.GET)
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
	@ModelAttribute("baners")
	public List<Banner> getBanners(){
		return serviceBanners.buscarActivos();
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {				
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
