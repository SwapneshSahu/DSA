package Decorator;

public class VegPizza extends BasePizza {

	
	public VegPizza() {
		super();
		System.out.println("Obj Veg");
		// TODO Auto-generated constructor stub
	}

	@Override
	int costOfPizza() {
		System.out.println("In VegPizza");
		return 100;
	}

}
