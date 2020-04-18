package michael.dev.app.model;

public class Detalle {

	private int id;
	private String trailer;
	
	public Detalle() {
		//System.out.println("Constructor Detalle");
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
