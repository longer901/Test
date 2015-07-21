package reversenodesinkgroup;


import listnode.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head==null||head.next==null||k==0||k==1)
    		return head;
        int len = 1;
        ListNode t = head;
        while(t.next!=null&&len<k){
        	len++;
        	t = t.next;
        }
        if(len<k)
        	return head;
        ListNode remain = t.next;
        t.next = null;
        //reverse leftside list
    	ListNode newhead = head;
    	while(head.next!=null){
    		ListNode tt = head.next;
    		head.next = head.next.next;
    		tt.next = newhead;
    		newhead= tt;
    	}
    	//merge the remains to left
    	head.next = reverseKGroup(remain,k);
    	return newhead;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		ListNode h = s.reverseKGroup(n1,7);
		while(h!=null){
			System.out.println(h.val+"-");
			h=h.next;
		}
	}
}
