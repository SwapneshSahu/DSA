package Template;

public class Swiggy extends OrderTemplate{

	@Override
	public void confirmOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Confrim by Swiggy");
	}

	@Override
	public void prepareOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Prepared  by Swiggy");
	}

	@Override
	public void deliverOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order deliver by Swiggy");
	}

	@Override
	public void paymentOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Payment recived by Swiggy");
	}

}
