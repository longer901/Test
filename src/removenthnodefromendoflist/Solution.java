package removenthnodefromendoflist;

import listnode.ListNode;

public class Solution {
	
    public ListNode removeNthFromEnd(ListNode head, int n) {
    	n--;
    	ListNode right= head;
    	int k=0;
    	while(k<n+1){
    		right = right.next;
    		k++;
    	}
    	if(right==null)
    		return head.next;
    	ListNode left=head;
    	while(right.next!=null){
    		right = right.next;
    		left = left.next;
    	}
    	left.next = left.next.next;
    	return head;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(4);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(11);
		ListNode n5 = new ListNode(13);
		ListNode n6 = new ListNode(4);
		n1.next = null;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = null;
		Solution s = new Solution();
		//ListNode h = n1;
		ListNode h = s.removeNthFromEnd(n1, 1);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
