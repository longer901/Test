package palindromelinkedlist;

import java.util.ArrayList;
import java.util.List;

import listnode.ListNode;

public class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<Integer>();
        while(head!=null){
        	list.add(head.val);
        	head = head.next;
        }
        for(int i=0,j=list.size()-1;i<=j;i++,j--){
        	if(!list.get(i).equals(list.get(j)))
        		return false;
        }
        return list.size()!=0;
    }
    public static void main(String[] args) {
		Solution s = new Solution();
		ListNode n1 = new ListNode(-16557);
		ListNode n2 = new ListNode(-10914);
		ListNode n3 = new ListNode(-10914);
		ListNode n4 = new ListNode(-16557);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println(s.isPalindrome(n1));
	}
}
