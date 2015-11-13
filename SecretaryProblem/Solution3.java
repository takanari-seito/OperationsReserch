
public class Solution3 {

	public static void main(String[] args) {
		//rrでaggあり,マルコフ性あり
		//計算時間に問題はないが,3900からメモリが足りなくなる
		//もちろんDecisionクラスを消せばもっとメモリを削減できる
		//が,それは今後の研究に対して汎用性がない
		int n = 3800;
		Applicant3 tree = new Applicant3(n,1);
		//System.out.println(tree.stop.p+","+tree.cont.p);
		System.out.println((int)(100*tree.getProb())+"%");
		return;
	}

}
