
public class Decision2 {

	//次の候補者
	Applicant2 rbest;
	Applicant2 others;
	//Best1採用確率
	double p = 0;

	Decision2(int n,int t,boolean rb,boolean decision){
		//System.out.println("t="+t+",rr="+rr+",採用:"+decision);
		//最後の候補者の場合
		if(t==n){
			//Best1採用確率を計算
			PrAB(n,t,rb);
			return;
		}
		//採用の場合
		if(decision==true){
			//Best1採用確率を計算
			PrAB(n,t,rb);
			return;
		}
		//不採用の場合
		else{
			//次の応募者に移動
			rbest = new Applicant2(n,t+1,true);
			this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
			others = new Applicant2(n,t+1,false);
			this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
		}
		return;
	}

	public void PrAB(int n,int t,boolean rb){
		if(rb==true){
			this.p = (double)t/n;
		}else{
			this.p = 0;
		}
		return;
	}

	public double PrRR(int t,boolean rb){
		if(rb==true){
			return (double)1/(t+1);
		}else{
			return (double)t/(t+1);
		}
	}

}
