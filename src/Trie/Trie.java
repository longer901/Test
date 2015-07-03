package Trie;
	class TrieNode {
	   // Initialize your data structure here.
		public boolean isEnd = false;
		public TrieNode[] nextLevel;
	    public TrieNode() {
	        nextLevel = new TrieNode[26];
	    }
	}

	public class Trie {
	    private TrieNode root;

	    public Trie() {
	        root = new TrieNode();
	    }

	    // Inserts a word into the trie.
	    public void insert(String word) {
	    	TrieNode one = root;
	        for(int i=0;i<word.length();i++){
	        	int k = word.charAt(i)-97;
	        	if(one.nextLevel[k]==null){
	        		one.nextLevel[k] = new TrieNode();
	        	}
        		if(i==word.length()-1){
        			if(!one.nextLevel[k].isEnd||one.nextLevel[k]==null)
        				one.nextLevel[k].isEnd = true;
        		}
	        	one = one.nextLevel[k];
	        }
	    }

	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	    	TrieNode one = root;
	        for(int i=0;i<word.length();i++){
	        	int k = word.charAt(i)-97;
	        	if(one.nextLevel[k]==null){
	        		return false;
	        	}
	        	if(i==word.length()-1){
	        		return one.nextLevel[k].isEnd;
	        	}
	        	one = one.nextLevel[k];
	        }
	        return true;
	    }

	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	    	TrieNode one = root;
	        for(int i=0;i<prefix.length();i++){
	        	int k = prefix.charAt(i)-97;
	        	if(one.nextLevel[k]==null){
	        		return false;
	        	}
	        	one = one.nextLevel[k];
	        }
	        return true;
	    }
	}
	
