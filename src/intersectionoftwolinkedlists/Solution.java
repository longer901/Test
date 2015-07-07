package intersectionoftwolinkedlists;

import listnode.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
    	if(headA==null||headB==null)
    		return null;
    	ListNode p1 = headA;
    	int n1 = 0;
    	while(p1!=null){
    		n1++;
    		p1=p1.next;
    	}
    	ListNode p2 = headB;
    	int n2 = 0;
    	while(p2!=null){
    		n2++;
    		p2=p2.next;
    	}
		p1 = headA;
		p2 = headB;
    	if(n1>n2){
    		int gap = n1-n2;
    		while(gap>0){
    			gap--;
    			p1=p1.next;
    		}
    	}else{
    		int gap = n2-n1;
    		while(gap>0){
    			gap--;
    			p2=p2.next;
    		}
    	}
    	while(p1!=null&&p2!=null){
    		if(p1==p2)
    			return p2;
    		p1 = p1.next;
    		p2 = p2.next;
    	}
    	return null;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(5);
		ListNode m1 = new ListNode(4);
		ListNode m2 = new ListNode(3);
		ListNode m3 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		m1.next = m2;
		m2.next = m3;
//		m3.next = n3;
		System.out.println(s.getIntersectionNode(n1,m1));
	}
}
