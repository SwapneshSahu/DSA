package MATHS;

public class FastPower {

	public static void main(String[] args) {
		
		 System.out.println(powerRecursive(2,5));
		int n=10000000;int x=2;double res=1;
		
		
		double m = Math.pow(10, 7);
		while(n!=0) {
			
			if (n%2==1) {
				res = res%m * x%m;
			}
			x *= x%m;
			n= n>>1;
		}
      System.out.println(res);
	}
	
	public static int powerRecursive(int a , int b) {
		if (b==0) return 1;
		
		if (b==1) return a;
		
		int ans  = powerRecursive(a, b/2);
		
		if (b%2 != 0) {
			ans = ans*ans*a;
		}else {
			ans = ans*ans;
		}
		
		
		
		return ans;
	}
	
	

}
