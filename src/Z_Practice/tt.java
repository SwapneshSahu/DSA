package Z_Practice;

public class tt {

	public static void main(String[] args) {
		int n = 1234567654;
		 int digitCount = 0;
		    int temp = n;
		    while (temp != 0) {
		        digitCount++;
		        temp /= 10;
		    }

		    int div = (int) Math.pow(10, digitCount - 1);
		    int firstDigit = n / div;
		    int lastDigit = n % 10;
		    n=n/10;
		    int middle = n%(div/10);

		    int result = (lastDigit * div) + middle*10 +firstDigit;
		    
        System.out.println(result);
        
	}

}
