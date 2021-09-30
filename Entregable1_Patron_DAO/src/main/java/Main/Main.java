package Main;

import BDSingleton.ClassicModels_DAO;
import BDSingleton.ConexionBD;

public class Main {

	public static void main(String[] args) {
		System.out.println("-----------------------------");
		System.out.println("LISTA DE PAYMENTS");
		System.out.println(ClassicModels_DAO.getPayment());
		System.out.println("-----------------------------");
		
		ConexionBD.close();

	}
}
