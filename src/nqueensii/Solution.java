package nqueensii;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	//�ݹ�
	public int[] list = null;//list��i��������i�У���list[i]��
	public int len = 0;
	public List<String[]> resList= new ArrayList<String[]>();
	public List<String[]> solveNQueens(int n) {
		len = n;
		list = new int[len];
        backtrack(0);
        return resList;
    }
	
	public void backtrack(int k){
		if(k>=len){//�ҵ�
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
	
	public boolean place(int x){//�Ƿ��ڵ�x�У�list��x�����ܹ���������	 
        int i = 0;  
        while(i < x){//ǰx�н��бȽ�
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
