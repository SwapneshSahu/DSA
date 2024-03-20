package JavaFeatures.MultiThreading;

public class Main {

	public static void main(String[] args) {
		MyRunnable rr = new MyRunnable();
		
		Thread tt = new Thread(rr);
		
		tt.start();
		
		for (int i =0 ; i<100; i++) {
			System.out.println("Main Class");
		}
		
		

	}

}
