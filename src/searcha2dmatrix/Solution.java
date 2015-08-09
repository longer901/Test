package searcha2dmatrix;

public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix==null||matrix.length==0)
    		return false;
        int sum = matrix.length*matrix[0].length-1;
        int start = 0;
        int end = sum;
        while(start<=end){
        	int mid = (start+end)/2;
        	int i = mid/matrix[0].length;
        	int j = mid%matrix[0].length;
        	if(matrix[i][j]==target)
        		return true;
        	else if(matrix[i][j]<target){
        		start = mid + 1;
        	}else{
        		end = mid-1;
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
		                              {1,   3,  5,  7},
		                              {10, 11, 16, 20},
		                              {23, 30, 34, 50}
		                            };
		Solution s = new Solution();
		System.out.println(s.searchMatrix(matrix, 1));
	}

}
