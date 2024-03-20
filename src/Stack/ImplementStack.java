package Stack;

public class ImplementStack {

	public static void main(String[] args) {

		CreateStack stack = new CreateStack(30,15 );
         CreateStack2 ss = new CreateStack2();
    
		ss.push(2147483646);
        ss.push(2147483646);
        ss.push(2147483647);
        System.out.print(ss.top()+ " ");
        ss.pop();
        System.out.print(ss.getMin()+ " ");
        ss.pop();
        System.out.print(ss.getMin()+ " ");
        ss.pop();
        ss.push(2147483647);
        System.out.print(ss.top()+ " ");
        System.out.print(ss.getMin()+ " ");
        ss.push(-2147483648);
        System.out.print(ss.top()+ " ");
        System.out.print(ss.getMin()+ " ");
        ss.pop();
        System.out.print(ss.getMin()+ " ");
        
    //    [2147483647,2147483646,,2147483646,,2147483647,2147483647,,-2147483648,-2147483648,,2147483647]
        

	}

}
