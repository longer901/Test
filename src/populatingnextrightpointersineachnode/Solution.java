package populatingnextrightpointersineachnode;

import java.util.LinkedList;

public class Solution {
//i and ii  all accepted
    public void connect(TreeLinkNode root) {
    	if(root==null)
    		return;
    	TreeLinkNode t = root;
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.add(t);
    	while(queue.size()!=0){
    		int len = queue.size();
    		int count = 0;
    		for(int i=0;i<len;i++){
    			TreeLinkNode tem = queue.remove();
    			if(tem.left!=null){
    				if(count!=0)
    					queue.getLast().next = tem.left;
    				queue.add(tem.left);
    				count++;
    			}
    			if(tem.right!=null){
    				if(count!=0)
    					queue.getLast().next = tem.right;
    				queue.add(tem.right);
    				count++;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
    	TreeLinkNode n1 = new TreeLinkNode(1);
    	TreeLinkNode n2 = new TreeLinkNode(2);
    	TreeLinkNode n3 = new TreeLinkNode(3);
    	TreeLinkNode n4 = new TreeLinkNode(4);
    	TreeLinkNode n5 = new TreeLinkNode(5);
    	TreeLinkNode n6 = new TreeLinkNode(6);
    	TreeLinkNode n7 = new TreeLinkNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
		n3.right = n7;
		Solution s = new Solution();
		s.connect(n1);
		TreeLinkNode n = n1;
	}
	
}
class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
