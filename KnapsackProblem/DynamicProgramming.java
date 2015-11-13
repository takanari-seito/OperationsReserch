import java.util.Arrays;

public class DynamicProgramming {

	public static void main(String[] args) {
		//ナップサック問題をDPで解く
		int n = 15;
		int[] use    = new int[n];
		int[] value  = makeRandomArray(n);
		int[] weight = makeRandomArray(n);
		int W = 25*n;

		long start = System.nanoTime();
		use = DP3(0,use,value,weight,W);
		int sv = 0, sw = 0;
		for(int i=0;i<use.length;i++){
			sv = sv + use[i]*value[i];
			sw = sw + use[i]*weight[i];
		}
		System.out.println("value:\t"+Arrays.toString(value));
		System.out.println("weight:\t"+Arrays.toString(weight));
		System.out.println(Arrays.toString(use)+",value:"+sv+",weight:"+sw+"(<="+W+")");
		long end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + "ms");
		return;
	}

	public static int[] DP1(int n,int[] use,int[] value,int[] weight,int W){
		//全探索

		//葉の場合はそのまま出力
		if(n==use.length){
			//System.out.print(Arrays.toString(use));
			//System.out.println(":"+calcValue(use,value,weight,W));
			return use;
		}

		//葉ではない場合
		//n番目のアイテムを使わない場合
		int[] no  = use.clone();
		no[n] = 0;
		no = DP1(n+1,no ,value,weight,W);
		//n番目のアイテムを使う場合
		int[] yes  = use.clone();
		yes[n] = 1;
		yes = DP1(n+1,yes,value,weight,W);
		//総価値の大きい組み合わせを出力
		if(calcValue1(yes,value,weight,W)>calcValue1(no,value,weight,W)){return yes;}else{return no;}
	}

	public static int[] DP2(int n,int[] use,int[] value,int[] weight,int W){
		//全探索(Wに工夫)

		//葉の場合はそのまま出力
		if(n==use.length){
			//System.out.print(Arrays.toString(use));
			//System.out.println(":"+calcValue2(use,value,weight,W));
			return use;
		}

		//葉ではない場合
		//n番目のアイテムを使わない場合
		int[] no  = use.clone();
		no[n] = 0;
		no = DP2(n+1,no ,value,weight,W);
		//n番目のアイテムを使う場合
		int[] yes  = use.clone();
		yes[n] = 1;
		yes = DP2(n+1,yes,value,weight,W-weight[n]);
		//総価値の大きい組み合わせを出力
		if(calcValue2(yes,value,weight,W-weight[n])>calcValue2(no,value,weight,W)){return yes;}else{return no;}
	}

	public static int[] DP3(int n,int[] use,int[] value,int[] weight,int W){
		//全探索(Wに工夫;Wで枝切り)

		//Wで枝きり
		if(W<0){
			//System.out.print(Arrays.toString(use));
			//System.out.println(":"+calcValue2(use,value,weight,W));
			return use;
		}

		//葉の場合はそのまま出力
		if(n==use.length){
			//System.out.print(Arrays.toString(use));
			//System.out.println(":"+calcValue2(use,value,weight,W));
			return use;
		}

		//葉ではない場合
		//n番目のアイテムを使わない場合
		int[] no  = use.clone();
		no[n] = 0;
		no = DP3(n+1,no ,value,weight,W);
		//n番目のアイテムを使う場合
		int[] yes  = use.clone();
		yes[n] = 1;
		yes = DP3(n+1,yes,value,weight,W-weight[n]);
		//総価値の大きい組み合わせを出力
		if(calcValue2(yes,value,weight,W-weight[n])>calcValue2(no,value,weight,W)){return yes;}else{return no;}
	}


	public static int calcValue1(int[] use,int[] value,int[] weight,int W){
		if(calcWeight1(use,value,weight)>W){
			return -1;
		}else{
			int sum = 0;
			for(int i=0;i<use.length;i++){
				sum = sum + use[i]*value[i];
			}
			return sum;
		}
	}

	public static int calcWeight1(int[] use,int[] value,int[] weight){
		int sum = 0;
		for(int i=0;i<use.length;i++){
			sum = sum + use[i]*weight[i];
		}
		return sum;
	}

	public static int calcValue2(int[] use,int[] value,int[] weight,int W){
		if(W<0){
			return -1;
		}else{
			int sum = 0;
			for(int i=0;i<use.length;i++){
				sum = sum + use[i]*value[i];
			}
			return sum;
		}
	}

	public static int[] makeRandomArray(int n){
		int[] array = new int[n];
		for(int i=0;i<array.length;i++){
			array[i] = (int)(Math.random()*100);
		}
		return array;
	}

}
