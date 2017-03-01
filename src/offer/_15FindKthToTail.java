package offer;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class _15FindKthToTail {

	public static ListNode FindKthToTail(ListNode head,int k) {
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
		
		ListNode node = FindKthToTail(head, 1);
		if(node != null){
			System.out.println(node.val);
		}
		else{
			System.out.println(node);
		}

	}

}
