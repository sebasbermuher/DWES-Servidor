package patron_factory;

public class Triangulo extends Figura{

	public Triangulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		return "Soy un triangulo " + getColor();
		
	}

}
