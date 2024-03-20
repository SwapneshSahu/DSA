package __CodeHelp.BitManipulation;

public class ContOFFlipNeeded {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// Function to find number of bits needed to be flipped to convert A to B
    public static int countBitsFlip(int a, int b){
        
       int temp = a^b;
       
       int count=0;
       while(temp !=0){
           
           if((temp&1) == 1){
               count++;
           }
           
           temp = temp >>1;
       }
       return count;
        
    }
}




