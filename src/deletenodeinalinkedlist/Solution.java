package deletenodeinalinkedlist;

import listnode.ListNode;

public class Solution {

    public void deleteNode(ListNode node) {
    	if(node==null||node.next==null)
    		return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
