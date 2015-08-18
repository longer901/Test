package piralmatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0)
        	return res;
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==1||n==1){
        	for(int i=0;i<m;i++)
        		for(int j=0;j<n;j++)
        			res.add(matrix[i][j]);
        	return res;
        }
        int num = (int) Math.ceil((double)Math.min(m,n)/(double)2);
        for(int k=0;k<num;k++){
        	int top_i = k;
        	for(int j=k;j<n-1-k;j++)
        		res.add(matrix[top_i][j]);
        	int right_j = n-1-k;
        	for(int i=k;i<m-1-k;i++)
        		res.add(matrix[i][right_j]);
        	int bottom_i = m-1-k;
        	for(int j=n-1-k;j>=k+1;j--)
        		res.add(matrix[bottom_i][j]);
        	int left_j = k;
        	for(int i=m-1-k;i>=k+1;i--)
        		res.add(matrix[i][left_j]);
        	if(top_i==bottom_i&&left_j==right_j)
        		res.add(matrix[k][k]);
        }
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] matrix = new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9},
//				{10,11,12},
		};
		System.out.println(s.spiralOrder(matrix));
	}

}
