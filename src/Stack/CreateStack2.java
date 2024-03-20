package Stack;

import java.util.Stack;

public class CreateStack2 {

	class Node {
		int value;
		int min;
		Node next;

		Node(int x, int min) {
			this.value = x;
			this.min = min;
			next = null;
		}
	}

	Node head;

	public void push(int x) {
		if (null == head) {
			head = new Node(x, x);
		} else {
			Node n = new Node(x, Math.min(x, head.min));
			n.next = head;
			head = n;
		}
	}

	public void pop() {
		if (head != null)
			head = head.next;
	}

	public int top() {
		if (head != null)
			return head.value;
		return -1;
	}

	public int getMin() {
		if (null != head)
			return head.min;
		return -1;
	}

	/*
	 * int min = Integer.MAX_VALUE; Stack<Integer> ss ; public CreateStack2() {
	 * this.min = 0; ss = new Stack<Integer>(); }
	 * 
	 * public void push(int val) { if (ss.size() == 0){ min= val; ss.push(val); }
	 * else{ if (val< min){ ss.push ((val - min) + val); min= val; } else{
	 * ss.push(val); } }
	 * 
	 * }
	 * 
	 * public void pop() { if (ss.peek() < min){ min= min +(min - ss.peek());
	 * ss.pop();
	 * 
	 * }else{ ss.pop(); } if (ss.size() == 0) min =0; }
	 * 
	 * public int top() { if (ss.peek() < min){ return min; } return ss.peek(); }
	 * 
	 * public int getMin() { return min; }
	 */
}
