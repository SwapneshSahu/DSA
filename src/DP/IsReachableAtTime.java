package DP;

import java.util.ArrayList;
import java.util.List;

public class IsReachableAtTime {

	public static void main(String[] args) {
		System.out.println(isReachableAtTime(2, 4, 7, 7, 6));

	}
	
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
    	
    	List<List<Boolean >> visited  = new ArrayList<List<Boolean>>();
    	//System.out.println(visited.set));
        return isReachableAtTime(sx,sy, fx, fy, t ,0 ,visited );
   }

   public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t ,int curr, List<List<Boolean>> visited) {
        
      if (sx == fx && sy == fy && t == curr) return true;

      if (t < curr || sx < 0 || sy < 0 ) return false;

      
        //left call
      boolean left = isReachableAtTime(sx,sy+1, fx, fy, t ,curr+1,visited );
       //left call
      boolean right = isReachableAtTime(sx,sy-1, fx, fy, t ,curr+1,visited);
       //left call
      boolean up = isReachableAtTime(sx-1,sy, fx, fy, t ,curr+1,visited);
       //left call
      boolean down = isReachableAtTime(sx+1,sy, fx, fy, t ,curr+1,visited);

      return left ||right || up || down ;

   }

}
