package __CodeHelp.Stack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class CW12_CarFleet {
	
	static class Car{
		int pos ;
		int speed;
		
		public Car(int pos, int speed) {
			super();
			this.pos = pos;
			this.speed = speed;
		}
		
	}

	public static void main(String[] args) {
		
		Map<String, Long> abstractorMap = new HashMap<>() ;
		
		abstractorMap.put("sss",80L);
		
		System.out.println(abstractorMap.getOrDefault("ss",888L));;
		
		Integer a =10; 
		Long b = Long.valueOf(a.intValue());
	//	System.out.println(b);
		
		int[] position = new int[] {6,8};
		int[] speed =  new int[] {3,2};
		
		//System.out.println(carFleet(10, position, speed));
	}
	
	 public static int carFleet(int target, int[] position, int[] speed) {
		 
		List<Car> carList = new ArrayList<>();
		
		for (int i =0 ; i <position.length ;i++) { //1.33  1
			carList.add(new Car(position[i],speed[i]));
		}
		  List<Car> sortedCars = carList.stream()
		            .sorted(Comparator.comparingInt(car -> car.pos))
		            .collect(Collectors.toList());

		  Stack<Double> stack = new Stack<>();
		  
		  for (Car car : sortedCars) {
			  double time  = (double) (target-car.pos)/car.speed;
			   
			   while(!stack.empty() && stack.peek() <= time) {
				   stack.pop();
			   }
			   stack.push(time);
		  }
		return stack.size();
	        
	    }

}
