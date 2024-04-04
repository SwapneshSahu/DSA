package Matrix;

public class WordSearch {

	public static void main(String[] args) {
		char [][] board = new char[][]
				{{'A','B','C','E'},
			     {'S','F','E','S'},
			     {'A','D','E','E'}};

		System.out.println( exist(board, "ABCESEEEFS"));
	}
	
	
	 public boolean exist(char[][] board, String word) {
	       int m = board.length;
	       int n = board[0].length;

	       for (int i  = 0 ; i<m ; i++){
	         for (int j =0 ; j <n ;j++){
	              
	            if (board[i][j] == word.charAt(0)){
		                char temp = board[i][j];
	                    board[i][j] = '$';
		                if( existRecursion(board,word,m,n,i,j,1,false)) {
		                	 return true;
		                } 
	                    board[i][j] = temp;
		                 
		        }

	         }
	       }

	       return false;
	    }

	    public boolean existRecursion (char[][] board, String word ,int m , int n, int i , int j , int wordIndex, boolean ans) {
	       if (wordIndex >= word.length()){
		         return true;
		      }

		     //check up 
	          
		     if (i-1 >-1  && board[i-1][j] == word.charAt(wordIndex)){
	              char temp = board[i][j];
	                board[i][j] = '$';
	               if (!existRecursion(board,word,m,n,i-1,j,wordIndex+1,ans)){
	                board[i][j] = temp;
	               }else{
	                 ans= true;
	               }
	             
		             
		     }//check down
		      if (i+1 < m   && board[i+1][j] == word.charAt(wordIndex)){
	               char temp = board[i][j];
	                    board[i][j] = '$';
		          if( !existRecursion(board,word,m,n,i+1,j,wordIndex+1,ans)){
	                  board[i][j] = temp;
	              }
	                else{
	                 ans= true;
	               
	              }
		     }//check right 
		      if ( j+1 < n   && board[i][j+1] == word.charAt(wordIndex)){
	              char temp = board[i][j];
	                    board[i][j] = '$';
		           if(! existRecursion(board,word,m,n,i,j+1,wordIndex+1,ans)){
	                  board[i][j] = temp;
	               }else{
	                 ans= true;
	               }
		     } //check left 
		      if (j-1 > -1  && board[i][j-1] == word.charAt(wordIndex)){
	              char temp = board[i][j];
	                    board[i][j] = '$';
		          if (!existRecursion(board,word,m,n,i,j-1,wordIndex+1,ans)){
	                 board[i][j] = temp;
	              }else{
	                 ans= true;
	               }
		     }
		 
		    return ans;
	    }

}
