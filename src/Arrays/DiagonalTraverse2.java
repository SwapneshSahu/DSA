package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse2 {

	public static void main(String[] args) {
		List<List<Integer>> nums = new ArrayList<List<Integer>>();
		List<Integer> inner = new ArrayList<>();

		inner.add(1);
		inner.add(2);
		inner.add(3);
		nums.add(inner);

		inner = new ArrayList<>();
		inner.add(4);
		inner.add(5);
		inner.add(6);
		nums.add(inner);

		inner = new ArrayList<>();
		inner.add(7);
		inner.add(8);
		inner.add(9);
		nums.add(inner);
		// [[1,2,3],[4,5,6],[7,8,9]]

		int[] ans = findDiagonalOrder(nums);

//		for (int i : ans)
//			System.out.print(i + "  ");
	}

	// [1,4,2,7,5,3,8,6,9]
	public static int[] findDiagonalOrder(List<List<Integer>> nums) {
		List<Integer> ans = new ArrayList<>();
		Map<Integer,List<Integer>> map = new HashMap<>();
		int max= 0;
		for (int i =0 ; i <nums.size() ;i++) {
			for (int j =0 ; j <nums.get(i).size();j++) {
				
				int temp = i+j;
				List<Integer> tt = new ArrayList<>();
				if (map.containsKey(temp)) {
					tt = map.get(temp);
					tt.add(nums.get(i).get(j));
					map.put(temp,tt);
				}
				else {
					tt.add(nums.get(i).get(j));
					map.put(temp,tt);
				}
				
				if (temp > max) max =temp;
			}
		}
		
		int count =0;
		
		while (count <=max) {
			
			for (int i = map.get(count).size() -1 ;i >=0 ;i--) {
				ans.add(map.get(count).get(i));
			}
			count++;
		}
		int [] ansArray = new int [ans.size()];
		 
		for(int i= 0 ; i <ansArray.length ;i++) {
			ansArray[i] = ans.get(i);
		}
		
		return ansArray; 

	}

}
