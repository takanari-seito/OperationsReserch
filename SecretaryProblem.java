import java.util.ArrayList;
import java.util.Random;

public class SecretaryProblem {
//秘書問題の妥当性を検証する。
//秘書を1人雇いたいとする。
//n 人が応募してきている。n という人数は既知である。
//応募者には順位が付けられ、複数の応募者が同じ順位になることはない（1位からn位まで重複無く順位付けできる）。
//無作為な順序で1人ずつ面接を行う。次に誰を面接するかは常に同じ確率である。
//毎回の面接後、その応募者を採用するか否かを即座に決定する。
//その応募者を採用するか否かは、それまで面接した応募者の相対的順位にのみ基づいて決定する。
//不採用にした応募者を後から採用することはできない。
//このような状況で、最良の応募者を選択することが問題の目的である。
//https://ja.wikipedia.org/wiki/%E7%A7%98%E6%9B%B8%E5%95%8F%E9%A1%8C

	public static void main(String[] args) {
		int n = 100;	//候補者人数
		int r = 100000;	//繰り返し回数
		int[] a = new int[n];
		int[] xa = new int[n];
		int mx = 0;
		float mxn = 0;
		int l = 0;	//メモリの節約可
		for(double k=0.00;k<1;k=k+0.01){
			int x = 0;		//最良な候補者(0)を選んだ回数
			for(int j=0;j<r;j++){
				a = makeRNOArray(n);
				int m = n;
				for(int i=0;i<n*k;i++){
					m = Math.min(m,a[i]);
				}
				for(int i=(int)(n*k+1);i<a.length;i++){
					if(a[i]<m){
						if(a[i]==0){
							x++;
						}
						break;
					}
				}
			}
			xa[l] = x;
			if(x>mx){
				mx = x;
				mxn = (float)k;
			}
			l++;
		}
		System.out.println("最適閾値" + mxn);
		System.out.println("最適確率" + mx*100/r);
		showArray(xa);
		return;
	}

	public static int[] makeRNOArray(int n){
		//n要素のランダム非重複配列を生成
		int a[] = new int[n];
		ArrayList<Integer> b = new ArrayList<Integer>();
		int j;
		int k = n;
		for(int i=0;i<n;i++){b.add(i);}
		for(int i=0;i<n;i++){
			j = new Random().nextInt(k);
			a[i] = b.get(j);
			b.remove(j);
			k--;
		}
		//showArray(a);
		return a;
	}

	public static void showArray(int[] a){
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + ",");
		}
		System.out.println("");
	}

}
