package patron_factory;

public class Cuadrado extends Figura{

	public Cuadrado(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		return "Soy un cuadrado " + getColor();
		
	}

	
	
	

}
