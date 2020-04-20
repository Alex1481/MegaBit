package michael.dev.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Detalles")
public class Detalle {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String trailer;
	
	public Detalle() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "Detalle [id=" + id + ", trailer=" + trailer + "]";
	}
	
	
}
