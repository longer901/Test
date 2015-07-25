package sortlist;

import listnode.ListNode;

public class Solution {
	//Time Limit Exceeded
//    public ListNode sortList(ListNode head) {
//    	if(head==null||head.next==null)
//    		return head;
//    	ListNode dummy = new ListNode(-1);
//    	dummy.next = head;
//    	ListNode scanner = head;
//    	ListNode prescanner = dummy;
//    	while(scanner.next!=null){
//    		ListNode t = scanner.next;
//    		if(t.val<head.val){
//    			scanner.next = t.next;
//    			t.next = head;
//    			prescanner.next = t;
//       			prescanner = t;
//    		}else{
//    			scanner = scanner.next;
//    		}
//    	}
//    	ListNode right = sortList(head.next);
//    	head.next = null;
//    	ListNode left = sortList(dummy.next);
//    	head.next = right;
//    	if(left==null)
//    		return head;
//    	return left;
//    }
	
  public ListNode sortList(ListNode head) {
	if(head==null||head.next==null)
		return head;
	ListNode dummy = new ListNode(-1);
	dummy.next = head;
	ListNode prehead = dummy;
	ListNode headlast = head;
	ListNode scanner = headlast;
	while(scanner.next!=null){
		ListNode t = scanner.next;
		if(t.val == head.val){
			if(headlast.next==t){
				headlast = headlast.next;
				scanner = scanner.next;
				continue;
			}
			scanner.next = t.next;
			t.next = headlast.next;
			headlast.next = t;
			headlast = t;
		}else if(t.val<head.val){
			scanner.next = t.next;
			t.next = prehead.next;
			prehead.next = t;
			prehead = t;
		}else{
			scanner = scanner.next;
		}
	}
	if(head!=headlast){
		ListNode midfirst = head.next;
		head.next = null;
		ListNode left = sortList(dummy.next);
		ListNode right = sortList(headlast.next);
		head.next = midfirst;
		headlast.next = right;
		return left;
	}else{
		ListNode right = sortList(head.next);
		head.next = null;
		ListNode left = sortList(dummy.next);
		head.next = right;
		return left;
	}
}
	public static void main(String[] args) {
		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(3);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
//		n5.next = n6;
		Solution s = new Solution();
		ListNode h = s.sortList(n1);
		System.out.println(h);
	}
}
