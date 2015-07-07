package removeduplicatesfromsortedlist;

import listnode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode start = head;
        while(start.next!=null){
        	if(start.val==start.next.val){
        		start.next = start.next.next;
        	}else{
        		start = start.next;
        	}
        }
        return head;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(2);
//		ListNode n4 = new ListNode(3);
//		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		Solution s = new Solution();
		ListNode h = s.deleteDuplicates(n1);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
