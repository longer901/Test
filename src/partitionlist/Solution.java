package partitionlist;

import listnode.ListNode;

public class Solution {
    public ListNode partition(ListNode head, int x) {
        
    	ListNode headhelper = new ListNode(0);
    	headhelper.next = head;
    	ListNode smahelper = new ListNode(0);
    	ListNode pre = smahelper;
    	
    	ListNode cur = headhelper;
    	while(cur.next!=null){
    		while(cur.next!=null&&cur.next.val>=x){
    			cur = cur.next;
    		}
    		if(cur.next!=null){
    			ListNode tar = cur.next;
    			cur.next = cur.next.next;
    			pre.next = tar;
    			tar.next = null;
    			pre = tar;
    		}
    	}
    	pre.next = headhelper.next;
    	return smahelper.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode h = s.partition(n1,3);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
