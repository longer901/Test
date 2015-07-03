package wordsearchii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Trie.Trie;


public class Solution {
	
	public int row = 0;
	public int col = 0;
	public Set<String> set = null;
	public char[][] board = null;
	public List<String> resList = new ArrayList<String>();
    public List<String> findWords(char[][] b, String[] words) {
    	if(words.length==0||b.length==0)
    		return resList;
    	board = b;
    	row = board.length;
    	col = board[0].length;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++){
    			set = new HashSet<String>();
        		backtrack(i,j,"",trie);
    		}
    	}
    	return resList;
    }
    public void backtrack(int i,int j,String s,Trie trie){
    	if(j<0||i<0||i>=row||j>=col){
    			return;
    	}else{
    		s +=  board[i][j];
    		String pos = i+"-"+j;
			if(set.contains(pos)||!trie.startsWith(s))
				return;
			if(trie.search(s)&&!resList.contains(s)){
				resList.add(s);
			}
			set.add(pos);
    		backtrack(i-1,j,s,trie);
    		backtrack(i,j+1,s,trie);
    		backtrack(i+1,j,s,trie);
    		backtrack(i,j-1,s,trie);
    		set.remove(pos);
    	}
    }
	public static void main(String[] args) {
		char[][] board= new char[][]{
				{'o','a','a','n'},
				{'e','t','a','e'},
				{'i','h','k','r'},
				{'i','f','l','v'}
		};
		String[] words = {"oath","pea","eat","rain"};
		Solution s = new Solution();
		System.out.println(s.findWords(board, words));
	}
}