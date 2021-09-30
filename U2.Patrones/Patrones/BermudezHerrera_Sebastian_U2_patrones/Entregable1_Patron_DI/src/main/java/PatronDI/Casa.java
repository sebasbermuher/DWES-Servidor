package PatronDI;

public class Casa {
	private int area;
	private Pared p1, p2, p3, p4;
	private Tejado tejado;
	
	
	public Casa(int area, Pared p1, Pared p2, Pared p3, Pared p4, Tejado tejado) {
		super();
		this.area = area;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.tejado = tejado;
	}


	@Override
	public String toString() {
		return "Casa [area=" + area + ", p1=" + p1.toString() + ", p2=" + p2.toString() + ", p3=" + p3.toString() + ", p4=" + p4.toString() + ", tejado=" + tejado
				+ "]";
	}


	
	
	
	
	

}
