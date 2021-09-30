package patron_singleton;

public class Main {

	public static void main(String[] args) {
		Presidente_singleton p1 = Presidente_singleton.getPresidente("Paquito","Navarro Compan",2018);
		Presidente_singleton p2 = Presidente_singleton.getPresidente("Juanmi", "Nazario O'rei", 2021);
		System.out.println(p1);
		System.out.println(p2);
		
	}

}
