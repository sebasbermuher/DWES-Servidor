package patron_factory;

public class Rectangulo extends Figura{

	public Rectangulo(String color) {
		super(color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String dibujarFigura() {
		return "Soy un rectangulo " + getColor();
		
	}

}
