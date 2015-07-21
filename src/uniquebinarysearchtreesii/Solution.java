package uniquebinarysearchtreesii;

import java.util.ArrayList;
import java.util.List;

import treenode.TreeNode;

public class Solution {
	
    public List<TreeNode> generateTrees(int n) {	
    	return generateTree(1,n,n);
    }
    public ArrayList<TreeNode> generateTree(int i,int j,int len){
    	ArrayList<TreeNode> res = new ArrayList<TreeNode>();
    	if(i>j||i<0||j>len){
    		res.add(null);
    		return res;	
    	}
    	if(i==j){
    		res.add(new TreeNode(j));
    		return res;
    	}
    	for(int k = i ;k<=j;k++){
    		TreeNode mid;
    		ArrayList<TreeNode> left = generateTree(i,k-1,len);
    		ArrayList<TreeNode> right = generateTree(k+1,j,len);
    		if(right!=null&&left!=null){
    			for(TreeNode l : left){
	    			for(TreeNode r : right){
	    				mid = new TreeNode(k);
	    				mid.left = l;
	    				mid.right = r;
	    				res.add(mid);
	    			}
    			}
    		}else if(right!=null){
    			for(TreeNode n : right){
    				mid = new TreeNode(k);
    				mid.right = n;
    				res.add(mid);
    			}
    		}else if(left!=null){
    			for(TreeNode n : left){
    				mid = new TreeNode(k);
    				mid.left = n;
    				res.add(mid);
    			}
    		}
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		List<TreeNode> res = s.generateTrees(3);
		System.out.println(res.size());
	}

}
