package removeduplicatesfromsortedlistii;

import listnode.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
        	return head;
        }
        ListNode p = new ListNode(Integer.MAX_VALUE);
        p.next = head;
        ListNode next = p.next;
        ListNode newHead = p;
        boolean flag = false;
        while(next!=null){
        	if(next.next!=null&&next.val==next.next.val){
            	flag = true;
        	}else{
        		if(flag){
        			p.next = next.next;
        		}else
        			p = next;
        		flag = false;
        	}
    		next = next.next;
        }
    	return newHead.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode h = s.deleteDuplicates(n1);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
