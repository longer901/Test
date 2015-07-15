package mergetwosortedlists;

import listnode.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        head.next = l1;
        ListNode b = head;
        while(b.next!=null&&l2!=null){
        	if(l2.val<b.next.val){
        		ListNode mark = l2.next;
        		l2.next = b.next;
        		b.next = l2;
        		l2 = mark;
        	}
        	b = b.next;
        }
        if(l2!=null)
        	b.next = l2;
        return head.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;

		ListNode n11 = new ListNode(2);
		ListNode n12 = new ListNode(4);
		ListNode n13 = new ListNode(6);
		ListNode n14 = new ListNode(8);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		
		ListNode h = s.mergeTwoLists(n1,null);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
