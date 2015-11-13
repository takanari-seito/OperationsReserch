
public class Decision1 {

	//次の候補者
	Applicant1[] next;
	//Best1採用確率
	double p = 0;

	Decision1(int n,int t,int rr,boolean decision){
		//System.out.println("t="+t+",rr="+rr+",採用:"+decision);
		//最後の候補者の場合
		if(t==n){
			//Best1採用確率を計算
			PrAB(n,t,rr);
			return;
		}
		//採用の場合
		if(decision==true){
			//Best1採用確率を計算
			PrAB(n,t,rr);
			return;
		}
		//不採用の場合
		else{
			//次の応募者に移動
			next = new Applicant1[t+1];
			for(int i=0;i<t+1;i++){
				next[i] = new Applicant1(n,t+1,i+1);
				//Best1採用確率を計算
				this.p = this.p + Math.max(this.next[i].stop.p,this.next[i].cont.p)*PrRR(t);
			}
		}
		return;
	}

	public void PrAB(int n,int t,int rr){
		if(rr==1){
			this.p = (double)t/n;
		}else{
			this.p = 0;
		}
		return;
	}

	public double PrRR(int t){
		return (double)1/(t+1);
	}

}
