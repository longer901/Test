package SetMatrixZeroes;

public class Solution {
	//m*n	time O(n2)
	//		space O(m)
	public void setZeroes(int[][] matrix) {
	   int[] colMark = new int[matrix[0].length];
	   for(int i=0;i<matrix.length;i++){
		   boolean flag = false;
		   for(int j=0;j<matrix[i].length;j++){
			   if(matrix[i][j]==0){
				   flag = true;
				   colMark[j] = 1;
			   }
		   }
		   if(flag){
			   for(int j=0;j<matrix[i].length;j++)
				   matrix[i][j]=0;
		   }
	   }
	   for(int j=0;j<matrix[0].length;j++){
		   if(colMark[j] != 1)
			   continue;
		   for(int i=0;i<matrix.length;i++)
			   matrix[i][j]=0;
	   }
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] matrix = new int[][]{
				{1,0}
		};
		s.setZeroes(matrix);
		for(int[] x : matrix)
			for(int k : x)
				System.out.print(k);
	}
}
