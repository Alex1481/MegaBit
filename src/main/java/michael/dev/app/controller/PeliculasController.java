package michael.dev.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import michael.dev.app.model.Pelicula;
import michael.dev.app.service.IDetallesService;
import michael.dev.app.service.IPeliculasService;
import michael.dev.app.util.Utileria;


@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

		@Autowired
		private IDetallesService serviceDetalles;
		
		@Autowired
		private IPeliculasService servicePeliculas;

		@GetMapping("/index")
		public String mostrarIndex(Model model) {
			List<Pelicula> lista = servicePeliculas.buscarTodas();
			model.addAttribute("peliculas", lista);
			return "peliculas/listPeliculas";
		}
		
		@GetMapping(value = "/indexPaginate")
		public String mostrarIndexPaginado(Model model, Pageable page) {
			Page<Pelicula> lista = servicePeliculas.buscarTodas(page);
			model.addAttribute("peliculas", lista);
			return "peliculas/listPeliculas";
		}
		
		@GetMapping("/create")
		public String crear(@ModelAttribute Pelicula pelicula, Model model) {
		
			return "peliculas/formPelicula";
		}
		
		@PostMapping("/save")
		public String guardar(@ModelAttribute Pelicula pelicula, BindingResult result, RedirectAttributes attributes,
				@RequestParam("archivoImagen") MultipartFile multiPart, HttpServletRequest request
				) {
			
			if (result.hasErrors()) {
				System.out.println("Existieron errores");
				return "peliculas/formPelicula";
			}
			
			if (!multiPart.isEmpty()) {
				String nombreImagen = Utileria.guardarImagen(multiPart,request);
				if (nombreImagen!=null){ // La imagen si se subio				
					pelicula.setImagen(nombreImagen); // Asignamos el nombre de la imagen
				}	
			}
			
			// Primero insertamos el detalle
		    serviceDetalles.insertar(pelicula.getDetalle());
		    
			// Como el Detalle ya tiene id, ya podemos guardar la pelicula
			servicePeliculas.insertar(pelicula);
			attributes.addFlashAttribute("msg", "Los datos de la pelicula fueron guardados!");
				
			//return "redirect:/peliculas/index";
			return "redirect:/peliculas/indexPaginate";	
		}
		
		@GetMapping(value="/edit/{id}")
		public String editar(@PathVariable("id") int idPelicula, Model model) {
			Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
			model.addAttribute("pelicula", pelicula);
			
			return "peliculas/formPelicula";
		}
		
		@GetMapping(value="/delete/{id}")
		public String eliminar(@PathVariable("id") int idPelicula, RedirectAttributes attributes) {
			
			Pelicula pelicula = servicePeliculas.buscarPorId(idPelicula);
			
			// Primero elimina la pelicula
			servicePeliculas.eliminar(idPelicula);
			//Despues elimina los detalles
			serviceDetalles.eliminar(pelicula.getDetalle().getId());
			
			attributes.addFlashAttribute("mensaje", "La Pelicula fue Eliminada");
			return "redirect:/peliculas/index";
		}
		
		@ModelAttribute("generos")
		public List<String> getGeneros(){
			return servicePeliculas.buscarGeneros();
		}
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		}
}
