package Stack;

import java.util.Arrays;

class CreateStack {

	int n ;  //size of array
	int s ;  //number of stack
	
	int [] next ;
	int [] top;
	int [] array;
	
	int freespot;
	
	public CreateStack(int n, int s) {
		super();
		this.n = n;
		this.s = s;
		
		next  = new int [n];   // shows next empty spot 
		array = new int [n];  // store the actual number
		top = new int [s];   // store the top element in of each stack;
		
		//intialize next will i+1 index 
		for (int i = 0 ;i <n ;i++) {
			next[i] = i+1;
			if (i<s) top[i] =-1;
		}
		next[n-1] = -1;
		
		this.freespot =0;
		
	}
	
	public boolean push(int num , int stackNum) {
		 if (stackNum > s) return false;
		if (freespot == -1) return false;
		
		int index = freespot;
		
		array[index] = num;
		
		freespot = next[index];
		
		next[index] = top[stackNum -1];
		
		top[stackNum -1] = index;
		
		return true ;
		
	}
	
	public int pop(int stackNum) {
		
		if (top[stackNum -1] == -1) return -1;
		
		  int index =top[stackNum -1];
		  top[stackNum -1] =  next[index];
		  freespot = index;
		  next[index]= freespot;
		  
		return array[index]; 
	}

	@Override
	public String toString() {
		return "CreateStack [n=" + n + ", s=" + s + ", next=" + Arrays.toString(next) + ", top=" + Arrays.toString(top)
				+ ", array=" + Arrays.toString(array) + ", freespot=" + freespot + "]";
	}
	
}


