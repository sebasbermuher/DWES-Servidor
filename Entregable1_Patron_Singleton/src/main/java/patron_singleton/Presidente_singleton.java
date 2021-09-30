package patron_singleton;

public class Presidente_singleton {
	private String nombre;
	private String apellidos;
	private int year_eleccion;
	
	private Presidente_singleton(String nombre, String apellidos, int year_eleccion) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.year_eleccion = year_eleccion;
	}
	
	private static Presidente_singleton presidente;
	public static Presidente_singleton getPresidente(String nombre, String apellidos, int year_eleccion) {
		if (presidente == null) {
	            presidente = new Presidente_singleton(nombre, apellidos, year_eleccion);
	        }
	        return presidente;
	    }
	
	
	@Override
	public String toString() {
		return "Presidente_singleton [nombre=" + nombre + ", apellidos=" + apellidos + ", year_eleccion="
				+ year_eleccion + "]";
	}
}


