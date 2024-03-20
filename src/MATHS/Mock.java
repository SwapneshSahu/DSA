package MATHS;

public class Mock {

	public static void main(String[] args) {
	
		int count =0;
		double amount =3000;
		
		while(count<21) {
			
			amount = amount*1.095;
			amount +=3000;
			count++;
		}
		
		System.out.println(amount);

	}
	
	

}
