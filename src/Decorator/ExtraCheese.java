package Decorator;

public class ExtraCheese  extends TopingsDecorator{

	//Has A relationship
	BasePizza basePizza;
	
	
	
	public ExtraCheese(BasePizza basePizza) {
		
		super();
		System.out.println("Obj ExtraCheese");
		this.basePizza = basePizza;
	}



	@Override
	int costOfPizza() {
		System.out.println("In ExtraCheese");
		return basePizza.costOfPizza() +99;
	}

}
