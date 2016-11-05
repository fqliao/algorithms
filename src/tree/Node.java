package tree;

import java.util.Objects;

/**
 * @decription:二叉树的节点
 * @version:1.0
 * @date: 2016年11月5日下午3:15:26
 * @author: lfq
 * 
 */
public class Node {
	
	private int data;//数据
	private Node left;//左孩子
	private Node right;//右孩子
	
	public Node(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj == this )
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
		return "Node [data=" + data + ", left=" + left + ", right=" + right
				+ "]";
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	
	
}
