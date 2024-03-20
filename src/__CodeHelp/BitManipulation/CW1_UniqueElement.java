package __CodeHelp.BitManipulation;

public class CW1_UniqueElement {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 1, 4, 3, 2, 4, 5, 5 };
		

		int ans = 0; // Intialize with Zero It will have no iffect on XOR

		for (int i : arr) {
			ans = ans ^ i;
		}
		System.out.println(ans);

	}

	/**
	 * Initialize ans to 0: The ans variable is initialized to 0 because the XOR
	 * operation with 0 has no effect on the value being XORed. It will act as the
	 * initial state before XORing all the elements in the array.
	 * 
	 * XOR operation in the loop: The code iterates through each element i in the
	 * array and performs the XOR operation with ans. Since XOR is commutative
	 * (order doesn't matter) and associative (grouping doesn't matter), the XOR of
	 * all the elements in the array will cancel out the pairs and leave only the
	 * unique element in ans.
	 * 
	 * Let's take the array [1, 2, 1, 4, 3, 2, 4, 5, 5] as an example to understand
	 * how XOR works:
	 * 
	 * ans = 0 ^ 1 = 1 
	 * ans = 1 ^ 2 = 3 
	 * ans = 3 ^ 1 = 2 
	 * ans = 2 ^ 4 = 6 
	 * ans = 6 ^ 3 = 5
	 * ans = 5 ^ 2 = 7 
	 * ans = 7 ^ 4 = 3 
	 * ans = 3 ^ 5 = 6 
	 * ans = 6 ^ 5 = 3 
	 * The final
	 * value of ans: After XORing all the elements in the array, the variable ans
	 * will hold the unique element, which is 3 in this case.
	 * 
	 * The reason this approach works is due to the properties of the XOR operator:
	 * 
	 * x ^ x = 0 (XOR of an element with itself results in 0) x ^ 0 = x (XOR of an
	 * element with 0 results in the element itself) XOR is commutative and
	 * associative (order and grouping don't matter) As a result, when two identical
	 * elements are XORed (e.g., x ^ x), their value becomes 0, and when 0 is XORed
	 * with any other element (e.g., x ^ 0), it remains unchanged. The remaining
	 * unique element will remain as is in the ans variable after all the pairs are
	 * XORed.
	 */

}
