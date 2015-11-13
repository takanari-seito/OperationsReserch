
public class Applicant2 {

	//決定
	Decision2 stop;
	Decision2 cont;

	Applicant2(int n,int t,boolean rb){
		//System.out.println("t="+t+",rr="+rr);
		//採用時と不採用時に移動
		this.stop = new Decision2(n,t,rb,true);
		this.cont = new Decision2(n,t,rb,false);
		return;
	}

	public double getProb(){
		return Math.max(this.stop.p,this.cont.p);
	}
}
