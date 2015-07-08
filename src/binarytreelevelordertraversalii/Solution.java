package binarytreelevelordertraversalii;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
               List<TreeNode> queue = new ArrayList<TreeNode>(); 
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(root==null){
    	  return res; 
       }
       queue.add(root);
       List<Integer> t = new ArrayList<Integer>();
       t.add(root.val);
       res.add(t);
       while(queue.size()!=0){
    	   int len = queue.size();
    	   List<Integer> tem = new ArrayList<Integer>();
    	   for(int i=0;i<len;i++){
    		   TreeNode node = queue.get(0);
    		   queue.remove(0);
    		   if(node.left!=null){
    			   queue.add(node.left);
    			   tem.add(node.left.val);
    		   }
    		   if(node.right!=null){
    			   queue.add(node.right);
    			   tem.add(node.right.val);
    		   }
    	   }
    	   if(tem.size()!=0)
    		   res.add(0, tem);
       }
       return res;
    }
}