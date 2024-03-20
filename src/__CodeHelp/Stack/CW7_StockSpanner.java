package __CodeHelp.Stack;

import java.util.Stack;

public class CW7_StockSpanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
//good approach
    class Pair{
         int price;
         int span;

         Pair(int price , int span){
           this.price = price;
           this.span = span;
         }
    }

   Stack<Pair> primaryStack2 ; 
   public void StockSpannerConstructor2() {
       this.primaryStack =  new Stack<>();
   }
   
   public int next2(int price) {
       int span =1 ;  
       while(!primaryStack.isEmpty() && primaryStack2.peek().price <= price){
         span +=   primaryStack2.peek().span;
         primaryStack2.pop();
       }

       primaryStack2.push(new Pair(price,span));
       return span;
   }
	
	// TLE Approach
    Stack<Integer> primaryStack ; //100 80  60 70 60 75 
    public void StockSpannerConstructor1() {
        this.primaryStack =  new Stack<>();
    }
    
    public int next1(int price) {
        int count =1 ; //4
        Stack<Integer> secondaryStack = new Stack<>(); //60 70 
        while(!primaryStack.isEmpty() && primaryStack.peek() <= price){
           secondaryStack.push(primaryStack.pop());
           count++;
        }

        while(!secondaryStack.isEmpty()){
           primaryStack.push(secondaryStack.pop()); 
        }

        primaryStack.push(price);
        return count;
    }

}
