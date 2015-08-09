package searcha2dmatrixii;


public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null||matrix.length==0)
    		return false;
    	int i=0;
    	int j=matrix[0].length-1;
    	while(j>=0&&i<matrix.length){
    		if(target==matrix[i][j])
    			return true;
    		if(target>matrix[i][j]){
    			i++;
    		}else{
    			j--;
    		}
    	}
        return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
//				  {1, 7,  4},
//				  {2, 8,  5},
//				  {3,  9,  6},
//				  {10,14,  13},
//				  {18,23, 21},
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
//				  {3,   6,  9, 16, 22},
//				  {10, 13, 14, 17, 24},
//				  {18, 21, 23, 26, 30}
              };
		Solution s = new Solution();
		System.out.println(s.searchMatrix(matrix,18));
	}

}
