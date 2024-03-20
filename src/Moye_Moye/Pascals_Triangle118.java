package Moye_Moye;

import java.util.ArrayList;
import java.util.List;

class Pascals_Triangle118 {

	public static void main(String[] args) {
		
		 List<List<Integer>>  listList = generate(30);
		for (List<Integer> innerList : listList) {
            System.out.print("[");
            for (Integer value : innerList) {
                System.out.print(value + " ");
            }
            System.out.println("]");
        }

	}
	
	public static List<List<Integer>> generate(int row){
		 List<List<Integer>>  result = new ArrayList<List<Integer>>();
		
		List<Integer>  prev = new ArrayList<>();
		int index =1;
		
		while (index<=row) {
			int temp = 2;
			List<Integer>  curr = new ArrayList<>();
			curr.add(1);
			int prevIndex =0;
			while (temp <index && prevIndex <prev.size()-1) {
				 curr.add(prev.get(prevIndex) + prev.get(prevIndex+1) );
				 prevIndex++;
				 temp++;
			}
			if (index !=1) curr.add(1);
			
			result.add(curr);
			prev = new ArrayList<>(curr);
			index++;
			
		}
		
		return result;
		
	}

}
