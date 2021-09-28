package estacion;

public class MaquinistaDePrimera extends Maquinista{
	private int antigüedad;

	
	public MaquinistaDePrimera(String nombre, String apellidos, String direccion, int antigüedad) {
		super(nombre, apellidos, direccion);
		this.antigüedad = antigüedad;
	}


	@Override
	public String toString() {
		return "MaquinistaDePrimera [antigüedad=" + antigüedad + "]";
	}


	
}
