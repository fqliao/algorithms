package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @decription:两个队列组成栈
 * @version:1.0
 * @date: 2016年11月5日下午7:55:16
 * @author: lfq
 * 
 */
public class TwoQueueToStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		while(!stack.isEmpty())
		{
			System.out.print(stack.pop()+" ");
		}
	}

}

class Stack<T>{
	
	private Queue<T> queue1;
	private Queue<T> queue2;
	private int size;
	
	
	public Stack() {
		super();
		this.queue1 = new LinkedList<>();
		this.queue2 = new LinkedList<>();
		this.size = 0;
	}


	public boolean push(T data)
	{
		if(queue1.add(data))
		{
			size++;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public T pop()
	{	
		T data = null;
		//queue1 queue2只有三种状态 1都为null 2仅queue1为null 3仅queue2为null
		if(!queue1.isEmpty() && queue2.isEmpty())
		{	
			while(!queue1.isEmpty())
			{
				data = queue1.remove();
				if(queue1.isEmpty())//这是queue1对尾的最后一个元素，删除了，没有进入queue2
				{	
					size--;
					return data;
				}
				else
				{
					queue2.add(data);//从queue1删除的元素进入queue2,除了queue1队尾最后一个的元素外
				}
			}
		}
		if(queue1.isEmpty() && !queue2.isEmpty())
		{
			while(!queue2.isEmpty())
			{
				data = queue2.remove();
				if(queue2.isEmpty())//这是queue2对尾的最后一个元素，删除了，没有进入queue1
				{
					size--;
					return data;
				}
				else
				{
					queue1.add(data);//从queue2删除的元素进入queue1,除了queue2队尾最后一个的元素外
				}
			}
		}
		return data;
	}
	
	public boolean isEmpty()
	{
		return size == 0;
	}
	
}