package PatronDI;

public class Main {
	public static void main(String[] args) {
		Pared pa1 = new Pared(4.5);
		Pared pa2 = new Pared(4.5);
		Pared pa3 = new Pared(4.5);
		Pared pa4 = new Pared(4.5);
		Tejado t1 = new Tejado();
		TejadoTejas t_tejas1 = new TejadoTejas();
		
		Casa c1 = new Casa(600,pa1,pa2,pa3,pa4,t1);
		System.out.println(c1);
		t1.darSoporte();
		t_tejas1.darSoporte();
		
		Tejado t2 = new Tejado();
		TejadoTejas t_tejas2 = new TejadoTejas();
		
		Casa c2 = new Casa(400,pa1,pa2,pa3,pa4,t2);
		System.out.println(c2);
		t2.darSoporte();
		t_tejas2.darSoporte();
		
		
		
	}

}
