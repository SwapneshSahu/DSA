package Template;

public abstract class OrderTemplate {
	
	public abstract void confirmOrder();
	public abstract void prepareOrder();
	public abstract void deliverOrder();
	public abstract void paymentOrder();
	

	
	// decleared final so thta no child class can overwrite and change the order of processing
	public final void processOrder() {
		//We define Steps and Create a template to process order
		//Now All child classes has to implement this methods on own but can change the order
		
		//Step1
		confirmOrder();
		
		//Step2
		prepareOrder();
		
		//Step3
		deliverOrder();
		
		//Step4
		paymentOrder();
		
	}
}
