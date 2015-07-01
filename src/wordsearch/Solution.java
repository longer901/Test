package wordsearch;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int row = 0;
	public int col = 0;
	public Set<String> set = new HashSet<String>();
	public char[][] board = null;
	public String word = null;
    public boolean exist(char[][] b, String w) {
    	if(w.length()==0||b.length==0)
    		return false;
    	board = b;
    	word = w;
    	row = board.length;
    	col = board[0].length;
        for(int i=0;i<row;i++){
        	for(int j=0;j<col;j++){
        		if(word.charAt(0)==board[i][j]&&backtrack(i,j,0)){
        			return true;
        		}
        	}
        }
    	return false;
    }
    public boolean backtrack(int i,int j,int target){
    	if(j<0||i<0||i>=row||j>=col||word.length()==target){
    		return word.length()==target?true:false;
    	}else{	
    		String pos = i+"-"+j;
    		if(board[i][j]==word.charAt(target)&&!set.contains(pos)){
    			target++;
				set.add(pos);
    			boolean res = backtrack(i-1,j,target)||backtrack(i,j+1,target)||backtrack(i+1,j,target)||backtrack(i,j-1,target);
    			if(res){
        			System.out.println(target+"=="+i+"-"+j);
        			return true;
    			}else{
    				set.remove(pos);
    			}
    			//return res;
    		}
    		return false;
    	}
    }
	public static void main(String[] args) {
		char[][] board= new char[][]{
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};
		Solution s = new Solution();
		System.out.println(s.exist(board, "ABCCDE"));
	}
}
