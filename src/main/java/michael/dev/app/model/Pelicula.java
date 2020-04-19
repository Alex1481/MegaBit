package michael.dev.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import michael.dev.app.model.Detalle;

@Entity
@Table(name="Peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment MySQL
	private int id;
	private String titulo;
	private String genero;
	private String imagen = "cinema.png"; // imagen por default	
	private Date fechaEstreno;
	
	//Ignorar este atributo durante la persistencia POR LA RELACION QUE EXISTE
	//EXISTE UNA TABLA DETALLE EN PELICULAS POR LA RELACION (PERO EN REALIDAD ES IDDETALLE)
	//TIENE QUE TENER LA ANOTACIÓN ENTITY TAMBIEN EN EL MODEL DE DETALLE
	//@Transient
	
	
	//REALCION 1 A 1 idDetall es la Llave Foranea
	@OneToOne
	@JoinColumn(name = "idDetalle")
	private Detalle detalle;
	
	public Pelicula() {
		//System.out.println("Constructor Pelicula");
	}
	
	public Detalle getDetalle() {
		return detalle;
	}
	
	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Date getFechaEstreno() {
		return fechaEstreno;
	}
	public void setFechaEstreno(Date fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", imagen=" + imagen
				+ ", fechaEstreno=" + fechaEstreno + ", detalle=" + detalle + "]";
	}
	
	
	
	
	
}
