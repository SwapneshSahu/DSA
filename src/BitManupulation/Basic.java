package BitManupulation;

public class Basic {

	public static void main(String[] args) {
/**		// AND Operator
		
		System.out.println(3 & 2); //Output 2
		
//		3 (decimal) = 0011 (binary)
//		2 (decimal) = 0010 (binary)
//		    _________________
//		    Result =  0010   	2 (decimal)
//	
		System.out.println(5 & 10); //Output 0
		
//		5 (decimal) =  0101 (binary)
//	    10 (decimal) = 1010 (binary)
//	    ____________________________
//	         Result =  0000   	0(decimal)
		
		System.out.println(7 & 11); //Output 0
		
//		7 (decimal) =  0111 (binary)
//		10 (decimal) = 1010 (binary)
//		______________________
//			    Result =0010   	2 (decimal)
		
		//Similarly for Or
		
		System.out.println(7 | 11); //Output 15
		
		
//	Left Shift  Multiply by 2
		
		int number = 5; // Binary: 0000 0101
		int shiftedLeft = number << 2; // Shifting 2 positions to the left

		// Result of the left shift: Binary: 0001 0100 (Decimal: 20)
		System.out.println(shiftedLeft); // Output: 20
		
		shiftedLeft = number << 1; 
		
		System.out.println(shiftedLeft);  // Output: 10
		
		
		int number2 = -5; // Binary: 0000 0101
		int shiftedLeft2 = number2 << 2; // Shifting 2 positions to the left

		// Result of the left shift: Binary: 0001 0100 (Decimal: 20)
		System.out.println(shiftedLeft2); // Output: 20
		
		shiftedLeft2 = number2 << 1; 
		
		System.out.println(shiftedLeft2);  // Output: 10   **/
		
		
		//Right Shift   divide by 2
		
		int number3 = 20; // Binary: 0001 0100
		int shiftedRight = number3 >> 2; // Shifting 2 positions to the right

		// Result of the right shift: Binary: 0000 0101 (Decimal: 5)
		System.out.println(shiftedRight); // Output: 5
	    
		
		int number = -20; // Binary: 1111 1111 1111 1111 1111 1111 1111 1011 (32-bit signed representation of -20)
		int shiftedRight1 = number >> 1; // Right shift by 2 positions

		// Result of the right shift: Binary: 1111 1111 1111 1111 1111 1111 1111 1110 (32-bit signed representation, Decimal: -5)
		System.out.println(shiftedRight1); // Output: -5
//		The right shift operation fills the leftmost bits with the sign bit (1 in this case), 
//		and the resulting binary is 1111 1111 1111 1111 1111 1111 1111 1110. When we convert
//		this binary back to decimal, we get -5.
//      So, the output of number >> 2 for number = -20 is -5.
	    
		
		
//		Unsigned Right Shift (>>>):
//			The unsigned right shift operator (>>>) works similarly to the right shift (>>) 
//		but always fills the leftmost bits with zeroes, irrespective of the sign bit. 
//		It is used when you want to treat the number as an unsigned integer. The syntax is as follows:

			int number5 = -20; // Binary: 1111 1011
			int unsignedShiftedRight = number5 >>> 2; // Unsigned right shift by 2 positions

			// Result of the unsigned right shift: Binary: 0011 1110 (Decimal: 62)
			System.out.println(unsignedShiftedRight); // Output: 
			
			
			//Pre -post increment Decrement 
			
			int a=10;         
			System.out.println(a++  *  a++ * ++a);
			
			int b =5;
			System.out.println(++b * ++b);
			
			int num =111;
			passByValue(num);
			System.out.println(num);
			
			int aa = 2;
			double bb = 2.3;
			System.out.println(aa>bb);
			
	}
	
	public static void passByValue(int num ) {
		num=10;
		
	}

}
