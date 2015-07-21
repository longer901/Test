package swapnodesinpairs;

import listnode.ListNode;

public class Solution {
	//µü´ú
//    public ListNode swapPairs(ListNode head) {
//    	if(head==null||head.next==null)
//    		return head;
//        ListNode dummy = new ListNode(-1);
//        dummy.next = head;
//        ListNode pre = dummy;
//        ListNode second = pre.next.next;
//        while(pre.next!=null&&pre.next.next!=null){
//        	ListNode first = pre.next;
//        	second = first.next;
//        	pre.next = second;
//        	first.next = second.next;
//        	second.next = first;
//        	pre = first;
//        }
//        return dummy.next;
//    }
    
	
	
    public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		ListNode h = s.swapPairs(null);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
		System.out.println(5>>1);
	}
    //µÝ¹é
    public ListNode swapPairs(ListNode head) {
    	if(head==null||head.next==null)
    		return head;
    	ListNode tem = head.next;
    	head.next = tem.next;
    	tem.next = head;
    	head.next = swapPairs(head.next);
		return tem;
	}
}
