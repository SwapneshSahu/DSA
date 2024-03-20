package Template;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(Math.pow(100, 10) / Math.pow(10, 20));
      
		OrderTemplate ord = new Zomato() ;
		
		ord.processOrder();
		ord.confirmOrder();
		
	}

}
