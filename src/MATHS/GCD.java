package MATHS;

public class GCD {

	public static void main(String[] args) {
		int a = 36 ; int b = 84;
		while(b!=0){
	          int temp =b;
	          b= a%b;
	          a=temp;

	       }

	       System.out.println(a);
	}
}
