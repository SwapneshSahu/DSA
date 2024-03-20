package JavaFeatures;

public class AnonymousClass {

	
	public static void main(String[] args) {
		 
	//	A aa = new A();  // cant instatiate because A is a interface 
		                 // to use methods in class A we have to write implementation class
		
		
		// This way we have given implementation of m1 method using anonymous class 
		A aa = new A() {

			@Override
			public void m1(int a, int b) {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}
