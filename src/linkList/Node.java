package linkList;

import java.util.Objects;

/**
 * @decription:链表的节点类
 * @version:1.0
 * @date: 2016年11月5日下午5:12:12
 * @author: lfq
 * 
 */
public class Node {
	
	private int data;//数据
	private Node next;//指针域
	
	//头节点构造方法
	public Node(Node next)
	{
		this.next = next;
	}
	//非头节点构造方法
	public Node(int data, Node next) 
	{
		super();
		this.data = data;
		this.next = next;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this)
			return true;
		if(obj.getClass() != this.getClass())
			return false;
		Node other = (Node)obj;
		return Objects.equals(data, other.data);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(data);
	}
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
	
}
