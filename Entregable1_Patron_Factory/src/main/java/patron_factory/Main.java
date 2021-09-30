package patron_factory;

public class Main {

	public static void main(String[] args) {
		 Figura f1 = Factory.getFigura("Triangulo","verde");
	     Figura f2 = Factory.getFigura("Rectangulo","rosa");
	     Figura f3 = Factory.getFigura("Circulo", "amarillo");
	     Figura f4 = Factory.getFigura("Cuadrado","rojo");
	        
	     System.out.println(f1.dibujarFigura());
	     System.out.println(f2.dibujarFigura());
	     System.out.println(f3.dibujarFigura());
	     System.out.println(f4.dibujarFigura());
	}

}
