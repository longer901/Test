package binarytreerightsideview;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
     	  return res; 
        }
        List<TreeNode> queue = new ArrayList<TreeNode>(); 
        queue.add(root);
        res.add(root.val);
        while(queue.size()!=0){
     	   int len = queue.size();
     	   for(int i=0;i<len;i++){
     		   TreeNode node = queue.get(0);
     		   queue.remove(0);
     		   if(node.left!=null){
     			   queue.add(node.left);
     		   }
     		   if(node.right!=null){
     			   queue.add(node.right);
     		   }
     	   }
     	   if(queue.size()!=0)
     		   res.add(queue.get(queue.size()-1).val);
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
