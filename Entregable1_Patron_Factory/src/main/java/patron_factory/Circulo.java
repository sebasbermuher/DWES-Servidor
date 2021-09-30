package patron_factory;

public class Circulo extends Figura{

	public Circulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		return "Soy un circulo " + getColor();
		
	}

}
