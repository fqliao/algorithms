package offer;

/**
 * @decription:合并链表  循环不好解决 递归！
 * @version:1.0
 * @date: 2017年3月2日下午8:56:22
 * @author: lfq
 * 
 */
public class _17Merge {
	public static void main(String[] args) {
		//测试用例
		ListNode head11 = new ListNode(1);
		head11.next = new ListNode(3);
		head11.next.next = new ListNode(5);
		head11.next.next.next = new ListNode(7);
		
		ListNode head12 = new ListNode(2);
		head12.next = new ListNode(4);
		head12.next.next = new ListNode(6);
		head12.next.next.next = new ListNode(8);
		
		printList(merge(head11,head12));
		
		ListNode head21 = new ListNode(1);
		
		ListNode head22 = new ListNode(2);
		head22.next = new ListNode(4);
		head22.next.next = new ListNode(6);
		head22.next.next.next = new ListNode(8);
		
		printList(merge(head21,head22));
		
		ListNode head31 = new ListNode(1);
		head31.next = new ListNode(3);
		head31.next.next = new ListNode(3);
		head31.next.next.next = new ListNode(4);
		
		ListNode head32 = new ListNode(2);
		head32.next = new ListNode(4);
		head32.next.next = new ListNode(6);
		head32.next.next.next = new ListNode(8);
		
		printList(merge(head31,head32));
		
		printList(merge(null, null));

	}

	public static ListNode merge(ListNode head1, ListNode head2) {
		if(head1 == null){
			return head2;
		}
		if(head2 == null){
			return head1;
		}
		ListNode head = null;
		if(head1.val < head2.val){
			head = head1;
			head.next = merge(head1.next, head2);
		}
		else{
			head = head2;
			head.next = merge(head1, head2.next);
		}
		return head;
	}
	
	private static void printList(ListNode head) {
		while(head != null){
			System.out.print(head.val + " ");
			head = head.next;
		}
		System.out.println();
	}

}
