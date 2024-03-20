package DSASheet251.MapAndSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class O1_MakeArrayUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int minElementsToRemove(ArrayList<Integer> arr) {

		Set<Integer> set = new HashSet<>();
		
		for (int i : arr) set.add(i);

		return arr.size() - set.size();

	}

}
