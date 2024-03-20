package __CodeHelp.Arrays.BinarySearch.SearchSpace;

public class AS4_ParathSpoj {

	/**
	 * IEEE is having its AGM next week and the president wants to serve cheese
	 * prata after the meeting. The subcommittee members are asked to go to food
	 * connection and get P (P<=1000) pratas packed for the function. The stall has
	 * L cooks (L<=50) and each cook has a rank R (1<=R<=8). A cook with a rank R
	 * can cook 1 prata in the first R minutes 1 more prata in the next 2R minutes,
	 * 1 more prata in 3R minutes and so on (he can only cook a complete prata) (For
	 * example if a cook is ranked 2, he will cook one prata in 2 minutes one more
	 * prata in the next 4 mins an one more in the next 6 minutes hence in total 12
	 * minutes he cooks 3 pratas in 13 minutes also he can cook only 3 pratas as he
	 * does not have enough time for the 4th prata). The webmaster wants to know the
	 * minimum time to get the order done. Please write a program to help him out.
	 */
	public static void main(String[] args) {
		int paratha =8;
		int [] cook = new int [] {1};
		
		System.out.println(minTimeForAllParatha(paratha ,cook));

	}

	public static int minTimeForAllParatha(int paratha, int[] cook) {
	
		int low =0 ;
		int high=0;
		
		int i=1; // If we give all the paratha to cook with max rating will take longest time 
		while (i <= paratha) {
			high += cook[cook.length-1]* i;
			i++;
		}
		
		int ans =-1;
		while (low <=high) {
			int mid = low +(high -low)/2;
			
			if (isPossible(cook,mid,paratha)) {
				ans =  mid;
				 high =  mid-1;				 
			}
			else {
				low = mid+1;
			}
		}
		return ans;
	}

	public  static boolean isPossible(int[] cook, int mid, int paratha) {
		
		for (int chef :cook) {
			int currTime=0;
			int i=1;
			while (paratha !=0 && currTime + chef* i <=mid) {
				currTime += chef* i;
				paratha--;
				i++;
			}
			if (paratha == 0) return true;
		}
		
		return false;
	}

}
