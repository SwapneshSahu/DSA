package __CodeHelp.Arrays.BinarySearch.SearchSpace;

public class SquareRoot {

//Lt-69	
	public int mySqrt(int x) {

        if (x ==0 ) return 0;
        if (x < 4) return 1;

        int left =2;
        int right= x;
        int ans =0;
        while(left <right){

            int mid = left  + (right-left)/2;
             // x/mid to avoid integer overflow
            if (mid == x/mid) return mid;

            if (mid < x/mid){
               if (mid > ans) ans=mid; // to track the nearest number in case of not perfect square 
               left=mid+1;
            }
            else{
                right =mid;
            }
        }
        
       return ans;
    }
}
