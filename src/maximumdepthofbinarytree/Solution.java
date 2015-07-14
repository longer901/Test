package maximumdepthofbinarytree;


import treenode.TreeNode;

public class Solution {
	//BFS accepted
//    public int maxDepth(TreeNode root) {
//    	if(root==null)
//    		return 0;
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.add(root);
//        int n = 1;
//        while(queue.size()!=0){
//        	int len = queue.size();
//        	for(int i =0 ;i<len;i++){
//            	TreeNode t = queue.remove();
//            	if(t.right!=null)
//            		queue.add(t.right);
//            	if(t.left!=null)
//            		queue.add(t.left);
//        	}
//        	if(queue.size()!=0)
//        		n++;
//        }
//        return n;
//    }
	
	//DFS accepted
    public int maxDepth(TreeNode root) {
    	if(root==null)
    		return 0;
    	return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
        	return p==q;
        }else{
        	if(p.val!=q.val)
        		return false;
        	return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
    
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(1);
//		TreeNode n3 = new TreeNode(3);
//		TreeNode n4 = new TreeNode(11);
//		TreeNode n5 = new TreeNode(13);
////		TreeNode n6 = new TreeNode(4);
//		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
//		n1.right = n3;
//		n2.left = n4;
//		n2.right = n5;
//		n3.left = n6;
//		n4.right = n7;
		Solution s = new Solution();
		System.out.println(s.maxDepth(n1));
	}
}
