package rectanglearea;

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A)*(D-B);
        int area2 = (G-E)*(H-F);
        if((E-A>=0&&F-B>=0&&D-H>=0&&C-G>=0)||(E-A<=0&&F-B<=0&&D-H<=0&&C-G<=0))//°üº¬
        	return Math.max(area2, area1);//·ÖÀë
        if(E>=C||A>=G||H<=B||D<=F)
        	return area1+area2;
        int height = 0;
        if(B>=F&&D<=H)
        	height = D-B;
        else if(F>=B&&H<=D)
        	height = H-F;
        else
        	height = D-B+H-F-Math.max(Math.abs(D-F),Math.abs(H-B));
        int width = 0;
        if(E<=A&&G>=C)
        	width = C-A;
        else if(A<=E&&C>=G)
        	width = G-E;
        else
        	width = C-A+G-E-Math.max(Math.abs(C-E),Math.abs(G-A));
        return area1+area2-height*width;
    }
	public static void main(String[] args) {
		Solution s = new Solution();
		//0, 0, 0, 0, -1, -1, 1, 1
		//-2, -2, 2, 2, 3, 3, 4, 4
		//-3,0,3,4,0,-1,9,2
		//-2, -2, 2, 2, -1, -1, 1, 1
		System.out.println(s.computeArea(-2, -2, 2, 2, -3, -3, 3, -1));
	}
}
