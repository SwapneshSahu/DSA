package Decorator;

public class MargeritaPizza extends BasePizza {

	@Override
	int costOfPizza() {
		System.out.println("In MargeritaPizza");
		return 100;
	}

}
