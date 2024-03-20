package Mock_Practice;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KeysAndRooms {

	//	841. Keys and Rooms
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		String ss ="";
		ss.charAt(0);

	}
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	      List<Integer> list = new ArrayList<>();
	      list.add(0);
	      for (int i =0; i<rooms.size() ; i++){
	           
	            if (!list.contains(i)){
	                  return false;
	            }
	       
	        for(int j : rooms.get(i)){
	                 list.add(j);
	             }

	      }

	        return true;
	    }

}
