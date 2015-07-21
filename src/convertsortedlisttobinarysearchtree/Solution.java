package convertsortedlisttobinarysearchtree;

import listnode.ListNode;
import treenode.TreeNode;

public class Solution {
	//链表的中点，二倍速的遍历
    public TreeNode sortedListToBST(ListNode node) {
    	if(node==null)
    		return null;
    	if(node.next==null)
    		return new TreeNode(node.val);
    	ListNode dummy = node;
    	ListNode one = dummy;
    	ListNode two = dummy;
    	while(two.next!=null&&two.next.next!=null){
    		dummy = one;
    		one = one.next;
    		two = two.next.next;
    	}
    	TreeNode tem = new TreeNode(one.val);
    	if(dummy!=one){
    		dummy.next = null;
    		tem.left = sortedListToBST(node);
    	}
    	if(one.next!=null){
	    	tem.right = sortedListToBST(one.next);
    	}
    	return tem;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution s = new Solution();
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
		TreeNode t = s.sortedListToBST(n1);
		System.out.println(t);
	}

}
