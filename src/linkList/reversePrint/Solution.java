package linkList.reversePrint;


import java.util.Stack;

import linkList.LinkedList;
import linkList.Node;

public class Solution {

	public static void main(String[] args) {
		LinkedList root = new LinkedList();
		root.add(1);
		root.add(2);
		root.add(3);
		reversePrint(root);

	}
	
	public static void reversePrint(LinkedList root)
	{
		Stack<Integer> stack = new Stack<>();
		Node current = root.getHead().getNext();
		while(current != null)
		{
			stack.push(current.getData());
			current = current.getNext();
		}
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
		
	}
	

}
