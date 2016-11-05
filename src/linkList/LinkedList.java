package linkList;


/**
 * @decription:链表类
 * @version:1.0
 * @date: 2016年11月5日下午5:36:50
 * @author: lfq
 * 
 */
public class LinkedList {
	
	private Node head;//头节点
	private Node current;//当前节点
	private int size;//节点数
	
	//初始化一个空链表
	public LinkedList()
	{
		this.head = new Node(null);
		this.current = head;
		this.size = 0;
	}
	
	//定位节点，定位到当前索引节点
	public void position(int index){ //定位范围index-->[-1,size-1]
		if(index<-1 || index > size-1){
			throw new IndexOutOfBoundsException("索引越界");
		}
		//如果当前节点是头结点，则不用往前查了,结束
		if(index == -1 && this.current == this.head){
			return;
		}
		int j = 0;//循环变量
		this.current = this.head.getNext();//***将当前节点设置到第一个节点
		while(this.current!=null && j<index){
			this.current = this.current.getNext();
			j++;
		}
	}
	
	public int add(int element) {//插入范围index-->[0,size]
		position(size-1);//定位到该节点的前一个节点（***这句在下一句之前 否则功能实现但是多了很多指针，不可约，一定要由执行步骤画图分析）
		Node newNode = new Node(element,this.current.getNext());
		this.current.setNext(newNode);
		size++;
		return 0;
	}
	
	public int add(int index, int element) {//插入范围index-->[0,size]
		if(index<0 || index > size){
			throw new IndexOutOfBoundsException("索引越界");
		}
		position(index-1);//定位到该节点的前一个节点（***这句在下一句之前 否则功能实现但是多了很多指针，不可约，一定要由执行步骤画图分析）
		Node newNode = new Node(element,this.current.getNext());
		this.current.setNext(newNode);
		size++;
		return 0;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getCurrent() {
		return current;
	}

	public void setCurrent(Node current) {
		this.current = current;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
