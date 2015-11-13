
public class Decision3 {

	//次の候補者
	Applicant3 rbest;
	Applicant3 others;
	//Best1採用確率
	double p = 0;

	Decision3(int n,int t,boolean rb,boolean decision){
		//相対ベストの場合
		//System.out.println("t="+t+",rb:"+rb+",採用:"+decision);
		//採用の場合
		if(decision==true){
			//Best1採用確率を計算
			PrAB(n,t,rb);
			return;
		}
		//不採用の場合
		else{
			//最後の候補者の場合
			if(t==n){
				//Best1採用確率を計算
				PrAB(n,t,rb);
				return;
			}
			this.rbest = new Applicant3(n,t+1);
			this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
			this.others = new Applicant3(n,t+1,this.rbest.cont);
			this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			return;
		}
	}

	Decision3(int n,int t,boolean rb,boolean decision,Decision3 brother){
		//相対ベストでない場合
		//System.out.println("t="+t+",rb:"+rb+",採用:"+decision);
		//採用の場合
		if(decision==true){
			//Best1採用確率を計算
			PrAB(n,t,rb);
			return;
		}
		//不採用の場合
		else{
			//最後の候補者の場合
			if(t==n){
				//Best1採用確率を計算
				PrAB(n,t,rb);
				return;
			}
			this.rbest = brother.rbest;
			this.p = this.p + Math.max(this.rbest.stop.p,this.rbest.cont.p)*PrRR(t,true);
			this.others = brother.others;
			this.p = this.p + Math.max(this.others.stop.p,this.others.cont.p)*PrRR(t,false);
			return;
		}
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
