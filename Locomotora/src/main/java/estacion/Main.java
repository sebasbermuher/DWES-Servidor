package estacion;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locomotora l1 = new Locomotora("3360",15000,20);
		Maquinista m1 = new Maquinista("Sebas", "Bermudez Herrera", "Tomares");
		MaquinistaDePrimera m2 = new MaquinistaDePrimera("Pepe", "Perez Gutierrez", "Sevilla",5);
		
		
		Tren t1 = new Tren ("AVE", l1, m1);
		
		System.out.println(l1);
		System.out.println(m1);
		System.out.println(m2);
		System.out.println(t1);
	}

}
