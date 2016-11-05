package stack;

import java.util.Stack;

/**
 * @decription:两个栈实现队列
 * @version:
 * @date: 2016年11月5日下午7:27:28
 * @author: lfq
 * 
 */
public class TwoStackToQueue {

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		while (!queue.isEmpty()) 
		{
			System.out.print(queue.remove()+" ");
			
		}

	}
	
	
}

class MyQueue<T>{
	
	//两个栈
	private Stack<T> stack1;
	private Stack<T> stack2;
	private int size;
	
	public MyQueue() {
		super();
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
		this.size = 0;
	}
	
	//队列增加元素
	public boolean add(T data)
	{
		stack1.push(data);
		size++;
		return true;
	}
	
	//队列删除元素
	public T  remove()
	{
		if(!stack2.isEmpty())
		{
			size--;
			return stack2.pop();
		}
		else//stack2为空
		{
			if(stack1.isEmpty())//stack1为null，则两个栈都没有元素，队列为空
			{
				return null;
			}
			else
			{
				while(!stack1.isEmpty())//将stack1出栈进入stack2
				{
					stack2.push(stack1.pop());
				}
				size--;
				return stack2.pop();
			}
			
		}
			
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
}
