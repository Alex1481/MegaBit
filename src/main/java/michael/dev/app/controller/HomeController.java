package michael.dev.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import michael.dev.app.model.Pelicula;
import michael.dev.app.service.IPeliculasService;
import michael.dev.app.util.Utileria;

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") String fecha, Model model){
		
		List<String> listaFechas = Utileria.getNextDays(4);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		
		System.out.println("Buscando todas las peliculas que se estrenaron en la fecha: " + fecha);
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String mostrarPrincipal(Model model) {

		List<String> listaFechas = Utileria.getNextDays(4);
		
		List<Pelicula> peliculas = servicePeliculas.buscarTodas();
		model.addAttribute("fechas", listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);

		return "home";
	}
	
	@RequestMapping(value = "/detalle/{id}/{fecha}",method=RequestMethod.GET)		
	public String mostrarDetalle(Model model,@PathVariable("id") int idPelicula, @PathVariable("fecha") String fecha) {
			
		System.out.println("Buscando peliculas estrenadas: " + idPelicula);
		System.out.println("Fecha de Estreno: " + fecha);
		model.addAttribute("pelicula", servicePeliculas.buscaPorId(idPelicula));
		// TODO - Buscar en la base de datos los horarios.		
		
		return "detalle";
	}
	
}
