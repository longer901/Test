package minimumpathsum;

public class Solution {
	
	
    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	if(m==0)
    		return 0;
    	int n = grid[0].length;
    	if(n==0)
    		return 0;
    	int[][] matrix = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(i==0&&j==0){
					matrix[0][0] = grid[0][0];
				}else if(j==0){
					matrix[i][j] = matrix[i-1][j]+grid[i][j];
				}else if(i==0){
					matrix[i][j] = matrix[i][j-1]+grid[i][j];
				}else{
					int left = i!=0?matrix[i-1][j]:0;
					int top = j!=0?matrix[i][j-1]:0;
					matrix[i][j]=Math.min(left, top)+grid[i][j];
				}
				System.out.println(matrix[i][j]+" i:"+i+" j:"+j);
			}
		}
		return matrix[m-1][n-1];
    }
	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] obs = new int[][]{ 
//				{1,3,2},
//				{6,5,8},
//				{10,3,2}
//				};
		int[][] obs = new int[][]{ 
				{1},
				{6},
				{10}
				};
		System.out.println(s.minPathSum(obs));
	}
}
