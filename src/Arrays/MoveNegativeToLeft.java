package Arrays;

public class MoveNegativeToLeft {
//Move all negative numbers to left w/o disturbing their order
	public static void main(String[] args) {
		
//		Input: -12, 11, -13, -5, 6, -7, 5, -3, -6
//		Output: -12 -13 -5 -7 -3 -6 11 6 5
		       
     //  int [] arr = new int [] {-1, 2, -3, 4, 5, 6, -7, 8, 9};
		int [] arr = new int []	{ 1, 2,  -4, -5, 2, -7, 3,
            2, -6, -8, -9, 3, 2,  1 };
       help(arr);
	}
	
	public static void help(int []arr) {
		
		int pos = arr.length-1;  
		int neg = arr.length-1;
		
		while(neg>=0 && pos>=0) {
			
			if (arr[pos]<0) {
				pos--;
				continue;
			}
			if(arr[neg] > 0) {
				neg--;
				continue;
			}
			if (pos>neg) {
				pos=neg-1;
				continue;
			}
			int tt = pos;
			while(pos<neg) {
				int temp=arr[pos];
				arr[pos] = arr[pos+1];
				arr[pos+1] = temp;
				pos++;
			}
			pos=tt-1;
			neg=neg-1;
		}
		
		for (int i :arr)System.out.print(i + " ");
		
	}

}
