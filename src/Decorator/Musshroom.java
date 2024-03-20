package Decorator;

public class Musshroom extends TopingsDecorator {

	// Has A relationship
	BasePizza basePizza;

	public Musshroom(BasePizza basePizza) {
		super();
		this.basePizza = basePizza;
	}

	@Override
	int costOfPizza() {
		System.out.println("In Musshroom");
		return basePizza.costOfPizza() + 101;
	}

}
