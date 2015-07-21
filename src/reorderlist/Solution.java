package reorderlist;

import listnode.ListNode;

public class Solution {
    public void reorderList(ListNode head) {
    	if(head==null||head.next==null||head.next.next==null)
    		return;
        int len = length(head);
        int mid = (int)Math.ceil((double)len/(double)2);
        ListNode leftlast = getMid(head,mid);
        ListNode right = leftlast.next;
        right = reverseList(right);
        leftlast.next = null;
        ListNode left = head;
        while(right!=null){
        	ListNode leftnext =left.next;
        	ListNode rightnext = right.next;
        	right.next = left.next;
        	left.next = right;
        	right = rightnext;
        	left = leftnext;
        }
    }
    public int length(ListNode head){
    	int len=0;
    	while(head!=null){
    		head = head.next;
    		len++;
    	}
    	return len;
    }
    public ListNode getMid(ListNode head,int mid){
    	ListNode res = head;
    	int i = 1;
    	while(i<mid){
    		res = res.next;
    		i++;
    	}
    	return res;
    }
    public ListNode reverseList(ListNode node){
    	ListNode dummy = new ListNode(-1);
    	dummy.next = node;
    	ListNode t = node;
    	while(t.next!=null){
    		ListNode n = t.next;
    		t.next = t.next.next;
    		n.next = dummy.next;
    		dummy.next = n;
    	}
    	return dummy.next;
    }
	public static void main(String[] args) {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		Solution s = new Solution();
		s.reorderList(n1);
		while(n1!=null){
			System.out.println(n1.val+"-");
			n1=n1.next;
		}
	}
}
