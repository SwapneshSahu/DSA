package Binary_Search;

import java.util.Arrays;

public class SuccessfulPairs {

	public static void main(String[] args) {
		int [] spells = new  int [] {15,39,38,35,33,25,31,12,40,27,29,16,22,24,7,36,29,34,24,9,11,35,21,3,33,10,9,27,35,17,14,3,35,35,39,23,35,14,31,7}; 
		int [] potions = new int [] {25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23};
		
		int [] ans = successfulPairs(spells, potions, 9505642132L);
		
		for (int i :ans)System.out.println(i);

	}
	
	public static int[] successfulPairs(int[] spells, int[] potions, long success) {
        //Sort the potions array so we can use binary search
        Arrays.sort(potions);
       
       // Now we have to create Ans Array
       int [] ans = new int [spells.length];

    //    Now we go for each index of spells to find at which index from where the target succes we will get 
         
         for (int i =0 ; i < spells.length ; i++){
             long target = success/14;
             if( success % 14 !=0 ) target ++;
             
              int index = findIndex(0,potions.length-1,target,potions) ;
         //    System.out.println(i + " " + index);
              if (index >=0 ) ans[i] = potions.length - index ;
              else {
                  ans[i] =0;
              }

         }
      return ans;
    } 



    public static int findIndex (int left  , int right , long target ,int [] potions ){
    	int temp =-1;
        int mid  = left  +  (right -left)/2 ;
         
         while (left  <=right){

             if (potions[mid] >= target ) {
            	 temp = mid;
                 right = mid-1;
             } 
             else{
                 left = mid+1;
             }
             mid  = left  +  (right -left)/2 ;
         }
    
          return temp;
    }

}
