package Binary_Search;

import java.util.ArrayList;
import java.util.List;

public class Book_Allocation {
	
	public static  ArrayList<Integer> getArrayList() {
		//String numbersString = " 9 1 4 8 10 4 8 4 4 10 2 5 2 8 1 1 8 6 3 2 7 2 8 5 10 9 7 6 3 7 6 10 1 1 7 6 4 1 3 6 3 5 6 10 6 1 6 2 7 7 8 10 5 8 3 9 6 8 7 6 6 3 3 1 6 8 9 8 2 7 3 2 3 3 6 5 9 4 8 2 10 4 8 1 8 7 5 4 10 1 3 1 7 7 9 5 9 5 9 7 3 2 2 5 7 6 7 6 6 5 3 5 6 9 3 10 8 2 4 1 2 1 8 2 2 2 4 4 5 5 2 2 8 8 3 10 10 1 10 4 2 5 3 9 10 4 2 3 9 4 9 9 6 1 7 10 7 7 10 2 9 3 3 9 6 8 6 3 7 7 7 1 5 2 5 3 9 8 1 8 2 6 8 7 6 1 1 4 3 8 6 2 1 5 10 8 10 7 2 7 2 9 9 3 10 3 5 7 1 6 9 10 10 9 5 9 3 10 9 6 7 6 4 2 6 2 9 2 8 4 6 10 6 9 3 7 8 3 3 3 7";
	//	String numbersString =   "2 2 3 8 6 10 8 4 1 4 9 6 9 6 1 3 5 7 3 5 9 8 9 3 3 5 8 5 10 8 3 7 9 5 2 8 5 10 10 1 10 1 2 4 7 3 6 10 5 9 8 7 3 8 4 6 9 7 8 4 1 4 6 5 9 6 5 3 7 5 1 10 9 4 9 8 6 4 6 7 3 5 7 2 1 7 8 7 10 10 9 7 3 9 8 9 1 10 2 4 10 8 7 4 5 3 3 5 10 2 4 4 8 9 2 6 10 3 7 10 9 3 5 1 5 10 10 10 10 3 2 8 9 8 10 1 9 9 9 5 7 6 5 2 7 10 10 4 6 6 2 7 9 2 4 2 4 6 10 10 7 4 1 3 3 1 3 3 3 4 3 1 1 4 7 8 7 2 10 4 4 4 4 2 3 8 10 7 7 4 7 7 9 2 1 5 9 9 7 9 10 10 7 1 8 7 3 3 4 2 3 4 7 10 2 7 9 3 3 4 10 5 9 9 2 7 6 8 5 9 6 1 7 1 10 7 2 1 3 7 7 8 2 8 9 7 2 8 1 4 3 9 10 7 6 1 2 3 8 6 6 3 10 2 1 10 10 2 10 3 9 7 3 9 7 10 7 5 1 10 10 2 8 3 9 6 8 1 4 7 1 4 2 3 9 8 10 9 10 4 9 1 4 8 10 4 8 4 4 10 2 5 2 8 1 1 8 6 3 2 7 2 8 5 10 9 7 6 3 7 6 10 1 1 7 6 4 1 3 6 3 5 6 10 6 1 6 2 7 7 8 10 5 8 3 9 6 8 7 6 6 3 3 1 6 8 9 8 2 7 3 2 3 3 6 5 9 4 8 2 10 4 8 1 8 7 5 4 10 1 3 1 7 7 9 5 9 5 9 7 3 2 2 5 7 6 7 6 6 5 3 5 6 9 3 10 8 2 4 1 2 1 8 2 2 2 4 4 5 5 2 2 8 8 3 10 10 1 10 4 2 5 3 9 10 4 2 3 9 4 9 9 6 1 7 10 7 7 10 2 9 3 3 9 6 8 6 3 7 7 7 1 5 2 5 3 9 8 1 8 2 6 8 7 6 1 1 4 3 8 6 2 1 5 10 8 10 7 2 7 2 9 9 3 10 3 5 7 1 6 9 10 10 10 9 5 9 3 10 9 6 7 6 4 2 6 2 9 2 8 4 6 10 6 9 3 7 8 3 3 3 7 \r\n"
          ;
          
          String numbersString =  "25 46 28 49 24";
		
		List<Integer> numberList = new ArrayList<>();

        // Split the string of numbers based on spaces
        String[] numbersArray = numbersString.split("\\s+");

        // Convert each string number to integer and add to the list
        for (String number : numbersArray) {
            int num = Integer.parseInt(number);
            numberList.add(num);
        }

        // Print the list of numbers
        System.out.println("List of numbers: " + numberList.size());
        return (ArrayList<Integer>) numberList;
	}

