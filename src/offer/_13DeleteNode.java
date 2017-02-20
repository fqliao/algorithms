package offer;

public class _13DeleteNode {

	public static void main(String[] args) {
		LinkList list = new LinkList();
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.print();
		list.delete(2);
		System.out.println();
		list.print();
	}

}

class Node{
	int data;
	Node next;
	public Node(Node node){
		this.next = node;
	}
	public Node(Node node, int data){
		this.data = data;
		this.next = node;
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
	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}
	
}

class LinkList{
	Node head;
	Node current;
	int size;
	public LinkList(){
		this.head = new Node(null);
		this.current = this.head;
		this.size = 0;
	}
	
	public void position(int index){
		if(index < -1  || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		if(index == -1){
			this.current = this.head;
			return;
		}
		int i = 0;
		current = this.head.getNext();
		while(i < index && current!= null){
			current = current.getNext();
			i++;
		}
	}
	public void add(int index,int data){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("插入位置超越范围");
		}
		position(index-1);
		Node newNode = new Node(current.getNext(),data);
		current.setNext(newNode);
		size++;
	}
	//传统方式 定位到被删除节点的前一个节点 O(n)
	public void delete(int index){
		if(index < 0 || index > size-1){
			throw new  IndexOutOfBoundsException("删除位置超越范围");
		}
		position(index-1);
		current.setNext(current.getNext().getNext());
		this.size--;
	}
	
	public void print(){
		current = this.head.getNext();
		while(current != null){
			System.out.print(current.getData()+" ");
			current = current.getNext();
		}
	}
}
