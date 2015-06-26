package sudokusolver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
//fail:Input:	["..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."]
public class Solution {
	
	public char[][] board = null;
	public int[] mark = new int[81];
	public String[] gong = new String[]{
			"0022","0325","0628",
			"3052","3355","3658",
			"6082","6385","6688"
			};
	public List<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	public Set<Integer> nset = new HashSet<Integer>();
	
	public void solveSudoku(char[][] b) {
		
        this.board = b; 
        for(int i=0;i<81;i++){//mark the old nums
    		int r = i/9;
    		int c = i%9;
            ArrayList<Integer> one = new ArrayList<Integer>();
        	if(board[r][c]!='.'){
        		mark[i] = -1;
        		one.add(board[r][c]-48);
        	}
        	res.add(one);
        }
        Integer[] ns = new Integer[]{1,2,3,4,5,6,7,8,9};
        for(int l : ns)
        	nset.add(l);
        
        int k = 0;//81个位置
        while(k>=0){	
        	List<Integer> cntn = places(k,res.get(k).size());
        	//System.out.println(k+"--"+cntn);
        	if(cntn.size()!=0){//存在位置
    			if(mark[k]!=-1){
    				board[k/9][k%9] = (char)(cntn.get(0)+48); 
    			}
        		if(k==80)//成功找到位置
        			break;
    			do{//下探位置
    				k++;
    			}while(mark[k]==-1&&k<=79);
        	}
        	else{//不存在位置
    			if(mark[k]!=-1){//还原
    				board[k/9][k%9] = '.'; 
    			}
    			while(k>0){// 回溯
    				k--;
    				if(mark[k]!=-1){
    	    			board[k/9][k%9] = '.'; 
    	    			res.get(k).remove(0);
    	    			if(res.get(k).size()>0)//回溯停止
    	    				break;
    				}
    			}
    					
    		}
        }//end while
    }
	
	
	public ArrayList<Integer> places(int n,int p){
		if(mark[n]==-1){//原有数组不需要位置固定
			return res.get(n);
		}
		Set<Integer> contains = new HashSet<>();
		if(p==0)//原备选位置用尽，重新选位置
			contains.addAll(nset);
		else	//原备选位置下，重新选位置
			contains.addAll(res.get(n));
		//去除行列已经存在的值
		int r = n/9;
		int c = n%9;
		for(int i=0;i<9;i++){//行列
			if(board[r][i]!='.')
				contains.remove(board[r][i]-48);
			if(board[i][c]!='.')
				contains.remove(board[i][c]-48);
		}
		//去除宫格内存在的值
		int k = (r/3)*3+c/3;
		String s = gong[k];
		for(int i=s.charAt(0)-48;i<=s.charAt(2)-48;i++){
			if(i!=r)
				for(int j=s.charAt(1)-48;j<=s.charAt(3)-48;j++){
					if(j!=c&&board[i][j]!='.')
						contains.remove(board[i][j]-48);
				}
		}
		ArrayList<Integer> result = new ArrayList<Integer>(contains);
		res.set(n, result);
		return result;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
//		char[][] board = new char[][]{
//				{'5','3','.','.','7','.','.','.','.'},
//				{'6','.','.','1','9','5','.','.','.'},
//				{'.','9','8','.','.','.','.','6','.'},
//				{'8','.','.','.','6','.','.','.','3'},
//				{'4','.','.','8','.','3','.','.','1'},
//				{'7','.','.','.','2','.','.','.','6'},
//				{'.','6','.','.','.','.','2','8','.'},
//				{'.','.','.','4','1','9','.','.','5'},
//				{'.','.','.','.','8','.','.','7','9'}
//		};
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
		s.solveSudoku(board);
		for(int i=0;i<s.res.size();i++){
			if(i%9==0){
				System.out.println();
			}
			System.out.print("-"+board[i/9][i%9]+"-");
		}
	}
}
