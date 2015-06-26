package nqueensii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//递归
	public int[] list = null;//list【i】代表：第i行，第list[i]列
	public int len = 0;
	public List<String[]> resList= new ArrayList<String[]>();
	public List<String[]> solveNQueens(int n) {
		len = n;
		list = new int[len];
        backtrack(0);
        return resList;
    }
	
	public void backtrack(int k){
		if(k>=len){//找到
			printRes();
		}else{
			for(int j=0;j<len;j++){
				list[k] = j;
				if(place(k)){
					backtrack(k+1);
				}
			}
		}
	}
	
	public boolean place(int x){//是否在第x行，list【x】列能够放下棋子	 
        int i = 0;  
        while(i < x){//前x行进行比较
            if(list[i] == list[x]||Math.abs(list[i]-list[x]) == Math.abs(i-x)){
                return false;
            }
            i++;
        } 
        return true;
    }
	
	public void printRes(){
		String[] str = new String[len];
		for(int j=0;j<len;j++){
			str[j] = "";
			for(int i=0;i<len;i++){
				if(list[j]==i){
					str[j] +="Q";
				}else{
					str[j] +=".";
				}
			}
//			System.out.println(str[j]);
		}
		resList.add(str);
	}
	public static void main(String[] args){
		Solution s = new Solution();
		s.solveNQueens(8);
	}
}
