
public class Applicant1 {

	//決定
	Decision1 stop;
	Decision1 cont;

	Applicant1(int n,int t,boolean rb,int m,int k,Decision1 brother){
		System.out.println("t="+t+",\tk="+k+",\trb:"+rb);
		//n:総人数,t:現応募者の番号,rb:相対ベスト,m:採用人数,k:現採用人数
		//採用時と不採用時に移動
		//相対ベストの場合
		this.stop = new Decision1(n,t,rb,m,k+1,true ,brother);
		this.cont = new Decision1(n,t,rb,m,k  ,false,brother);
		return;
	}

	public double getProb(){
		return Math.max(this.stop.p,this.cont.p);
	}
}
