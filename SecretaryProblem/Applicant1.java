
public class Applicant1 {

	//決定
	Decision1 stop;
	Decision1 cont;

	Applicant1(int n,int t,int rr){
		//System.out.println("t="+t+",rr="+rr);
		//採用時と不採用時に移動
		this.stop = new Decision1(n,t,rr,true);
		this.cont = new Decision1(n,t,rr,false);
		return;
	}

	public double getProb(){
		return Math.max(this.stop.p,this.cont.p);
	}

}
