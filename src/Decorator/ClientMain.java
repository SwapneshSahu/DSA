package Decorator;

public class ClientMain {

	public static void main(String[] args) {
		BasePizza  bb = new ExtraCheese( new VegPizza());
		
		System.out.println(bb.costOfPizza());
	}
}
