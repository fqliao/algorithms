package offer;

public class _16ReverseList {

	public static void main(String[] args) {
		//设计测试用例
		//1 链表为null
		ListNode head1 =  null;
		printList(reverseList(head1));
		//2 链表只有一个节点
		ListNode head2 = new ListNode(1);
		printList(reverseList(head2));
		//3 链表有多个节点
		ListNode head3 = new ListNode(1);
		head3.next = new ListNode(2);
		head3.next.next = new ListNode(3);
		printList(reverseList(head3));
		

	}
	
	public static ListNode reverseList(ListNode head){
		ListNode node = head, preNode = null, tempNode = null, reverHead = null;
		while(node != null){
			tempNode = node;
			node = node.next;
			if(node == null){
				reverHead = tempNode;
			}
			tempNode.next = preNode;
			preNode = tempNode;
			
		}
		return reverHead;
	}
	private static void printList(ListNode head) {
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}
