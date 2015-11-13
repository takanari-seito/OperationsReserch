
public class Solution2 {

	public static void main(String[] args) {
		//rrのaggあり
		//n=20から遅くなる
		int n = 20;
		Applicant2 tree = new Applicant2(n,1,true);
		System.out.println((int)(100*tree.getProb())+"%");
		return;
	}

}