	public static void main(String[] args) {

		// A book with number of pages is given as a Array we have to distribute books
		// among given student such that
		// no book is left and number of pages between students are almost equal.
		
		int [] arr = new int[] {12,34,67,90};
	
		ArrayList<Integer> A =getArrayList();
//				new ArrayList<>();   = getArrayList();
//		= new ArrayList<>();
//		A.add(8);
//		A.add(15);
//		A.add(3);
////		A.add(49);
////		A.add(24);
		
//		5 4
//		25 46 28 49 24
		System.out.println(findPages(A,A.size(),4));
		
		

	}
	
	public static int findPages(ArrayList<Integer> A, int N, int M) {
		   if (M > N) return -1;

	     List<Integer> copyA = new ArrayList<>();
	    
	     //1 17 14 9 15 9 14
	     
	     for (int i =1 ; i < A.size() ;i++) {
	    	 copyA.add(A.get(i));
	     }
	     copyA.add(A.get(0));
	     for (int i =1 ; i < A.size() ;i++) {
	    	 copyA.add(copyA.get(i-1) + A.get(i));
	     }
	     
	     copyA.add(A.get(A.size()-1));
	     int ii = copyA.size()-1;
	     for (int i =A.size()-2 ; i >=0 ;i--) {
	    	 copyA.add(copyA.get(ii) + A.get(i));
	    	 ii++;
	     }
	     System.out.println(copyA.size());
	     copyA  = copyA.stream().distinct().sorted((a,b) -> a-b).toList();
	     System.out.println(copyA.size());
	    // int ans =Integer.MAX_VALUE;
         for (int target  : copyA) {
        	     int i = 0;
				int j =0;
				int [] arr = new int [M];
				int max =0;
				while ( i < M && j < N){
					while( j < N && arr[i] + A.get(j)<= target ){

						  arr[i] +=A.get(j);	  
						   j++;
					}
	                  max=Math.max(arr[i],max); 
					  i++;
				}
	            // we have one solution
				if (i == M && j == N){
					return max;
				}
				
         }
	     
		// return  binary(A, N, M,1, right);
	     return -1;
	}
	
//	public static int  binary( ArrayList<Integer> A, int N, int M , int left , int right) {
//	      int ans = Integer.MAX_VALUE;
//          if (left <= right) return ans;
//				int target = left + (right - left)/2;
//               //  target =10;
//				int i = 0;
//				int j =0;
//				int [] arr = new int [M];
//				int max =0;
//				while ( i < M && j < N){
//					while( j < N && arr[i] + A.get(j)<= target ){
//
//						  arr[i] +=A.get(j);	  
//						   j++;
//					}
//	                  max=Math.max(arr[i],max); 
//					  i++;
//				}
//	            // we have one solution
//				if (i == M && j == N){
//					ans = Math.min(ans,max);
//				int temp =	Math.min(binary(A, N, M,left, target-1),binary(A, N, M, target+1, right));
//				return Math.min(ans,temp);
//				}
//	            else if (i == M){
//	            	return  Math.min(ans,binary(A, N, M, target+1, right));
//					
//				}
//				
//			return	 Math.min(ans,binary(A, N, M,left, target-1));					
//
//	}

//	public static int books(int[] arr, int stu) {
//		int sum = 0;
//
//		for (int i : arr)
//			sum += i;
//
//		int start = 0;
//		int end = sum;
//		int mid = start + (end - start) / 2;
//		int ans = 0;
//
//		while (start <= end) {
//
//			if (isPossible(arr, stu, mid)){
//				ans = mid;
//				end = mid - 1;
//			} else {
//				start = mid + 1;
//			}
//			mid = start + (end - start) / 2;
//
//		}
//
//		return ans;
//	}
//	
//	public static boolean isPossible(int[] arr,int stu,int mid) {
//		
//		int student = 1;
//		int page= 0;
//		
//		for (int i :arr) {
//			
//			if (page+i <=mid) page +=i;
//			else {
//				student +=1;
//				if (student > stu || i> mid) return false;
//				page=i;
//			}
//			
//		}
//		
//		return true;
//	}
}
