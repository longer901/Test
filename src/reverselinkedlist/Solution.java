package reverselinkedlist;

import listnode.ListNode;

public class Solution {
	
    public ListNode reverseList(ListNode head) {
    	if(head==null)
    		return null;
        ListNode h = head; 
    	ListNode f = head;
    	while(h.next!=null){
    		ListNode next = h.next;
    		h.next = next.next;
    		next.next = f;
    		f= next;
    	}
    	return f;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(11);
		ListNode n5 = new ListNode(13);
		ListNode n6 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		Solution s = new Solution();
		ListNode h = s.reverseList(null);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
