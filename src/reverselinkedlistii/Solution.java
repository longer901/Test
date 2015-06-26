package reverselinkedlistii;

import listnode.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
        	return head;
        ListNode tem = new ListNode(1);
        tem.next = head;//¸¨ÖúÍ·ÔªËØ
        int i = 1;
        ListNode h2 = tem;
        while(i<m){
        	h2=h2.next;
        	i++;
        }
        ListNode h = h2.next;
    	ListNode f = h2.next;
    	while(i<n){
    		ListNode next = h.next;
    		h.next = next.next;
    		next.next = f;
    		f= next;
    		h2.next = f;
    		i++;
    	}	
    	return tem.next;
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
		ListNode h = s.reverseBetween(n1,1,6);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
