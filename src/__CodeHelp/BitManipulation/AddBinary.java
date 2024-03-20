package __CodeHelp.BitManipulation;

public class AddBinary {
	
	/** DRY RUN
	 *   1101
	 *   +101
	 * ___________                     Ans Part
	 *      0     1+1 =2             > 2%2 =0  > 2/2 = 1 (carry)
	 *     10     0+0+(1)carry = 1   > 1%2 =1  > 1/2 =0  (carry)
	 *    010     1+1+0(carry) =2    > 2%2 =0  > 2/2 = 1 (carry)
	 *   0010     1+1(carry) =2      > 2%2 =0  > 2/2 = 1 (carry)
	 *  10010     1(carry)=1        > 1%2 =1  > 1/2 =0  (carry)
	 *  
	 *  In case of 1+1+1(carry) =3  > 3%2 =1   > 2/2 =1 (carry)
	 *             
	 * */

	public static void main(String[] args) {
		String a = "101";
		String b = "1101";
		
		//"10010"
		//10110
		int aIndex = a.length()-1;
		int bIndex = b.length()-1;
		int carry=0;
		
		StringBuilder ans = new StringBuilder();
		while (aIndex  >=0 || bIndex >=0 ) {
			
			int temp = carry ;
			
			if (aIndex >=0) {
				char  tt = a.charAt(aIndex);
				temp+= tt -'0';
			} 
			
			if(bIndex >=0) {
				char  tt = b.charAt(bIndex);
				temp+= tt -'0';
			} 
			ans.append(temp%2 );
			
			if(temp >=2) carry =1;
			else {
				carry =0;
			}
			
			aIndex--;
			bIndex--;
					
		}
		
		if (carry >0) {
			ans.append(carry);
		}
		
		System.out.println(ans.reverse());
		
		
	}
}
