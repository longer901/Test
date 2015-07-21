package rotatelist;

import listnode.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null||head.next==null)
    		return head;
        int len = 0;
        ListNode t = head;
        while(t!=null){
        	t=t.next;
        	len++;
        }
    	k = k % len;
    	if(k==0)
    		return head;
    	int index = len - k - 1;
    	ListNode lend = head;
    	while(index>0){
    		lend = lend.next;
    		index--;
    	}
    	ListNode rstart = lend.next;
    	ListNode rend = rstart;
    	while(rend!=null&&rend.next!=null){
    		rend = rend.next;
    	}
    	lend.next = null;
    	rend.next = head;
    	return rstart;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		System.out.println(s.rotateRight(n1,5));
	}
}
