package spiralmatrixii;

public class Solution {

    public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
    	if(n==0)
    		return matrix;
    	int itor = 0;
    	 for(int k=0;k<n;k++){
         	int top_i = k;
         	for(int j=k;j<n-1-k;j++)
         		matrix[top_i][j]=++itor;
         	int right_j = n-1-k;
         	for(int i=k;i<n-1-k;i++)
         		matrix[i][right_j]=++itor;
         	int bottom_i = n-1-k;
         	for(int j=n-1-k;j>=k+1;j--)
         		matrix[bottom_i][j]=++itor;
         	int left_j = k;
         	for(int i=n-1-k;i>=k+1;i--)
         		matrix[i][left_j]=++itor;
         	if(top_i==bottom_i&&left_j==right_j)
         		matrix[k][k]=++itor;
         }
    	return matrix;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] res = s.generateMatrix(3);
		System.out.println();
	}

}
