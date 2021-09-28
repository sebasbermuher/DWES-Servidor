package menu;

public class FactoryPizzas {
	
	public static Pizza devuelvePizzas(String tipo) {
		if (tipo.equals("Tropical")) {
			return new PizzaTropical("Tropical");
			
		}else {
			return new PizzaCarbonara("Carbonara");
		}
		
	}

}
