package Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FoodRatingProblems {
	

	public static void main(String[] args) {
		Long gg = null;
       if (gg == null)System.out.println("yeash");
	}
	HashMap<String, String> foodToCusinMap = new HashMap<>();
	//HashMap<String, Integer> foodToRatingMap = new HashMap<>();	
	HashMap<String,PriorityQueue<FoodRate>  > cuisinesToFoodRateMap = new HashMap<>();
	

	public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for (int i = 0; i <foods.length ;i++ ){
              
              if (cuisinesToFoodRateMap.containsKey(cuisines[i])){
            	  cuisinesToFoodRateMap.get(cuisines[i]).add(new FoodRate(foods[i],ratings[i]));
              }
              else{
                  PriorityQueue<FoodRate> maxRating =
                          new PriorityQueue<>(Comparator.comparingInt((FoodRate foodRate) -> foodRate.rating).reversed());
            	  maxRating.add(new FoodRate(foods[i],ratings[i]));
            	  cuisinesToFoodRateMap.put(cuisines[i], maxRating);
              }
              
              foodToCusinMap.put(foods[i],cuisines[i]);
        }
        

  }

public void changeRating(String food, int newRating) {
	String cuisine = foodToCusinMap.get(food);
	
	for (FoodRate foodRate :cuisinesToFoodRateMap.get(cuisine)) {
		   if (foodRate.food.equals(food)) {
			   foodRate.setRating(newRating);
			   break;
		   }
	}
}

public String highestRated(String cuisine) {
		
	return cuisinesToFoodRateMap.get(cuisine).peek().food;
}
	
	
	
	
	
//	public void FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
//	          
//	          for (int i = 0; i <foods.length ;i++ ){
//	                
//	                if (cuisinesToListFoodMap.containsKey(cuisines[i])){
//	                    List<String> curr = cuisinesToListFoodMap.get(cuisines[i]);
//	                    curr.add(foods[i]);
//	                    cuisinesToListFoodMap.put(cuisines[i],curr);
//	                }
//	                else{
//	                   List<String> curr = new ArrayList<>();
//	                   curr.add(foods[i]);
//	                  cuisinesToListFoodMap.put(cuisines[i],curr);
//	                }
//
//	                foodToRatingMap.put(foods[i],ratings[i]);
//	          }
//
//	    }
//
//	public void changeRating(String food, int newRating) {
//		foodToRatingMap.put(food, newRating);
//	}
//
//	public String highestRated(String cuisine) {
//		int maxRate = 0;
//		String highestRatedFood = "";
//		for (String food : cuisinesToListFoodMap.get(cuisine)) {
//			int currRating = foodToRatingMap.get(food);
//
//			if (maxRate <= currRating) {
//				if (maxRate < currRating) {
//					highestRatedFood = food;
//					maxRate = currRating;
//				} else if (highestRatedFood.compareTo(food) > 0) {
//					highestRatedFood = food;
//				}
//			}
//
//		}
//		return highestRatedFood;
//	}

}



class FoodRate {
	String food ;
	int rating ;
	public FoodRate(String food, int rating) {
		super();
		this.food = food;
		this.rating = rating;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
}
