package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_number {
	//46. Permutations
	public static void main(String[] args) {
		int [] nums = new int [] {1,2,3};
		List<List<Integer>> ans = permute (nums);

				
				
				for (int i = 0; i < ans.size(); i++) {
					System.out.print("[");
					for (int j = 0; j < ans.get(i).size(); j++) {

						System.out.print(ans.get(i));
					}
					System.out.println("]");
				}

	}

	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  list = new  ArrayList<List<Integer>>() ;
        help(list  ,nums ,0);
        return list;
    }

    public static void help( List<List<Integer>> list , int[] nums ,int index){
    if (index >= nums.length){
    	List<Integer> ll = new ArrayList<>();
    	for (int i :nums) {
    		ll.add(i);
    	}
        list.add(ll);
        return;
    }
     
     for (int i=index ;i<nums.length ;i++){

         swap(i,index,nums);
         help(list,nums,index+1);
         swap(i,index,nums);
     }

    }

    public static void swap(int i ,int index ,int[] nums  ){
          int temp = nums[i];
          nums[i] = nums[index];
          nums[index] = temp;

    }
}
