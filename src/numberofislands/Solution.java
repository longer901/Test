package numberofislands;

import java.util.Stack;

public class Solution {
	//之访问是1的点 访问过的1 可以置为0 这样以后就不会访问到
    public int numIslands(char[][] board) {
    	int num = 0;
    	if(board==null||board.length==0)
    		return num;
        Stack<String> stack = new Stack<String>();
    	for(int i =0 ;i<board.length;i++){
    		for(int j =0 ;j<board[0].length;j++){
    			if(board[i][j]=='0')
    				continue;
    			stack.push(i+"-"+j);
    			num++;
    	        while(stack.size()!=0){
    	        	String mark = stack.pop();
    	        	String[] index = mark.split("-");
    	        	int r = Integer.valueOf(index[0]);
    	        	int c = Integer.valueOf(index[1]);
            		board[r][c] = '0';
    	        	if(r-1>=0&&board[r-1][c]=='1'){//up
    	        		stack.push(r-1+"-"+c);
    	        	}
    	        	if(r+1<board.length&&board[r+1][c]=='1'){//down
    	        		stack.push(r+1+"-"+c);
    	        	}
    	        	if(c-1>=0&&board[r][c-1]=='1'){//left
    	        		stack.push(r+"-"+(c-1));
    	        	}
    	        	if(c+1<board[0].length&&board[r][c+1]=='1'){//right
    	        		stack.push(r+"-"+(c+1));
    	        	}
    	        }
    		}
    	}
    	return num;
    }
    
    public static void main(String[] args) {
		char[][] board = new char[][]{"11000".toCharArray(),"11000".toCharArray(),"00100".toCharArray(),"00011".toCharArray()};
		Solution s = new Solution();
		System.out.println(s.numIslands(board));

	}
}
