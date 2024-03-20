import java.util.*;
import java.util.Queue;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		int [] ss = new int []{1,4,3,7,8,9};
		//Arrays.sort(ss, (a, b) -> a.compareTo(b));
		
	//	List <Integer> list = new ArrayList<>();
		Queue<Integer> list = new LinkedList<>();
		list.add(1);
		list.add(13);
		list.add(11);
		list.add(10);
		list.add(111);
		
		System.out.println(list.stream().max((a,b) -> a.compareTo(b)).get());
		
		Stream.of(ss).sorted();
		
	//	ss = Stream.of(ss).sorted().toArray(new int [ss.length]);
		
		// System.out.println(Stream.of(ss).max((a,b).get());

	}

}
