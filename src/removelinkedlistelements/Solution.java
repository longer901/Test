package removelinkedlistelements;

import listnode.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null){
        	return null;
        }
        ListNode newHead = new ListNode(Integer.MAX_VALUE);
        newHead.next = head;
        ListNode p =newHead;
        while(p.next!=null){
        	if(p.next.val==val)
        		p.next = p.next.next;
        	else
        		p = p.next;
        }
    	return newHead.next;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
//		ListNode n4 = new ListNode(4);
//		ListNode n5 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
//		n3.next = n4;
//		n4.next = n5;
		ListNode h = s.removeElements(n1,1);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
