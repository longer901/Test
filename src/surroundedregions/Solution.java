package surroundedregions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Solution {
    public void solve(char[][] board) {
    	if(board==null||board.length==0)
    		return;
    	char[][] log = new char[board.length][board[0].length];
    	char[][] res = new char[board.length][board[0].length];
    	for(int i =0 ;i<res.length;i++){
    		for(int j =0 ;j<res[0].length;j++){
    			res[i][j] = 'X';
    		}
    	}
        Stack<String> stack = new Stack<String>();
        Set<Integer> rset = new HashSet<Integer>();
        rset.add(0);rset.add(board.length-1);
        for(int row : rset){
        	for(int i =0 ;i<board[0].length;i++){
        		String mark = row+"-"+i;
        		if(board[row][i]=='O'&&!stack.contains(mark)){
        			stack.add(mark);
        			log[row][i] = '*';
        		}
        	}
        }
        Set<Integer> cset = new HashSet<Integer>();
        cset.add(0);cset.add(board[0].length-1);
        for(int col : cset){
        	for(int i =0 ;i<board.length;i++){
        		String mark = i+"-"+col;
        		if(board[i][col]=='O'&&!stack.contains(mark)){
        			stack.add(mark);
        			log[i][col] = '*';
        		}
        	}
        }
        
        while(stack.size()!=0){
        	String mark = stack.pop();
        	String[] index = mark.split("-");
        	int r = Integer.valueOf(index[0]);
        	int c = Integer.valueOf(index[1]);
        	res[r][c] = 'O';
        	log[r][c] = '*';
        	if(r-1>=0&&board[r-1][c]=='O'&&log[r-1][c]!='*'){//up
        		stack.push(r-1+"-"+c);
        	}
        	if(r+1<board.length&&board[r+1][c]=='O'&&log[r+1][c]!='*'){//down
        		stack.push(r+1+"-"+c);
        	}
        	if(c-1>=0&&board[r][c-1]=='O'&&log[r][c-1]!='*'){//left
        		stack.push(r+"-"+(c-1));
        	}
        	if(c+1<board[0].length&&board[r][c+1]=='O'&&log[r][c+1]!='*'){//right
        		stack.push(r+"-"+(c+1));
        	}
        }
    	for(int i =0 ;i<res.length;i++){
    		for(int j =0 ;j<res[0].length;j++){
    			board[i][j] = res[i][j];
    		}
    	}
    }
    public static void main(String[] args) {
		char[][] board = new char[][]{"OXXOX".toCharArray(),"XOOXO".toCharArray(),"XOXOX".toCharArray(),"OXOOO".toCharArray(),"XXOXO".toCharArray()};
		Solution s = new Solution();
		s.solve(board);
    	for(int i =0 ;i<board.length;i++){
    		for(int j =0 ;j<board[0].length;j++){
    			System.out.print(board[i][j]+"-");
    		}
    		System.out.println();
    	}
	}
}
