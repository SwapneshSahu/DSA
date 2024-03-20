package JavaFeatures;

public class LambdaWithFunctionInter {

	public static void main(String[] args) {
		 B bb = new B();
		 
		 bb.m1(10, 20);
		 
		 //OR
		 //we can give parent refrence for child
		 A aa = new B();
		 aa.m1(10,29);
		 
		 
		 //Using Lambda function 
		 
		 A lambda = (a,b) -> System.out.println("From Lambda function : " + (a + b));
		 
		 lambda.m1(11, 11);
	}
}
