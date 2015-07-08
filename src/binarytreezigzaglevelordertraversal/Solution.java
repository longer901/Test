package binarytreezigzaglevelordertraversal;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
	
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<TreeNode> queue = new ArrayList<TreeNode>(); 
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null){
     	  return res; 
        }
        queue.add(root);
        List<Integer> t = new ArrayList<Integer>();
        t.add(root.val);
        res.add(t);
        boolean flag = true;//left-->right
        while(queue.size()!=0){
     	   int len = queue.size();
     	   List<Integer> tem = new ArrayList<Integer>();
     	   for(int i=0;i<len;i++){
     		   TreeNode node = queue.get(0);
     		   queue.remove(0);
     		   if(node.left!=null){
     			   queue.add(node.left);
     			   if(flag)
     				   tem.add(0,node.left.val);
     			   else
     				   tem.add(node.left.val);
     		   }
     		   if(node.right!=null){
     			   queue.add(node.right);
     			   if(flag)
     				  tem.add(0,node.right.val);
     			   else
     				  tem.add(node.right.val);
     		   }
     	   }
     	   if(tem.size()!=0)
     		   res.add(tem);
     	   flag = !flag;
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
