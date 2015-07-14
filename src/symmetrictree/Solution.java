package symmetrictree;


import treenode.TreeNode;

public class Solution {
	//dfs
//	public List<TreeNode> stack = new ArrayList<TreeNode>();
//    public boolean isSymmetric(TreeNode root) {
//    	backTrack(root);
//        for(int i=0,j=stack.size()-1;i<=j;i++,j--){
//        	if(stack.get(i)==null||stack.get(j)==null){
//        		if(stack.get(i)==null&&stack.get(j)==null)
//        			continue;
//        		else
//        			return false;
//        	}
//        	if(stack.get(i).val!=stack.get(j).val)
//        		return false;
//        }
//        return true;
//    }
//    public void backTrack(TreeNode node){
//    	if(node==null)
//    		return;
//    	if(!(node.left==null&&node.right==null)){
//    		backTrack(node.left);
//    		if(node.left==null)
//    			stack.add(node.left);
//    		stack.add(node);
//    		backTrack(node.right);
//    		if(node.right==null)
//    			stack.add(node.right);
//    	}else	
//    		stack.add(node);
//    }
	
	//bfs
    public boolean isSymmetric(TreeNode root) {
    	return isSameTree(root,root);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
        	return p==q;
        }else{
        	if(p.val!=q.val)
        		return false;
        	return isSameTree(p.left,q.right)&&isSameTree(p.right,q.left);
        }
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(3);
//		TreeNode n6 = new TreeNode(3);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		Solution s = new Solution();
		System.out.println(s.isSymmetric(n1));
	}
}
