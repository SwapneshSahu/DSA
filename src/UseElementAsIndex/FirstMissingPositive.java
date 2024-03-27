package UseElementAsIndex;

public class FirstMissingPositive {
	
	//lt-41
	public static void main(String[] args) {
		
	}
	
	public int firstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean lastIndex = false;
     for (int i = 0 ; i < n ;i++){      
        if (arr[i] <= 0){
             arr[i] = Integer.MAX_VALUE;    
        }
     } 

     for ( int i : arr ){
          int temp  = Math.abs(i) ;

          if (temp == n){
             lastIndex = true; 
          }
          else if (temp <n){
            if (arr[temp] >0) arr[temp] *= -1; 
          }

     } 

    for (int i = 1 ; i < n ;i++){     
          if (arr[i] > 0){
             return i;
          }
    }
   
    return lastIndex ? n+1 : n;

    }

}
