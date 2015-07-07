package linkedlistcycle;

import listnode.ListNode;

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
        	return false;
    	ListNode p1 = head.next;
    	ListNode p2 = head.next.next;
    	while(p1!=null&&p2!=null){
    		if(p1==p2)
    			return true;
    		if(p1!=null&&p2.next!=null){
    			p1 = p1.next;
    			p2 = p2.next.next;
    		}else{
    			return false;
    		}
    	}
    	return false;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		n1.next = n1;
		n2.next = n1;
		n3.next = n4;
		n4.next = n1;
		System.out.println(s.hasCycle(n1));
	}
}
