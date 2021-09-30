package PatronDI;

public class TejadoTejas extends Tejado {

	@Override
	public void darSoporte() {
		System.out.println("Doy soporte al tejado");
	}

	@Override
	public String toString() {
		return "TejadoTejas [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

	
}
