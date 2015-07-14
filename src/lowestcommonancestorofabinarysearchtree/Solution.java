package lowestcommonancestorofabinarysearchtree;

import java.util.ArrayList;
import java.util.List;


import treenode.TreeNode;

public class Solution {
	public TreeNode pnode;
	public TreeNode qnode;
	public List<TreeNode> qlist = new ArrayList<TreeNode>();
	public List<TreeNode> plist = new ArrayList<TreeNode>();
	public List<TreeNode> temset = new ArrayList<TreeNode>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        pnode = p;
        qnode = q;
        DFSTrack(root);
        int len = Math.min(qlist.size(), plist.size());
        int i = 0;
        for(;i<len;i++){
        	if(qlist.get(i)!=plist.get(i))
        		break;
        }
        return qlist.get(i-1);
    }
    public void DFSTrack(TreeNode root){
    	if(root==null)
    		return;
    	temset.add(root);
    	if(root==pnode){
    		plist = new ArrayList<TreeNode>(temset);
    	}
    	if(root==qnode){
    		qlist = new ArrayList<TreeNode>(temset);
    	}
    	DFSTrack(root.left);
    	DFSTrack(root.right);
    	temset.remove(temset.size()-1);
    }
    public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.right = n7;
		Solution s = new Solution();
		System.out.println(s.lowestCommonAncestor(n1,n4,n7).val);
	}
}
