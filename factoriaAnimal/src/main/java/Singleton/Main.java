package Singleton;

public class Main {

    public static void main(String[] args) {
        Animal a = Factoria.getAnimal("perro", "Hillary");

        System.out.println(a.saludar());
    }

}
