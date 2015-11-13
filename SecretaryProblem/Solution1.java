
public class Solution1 {

	public static void main(String[] args) {
		//aggなし
		//n=10から遅くなる
		int n = 10;
		Applicant1 tree = new Applicant1(n,1,1);
		System.out.println((int)(100*tree.getProb())+"%");
		return;
	}

}
