package RotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
    	if(matrix==null||matrix.length==0)
    		return;
        for(int i=0;i<matrix.length;i++){
        	int start = 0;
        	int end = matrix[i].length-1;
        	while(start<end){
        		int tem = matrix[start][i];
        		matrix[start][i]=matrix[end][i];
        		matrix[end][i] = tem;
        		start++;
        		end--;
        	}
        }
        int max = matrix.length-1;
        for(int i=0;i<2*matrix.length-1;i++){
        	int i1 = i<=max?0:i-max;
        	int j1 = i<=max?i:max;
        	int i2 = i<=max?i:max;
        	int j2 = i<=max?0:i-max;
        	while(i1>=0&&i2<=max&&j1>j2){
        		int tem = matrix[i1][j1];
        		matrix[i1][j1]=matrix[i2][j2];
        		matrix[i2][j2] = tem;
        		i1++;
        		j1--;
        		i2--;
        		j2++;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] nums = new int[][]{ {1,2,3},
									{4,5,6},
									{7,8,9}};
		s.rotate(nums);
		int[][] res = nums;
	}

}
