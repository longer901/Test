package maximumproductsubarray;

import java.util.Arrays;

public class Solution {

	public int maxProductNo0(int A[], int n) { // 没有0的数组求最大乘积
		int num1 = A[0];
		int numAll1 = A[0];
		for (int i = 1; i < n; ++i) {
			numAll1 *= A[i];
			num1 = numAll1 > num1 ? numAll1 : num1;
		}

		int num2 = A[n - 1];
		int numAll2 = A[n - 1];
		for (int i = n - 2; i >= 0; --i) {
			numAll2 *= A[i];
			num2 = numAll2 > num2 ? numAll2 : num2;
		}
		return num1 > num2 ? num1 : num2;
	}

	int maxProduct(int A[]) { // 求数组最大乘积
		if (A == null || A.length < 1)
			return 0;
		int index0 = 0;
		int rel1 = A[0];
		int rel2 = A[0];
		boolean have0 = false;
		for (; index0 < A.length; ++index0) {
			if (A[index0] == 0) {
				have0 = true;
				break;
			}
		}
		if (index0 > 0)
			rel1 = maxProductNo0(A, index0); // 没有0的数组的最大乘积
		if (A.length - index0 - 1 > 0) {
			int[] dest = Arrays.copyOfRange(A, index0+1, A.length);
			rel2 = maxProduct(dest);
		}
		// 剩下的数组的最大乘积
		rel1 = rel1 > rel2 ? rel1 : rel2;
		if (have0)
			rel1 = rel1 > 0 ? rel1 : 0;
		return rel1;
	}

	public static void main(String[] args) {
		int[] par = new int[] { 0,2 };
		Solution s = new Solution();
		System.out.println(s.maxProduct(par));
	}

}
