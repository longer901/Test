package uniquepathsii;

public class Solution {
	
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	if(m==0)
    		return 0;
    	int n = obstacleGrid[0].length;
    	if(n==0)
    		return 0;
    	if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1)
    		return 0;
    	int[][] matrix = new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(obstacleGrid[i][j]==1){
					matrix[i][j]=0;
					continue;
				}
				if(i==0&&j==0){
					matrix[0][0] = 1;
					continue;
				}
				int left = i!=0?matrix[i-1][j]:0;
				int top = j!=0?matrix[i][j-1]:0;
				matrix[i][j]=left+top;
			}
		}
		return matrix[m-1][n-1];
    }
    
    
	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] obs = new int[][]{ 
				{0,1,0},
				{0,0,0},
				{0,0,0}
				};
		System.out.println(s.uniquePathsWithObstacles(obs));
	}
}
