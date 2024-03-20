package Arrays;

public class RotateArray {
//189. Rotate Array
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[] { 1,2,3,4,5};
		rotate(a, 2);
		for (int i :a) System.out.println(i);
	}

	public static void rotate(int[] nums, int k) {
		k = k % nums.length;

		reverse(nums, 0, nums.length - 1 - k);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);

	}

		public static void reverse(int[] arr, int low, int high) {
			int temp = 0;
			while (low < high) {
				temp = arr[low];
				arr[low] = arr[high];
				arr[high] = temp;
				low++;
				high--;
			}

		}

	

}
