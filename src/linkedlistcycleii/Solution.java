package linkedlistcycleii;

import listnode.ListNode;
//²Î¿¼ÁË´ð°¸
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
        	return null;
    	ListNode p1 = head.next;
    	ListNode p2 = head.next.next;
    	boolean flag = false;
    	while(p1!=null&&p2!=null){
    		if(p1==p2){
    			flag = true;
    			break;
    		}
    		if(p1!=null&&p2.next!=null){
    			p1 = p1.next;
    			p2 = p2.next.next;
    		}else{
    			flag = false;
    			break;
    		}
    	}
    	if(flag){
    		ListNode nhead = head;
    		while(nhead!=p1){
    			nhead = nhead.next;
    			p1 = p1.next;
    		}
    		return p1;
    	}else{
    		return null;
    	}
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n1;
		System.out.println(s.detectCycle(n1).val);
	}
}
