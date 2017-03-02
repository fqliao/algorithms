package offer;


/**
 * @decription:链表倒数第k个节点 双指针威力巨大！
 * @version:2.0
 * @date: 2017年3月2日下午7:44:33
 * @author: lfq
 * 
 */
public class _15FindKthToTail {
	//双指针，一次循环 该效率高些
	public static ListNode FindKthToTail1(ListNode head, int k){
        if(head == null)
            return null;
        if(k <= 0)
            return null;
        ListNode p1 = head, p2 = head;
        int i = 0;
        while(i < k-1 && p1 != null){
            p1 = p1.next;
            i++;
        }
        if(p1 == null)
            return null;
        while(p1 != null){
            p1 = p1.next;
            if(p1 == null)
                return p2;
            p2 = p2.next;
        }
        return p2;
    }
	
	//单指针 两次循环
	public static ListNode FindKthToTail2(ListNode head,int k) {
        if(k < 0){
        	return null;
        }
        if(head == null){
            return head;
        }
        ListNode current = head;
        int size = 0;
        while(current != null){
            current = current.next;
            size++;
        }
        if(k > size){
        	return null;
        }
        current = head;
        int i = 1;
        while(current != null && i < (size - k + 1)){
            current = current.next;
            i++;
        }
        return current;
    }
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode current = head;
		while(current != null){
			System.out.print(current.val + " ");
			current = current.next;
		}
		
		ListNode node = FindKthToTail1(head, 1);
		if(node != null){
			System.out.println(node.val);
		}
		else{
			System.out.println(node);
		}

	}

}
