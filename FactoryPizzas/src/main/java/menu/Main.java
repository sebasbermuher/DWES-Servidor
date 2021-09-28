package menu;

public class Main {

	public static void main(String[] args) {
		Pizza pizza = FactoryPizzas.devuelvePizzas("Tropical");
		System.out.println(pizza.ingredientes());
		
		
	}

}
