
public class Solution1 {

	public static void main(String[] args) {
		//m=1でn=2900からメモリが足りなくなる
		//n=100でm=5から計算できなくなる
		int n = 100;
		int m = 3;
		Applicant1 tree = new Applicant1(n,1,true,m,0,null);
		//System.out.println(tree.stop.p+","+tree.cont.p);
		System.out.println((int)(100*tree.getProb())+"%");
		return;
	}

}
