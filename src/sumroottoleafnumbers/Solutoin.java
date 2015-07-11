package sumroottoleafnumbers;

import treenode.TreeNode;

public class Solutoin {
	public static int sum= 0;
	public static String mark = "0";
    public int sumNumbers(TreeNode root) {
        dealSum(root);
        return sum;
    }
    public void dealSum(TreeNode node){
    	if(node==null)
    		return ;
    	String tem = mark;
    	mark = Integer.valueOf(mark)+""+node.val; 
    	if(node.left==null&&node.right==null){
    		sum += Integer.valueOf(mark);
    		mark = tem;
    		return;
    	}
    	dealSum(node.left);
    	dealSum(node.right);
    	mark = tem;
    }
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(3);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		Solutoin s = new Solutoin();
		System.out.println(s.sumNumbers(n1));
	}
}
