package UniquePaths;

public class Solution {
	
	//Time Limit Exceeded recersive
	//Last executed input:	23, 12
	public int uniquePaths1(int m, int n) {
		if(m==1&&n==1)
			return 1;
        int left = 0;
        int top  = 0;
        if(m!=0)
        	left = uniquePaths1(m-1,n);
        if(n!=0)
        	top = uniquePaths1(m,n-1);
        return left+top;
    }
	
	public int[][] matrix;
	public int uniquePaths(int m, int n) {
		if(m==0||n==0)
			return 0;
		if(m==1||n==1)
			return 1;
		matrix = new int[m][n];
		for(int i=0;i<m;i++)
			matrix[i][0] = 1;
		for(int i=0;i<n;i++)
			matrix[0][i] = 1;
		for(int i=1;i<m;i++)
			for(int j=1;j<n;j++)
				matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];
		return matrix[m-1][n-1];
	}
	
	public static void main(String[] args) {
		Solution s =new Solution();
		System.out.println(s.uniquePaths(12, 1));
	}
}
