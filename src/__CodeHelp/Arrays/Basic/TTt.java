package __CodeHelp.Arrays.Basic;

public class TTt {

	public static void main(String[] args) {
		int i = 0 ; 
		int sum =0 ; 
		
		while (i<100) {
			sum = i+sum;
			sum = sum+i;
			i +=1;
		}
    System.out.println(fib(100,2000));
	}
	
	public static int fib(int n) {
		if(n<=1) return n;
		
		return fib(n-1) +fib(n-2);
	}
	
	public static int fib(int A ,int B) {
		if (B == 0) return A; 
		else {
		return fib(B , A%B);
		}
	}
    
    
}
