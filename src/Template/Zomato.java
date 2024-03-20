package Template;

public class Zomato  extends OrderTemplate{

	@Override
	public void confirmOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Confrim by Zomato");
	}

	@Override
	public void prepareOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Prepared by Zomato");
	}

	@Override
	public void deliverOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Delivered by Zomato");
	}

	@Override
	public void paymentOrder() {
		// TODO Auto-generated method stub
		System.out.println("Order Payment Recieved by Zomato");
	}

}
