package addandsearchword;

class TrieNode {
	   // Initialize your data structure here.
		public boolean isEnd = false;
		public TrieNode[] nextLevel;
	    public TrieNode() {
	        nextLevel = new TrieNode[26];
	    }
	}
class WordDictionary {
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
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

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return backtrack(root,0,word);
    }
    
    public boolean backtrack(TrieNode one,int target,String word){
    	int i = target;
    	if(word.charAt(i)!='.'){
        	int k = word.charAt(i)-97;
        	if(one.nextLevel[k]==null){
        		return false;
        	}
        	if(i==word.length()-1){
        		return one.nextLevel[k].isEnd;
        	}
        	return backtrack(one.nextLevel[k],target+1,word);
    	}else{
    		boolean flag = false;
    		for(int j=0;j<one.nextLevel.length;j++){
    			if(one.nextLevel[j]==null){
    				continue;
    			}
            	if(i==word.length()-1){
            		if(one.nextLevel[j].isEnd)
            			return true;
            		else{
            			if(j==one.nextLevel.length-1)
            				return false;
            			continue;
            		}
            	}else{
                   	flag = flag || backtrack(one.nextLevel[j],target+1,word);
            	}
    		}
    		return flag;
    	}
    }
}
public class Solution {
	public static void main(String[] args) {
		 WordDictionary wordDictionary = new WordDictionary();
		 wordDictionary.addWord("at");
		 wordDictionary.addWord("and");
		 wordDictionary.addWord("an");
		 wordDictionary.addWord("add");
		 System.out.println(wordDictionary.search(".at"));
		 System.out.println(wordDictionary.search("a"));
		 wordDictionary.addWord("bat");
		 System.out.println(wordDictionary.search(".at"));
		 System.out.println(wordDictionary.search("an."));
		 System.out.println(wordDictionary.search("a.d."));
		 System.out.println(wordDictionary.search("b."));
		 System.out.println(wordDictionary.search("a.d"));
		 System.out.println(wordDictionary.search("."));
//		 
		 //--------------------
//		 wordDictionary.addWord("adder");
//		 wordDictionary.addWord("adds");
//		 System.out.println(wordDictionary.search("add."));
	}
}
