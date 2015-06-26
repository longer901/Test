package Sudoku;


public class Solution {
	
	public char[][] board = null;
	public String[] gong = new String[]{
			"0022","0325","0628",
			"3052","3355","3658",
			"6082","6385","6688"
			};
	
	public boolean isValidSudoku(char[][] b) {
		this.board = b;     
        boolean flag = true;
        int k = -1;
        while(++k<=80){
        	System.out.println(k);
        	if(!valid(k))
        		return false;  
        }//end while   
        return flag;
	}
	public boolean valid(int n){
		int r = n/9;
		int c = n%9;
		if(board[r][c]=='.')
			return true;
		char mark =  board[r][c];
		//去除行列已经存在的值
		for(int i=0;i<9;i++){//行列
			if(board[r][i]==mark)
				if(i!=c)
					return false;
			if(board[i][c]==mark)
				if(i!=r)
					return false;
		}
		//去除宫格内存在的值
		int k = (r/3)*3+c/3;
		String s = gong[k];
		for(int i=s.charAt(0)-48;i<=s.charAt(2)-48;i++){
				for(int j=s.charAt(1)-48;j<=s.charAt(3)-48;j++){
					if(board[i][j]==mark)
						if(i!=r||j!=c)
							return false;
				}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		char[][] board= new char[][]{
				{'.','.','9','7','4','8','.','.','.'},
				{'7','.','.','.','.','.','.','.','.'},
				{'.','2','.','1','.','9','.','.','.'},
				{'.','.','7','.','.','.','2','4','.'},
				{'.','6','4','.','1','.','5','9','.'},
				{'.','9','8','.','.','.','3','.','.'},
				{'.','.','.','8','.','3','.','2','.'},
				{'.','.','.','.','.','.','.','.','6'},
				{'.','.','.','2','7','5','9','.','.'}
		};
		System.out.println(s.isValidSudoku(board));
	}
}
