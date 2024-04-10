package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCardsInIncreasingOrder {

	//leetcode 950
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 //Approach 2
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int [] result = new int [deck.length];
        int j =0 ;//deck

        Queue<Integer> que = new LinkedList<>();
        for (int i =0 ; i<deck.length ;i++ ){
               que.add(i);
        }
        while (!que.isEmpty()){
            int indexResult = que.poll();
            if (!que.isEmpty()){
            int transfer = que.poll();
            que.add(transfer);
            }

            result[indexResult] = deck[j];
            j++;
                        
        }
    return result;    

    }

 /*   //Approach 1
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        int [] result = new int [deck.length];

        int i =0 ; //deck
        int j =0 ;//result

        boolean skip =false;

        while (i <deck.length){
                
            if (result[j] == 0){
                if (!skip){
                    result[j] = deck[i];
                    i++;
                }
                skip = !skip; // alternate                     
            }
            j = (j+1)%deck.length;
        }

     return result;
    } */
}
