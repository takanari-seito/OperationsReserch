
public class Applicant3 {

	//決定
	Decision3 stop;
	Decision3 cont;

	Applicant3(int n,int t){
		//相対ベストの場合
		//System.out.println("t="+t+",rr="+rr);
		//採用時と不採用時に移動
		this.stop = new Decision3(n,t,true,true);
		this.cont = new Decision3(n,t,true,false);
		//System.out.println(this.stop.p+","+this.cont.p);
		return;
	}

	Applicant3(int n,int t,Decision3 brother){
		//相対ベストでない場合
		//System.out.println("t="+t+",rr="+rr);
		//採用時と不採用時に移動
		this.stop = new Decision3(n,t,false,true,brother);
		this.cont = new Decision3(n,t,false,false,brother);
		//System.out.println(this.stop.p+","+this.cont.p);
		return;
	}

	public double getProb(){
		return Math.max(this.stop.p,this.cont.p);
	}
}
