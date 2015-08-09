package longestcommonprefix;


public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs==null||strs.length==0)
    		return "";
    	Trie tree = new Trie(strs[0]); 
    	for(int i=1;i<strs.length;i++){
    		tree.insert(strs[i],false);
    	}
    	return strs[0].substring(0, tree.len);
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		String[] strs = {"cas","a"};
		System.out.println(s.longestCommonPrefix(strs));
	}
}


	class TrieNode {
		public boolean isEnd = false;
		public TrieNode[] nextLevel;
	    public TrieNode() {
	        nextLevel = new TrieNode[26];
	    }
	}

	class Trie {
	    private TrieNode root;
	    public int len = 0;
	    private int tem = 0;
	    public Trie(String first) {
	        root = new TrieNode();
	        insert(first,true);
	        len = first.length();
	        tem = first.length();
	    }
	    public void insert(String word,boolean flag) {
	    	TrieNode one = root;
	    	tem=0;
	        for(int i=0;i<word.length();i++){
	        	int k = word.charAt(i)-97;
	        	if(one.nextLevel[k]==null){
	        		one.nextLevel[k] = new TrieNode();
	        		len = Math.min(len, tem);
	        		if(!flag)
	        			return;
	        	}
	        	tem++;
	     		if(i==word.length()-1){
	     			if(!one.nextLevel[k].isEnd||one.nextLevel[k]==null)
	     				one.nextLevel[k].isEnd = true;
	     		}
	        	one = one.nextLevel[k];
	        }
	        len = Math.min(len, tem);
	    }
	}