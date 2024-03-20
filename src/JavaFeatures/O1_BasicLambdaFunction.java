package JavaFeatures;

import java.util.function.*;

public class O1_BasicLambdaFunction {

	public static void main(String[] args) {
	   
		//Without Lambda
        System.out.println("4 square is " + power(4));
        
        
        //With Lambda
               //Argument , Return Type
        Function<Integer,Integer> fun = i ->i*i;       
        System.out.println("4 square is " + fun.apply(4));
        
        Function<String,Integer> funString = i ->10;
        
        System.out.println("funString " + funString.apply("Swap"));
        
        Predicate<Integer> evenCheck = i ->i%2==0;
        
        System.out.println("evenCheck " + evenCheck.test(6));
        
    
        
	}
	

	public static int power(int i) {
		
		return i*i;
	}

}
