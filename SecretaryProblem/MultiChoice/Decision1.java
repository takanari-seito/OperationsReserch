
public class Decision1 {

	//次の候補者
	Applicant1 rbest;
	Applicant1 others;
	//Best1採用確率
	double p = 0;

	Decision1(int n,int t,boolean rb,int m,int k,boolean decision,Decision1 brother){
		//System.out.println("t="+t+",\tk="+k+",\trb:"+rb+",\tdecision:"+decision);
		//採用なら
		if(decision==true){
			//採用人数に達した,または最後の候補者なら
			if(k==m||t==n){
				//Best1確率を計算
				this.p = this.p + PrAB(n,t,rb);
				return;
			}
			//相対ベストの場合
			if(rb==true){
				//次の候補者が相対ベストのとき
				this.rbest  = new Applicant1(n,t+1,true ,m,k,null);
				this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
				//次の候補者がそれ以外のとき
				this.others = new Applicant1(n,t+1,false,m,k,this.rbest.cont);
				this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			}
			//そうではない場合
			else{
				//次の候補者が相対ベストのとき
				this.rbest  = brother.rbest;
				this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
				//次の候補者がそれ以外のとき
				this.others = brother.others;
				this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			}
			//現在の応募者のBest1確率を計算
			this.p = this.p + PrAB(n,t,rb);
		}
		//不採用なら
		else{
			//最後の候補者なら
			if(t==n){
				//Best1確率を計算
				this.p = 0;
				return;
			}
			//相対ベストの場合
			if(rb==true){
				//次の候補者が相対ベストのとき
				this.rbest  = new Applicant1(n,t+1,true ,m,k,null);
				this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
				//次の候補者がそれ以外のとき
				this.others = new Applicant1(n,t+1,false,m,k,this.rbest.cont);
				this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			}
			//そうではない場合
			else{
				//次の候補者が相対ベストのとき
				this.rbest  = brother.rbest;
				this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
				//次の候補者がそれ以外のとき
				this.others = brother.others;
				this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			}
		}
		return;
	}

	public double PrAB(int n,int t,boolean rb){
		if(rb==true){
			return (double)t/n;
		}else{
			return 0;
		}
	}

	public double PrRR(int t,boolean rb){
		if(rb==true){
			return (double)1/(t+1);
		}else{
			return (double)t/(t+1);
		}
	}
}
