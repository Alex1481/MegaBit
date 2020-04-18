package michael.dev.app.model;

import java.util.Date;

import michael.dev.app.model.Detalle;

public class Pelicula {

	private int id;
	private String titulo;
	private String genero;
	private String imagen = "cinema.png"; // imagen por default	
	private Date fechaEstreno;
	
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
