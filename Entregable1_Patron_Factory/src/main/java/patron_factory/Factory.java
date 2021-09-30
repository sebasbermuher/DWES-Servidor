package patron_factory;

public class Factory {
	
	public static Figura  getFigura(String forma, String color) {
        if (forma.equals("Triangulo")) {
            return new Triangulo(color);
        } else if (forma.equals("Rectangulo")) {
            return new Rectangulo(color);
        } else if (forma.equals("Circulo")) {
            return new Circulo(color);
        }else if (forma.equals("Cuadrado")) {
            return new Cuadrado(color);
        } else {
            return null;
        }
    }
}
