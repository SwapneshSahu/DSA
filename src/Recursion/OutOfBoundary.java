package Recursion;

import java.util.ArrayList;
import java.util.List;

public class OutOfBoundary {
	
	

	public static void main(String[] args) {
		class Pair{
			int count  ;
			char ss ;
			public Pair(int count, char ss) {
				super();
				this.count = count;
				this.ss = ss;
			}
			
		}
		
	//	System.out.println(findPaths(2,2,2,0,0));
		
		System.out.println(Math.sqrt(12));
		
		  List<Pair> ll = new ArrayList<>();
		  
		  ll.add(new Pair(10,'e'));
		  ll.add(new Pair(120,'w'));
		  ll.add(new Pair(5,'a'));
		  System.out.println(ll.toString());
		  ll.sort((a,b)-> b.count - a.count);
		  
		  System.out.println(ll.toString());
	}
	
	static int ans ;
	    public static  int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
	        findPathsRec(m,n,maxMove,startRow,startColumn -1,0);
	        return ans;
	    }

	    public static void findPathsRec(int m, int n, int maxMove, int startRow, int startColumn , int move) {  
	        
	        if (move > maxMove) return;

	        if (startRow < 0 || startRow > m || startColumn < 0 || startColumn > n) {
	          ans++;	          
	        }
	        
	        // left move 
	        findPathsRec(m,n,maxMove,startRow,startColumn -1,move+1);
	        //right move 
	        findPathsRec(m,n,maxMove,startRow,startColumn +1,move+1);

	        //up move 
	        findPathsRec(m,n,maxMove,startRow-1,startColumn,move+1);

	        //down move 
	        findPathsRec(m,n,maxMove,startRow+1,startColumn,move+1);
	    }

}
