package insertionsortlist;

import listnode.ListNode;

public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null||head.next==null)
        	return head;
        ListNode reshead = new ListNode(Integer.MIN_VALUE);
        ListNode nhead = new ListNode(Integer.MIN_VALUE);
        nhead.next = head;
        ListNode p = nhead;
        boolean flag = false;
        while(p.next!=null){
        	ListNode target = p.next;
        	if(target.val == reshead.val)
        		flag = true;
        	p.next = p.next.next;
        	ListNode c = reshead;
        	while(c!=null){
        		if(c.val<target.val&&(c.next==null||c.next.val>=target.val)){
        			target.next = c.next;
        			c.next = target;
        			break;
        		}
        		c = c.next;
        	}
        }
        return flag?reshead:reshead.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode h = s.insertionSortList(n1);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
