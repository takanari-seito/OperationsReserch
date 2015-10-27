import java.util.Arrays;

public class GreedyMethod {

	public static void main(String[] args) {
		//ナップサック問題をグリーディーで解く
		int n = 1000;
		double[][] x = makeRandomArray(n);
		//double[][] x = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{77, 93, 96, 64, 61, 96, 82, 13, 54, 84, 92, 29, 90, 94, 77},{67, 65, 16, 47, 24, 66, 29, 21, 86, 11, 66, 26, 51, 63, 49},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		int W = 25*n;

		x = greedy(x,W);
		int sv = 0, sw = 0;
		for(int i=0;i<x[1].length;i++){
			sv = sv + (int)(x[0][i]*x[1][i]);
			sw = sw + (int)(x[0][i]*x[2][i]);
		}
		System.out.println("use,value,weight,rerativeValue");
		System.out.println(Arrays.deepToString(x));
		System.out.println("value:"+sv+",weight:"+sw+"(<="+W+")");

	}

	public static double[][] greedy(double[][] x,int W){
		//相対価値を計算
		for(int i=0;i<x[1].length;i++){
			x[3][i] = x[1][i]/x[2][i];
		}

		//相対価値でソート
		x = sortArray(x);

		//相対価値が高い順にアイテムを使う
		for(int i=0;i<x[1].length;i++){
			W = W - (int)x[2][i];
			if(W<0){break;}
			x[0][i] = 1;
		}

		return x;
	}

	public static double[][] makeRandomArray(int n){
		double[][] array = new double[4][n];
		for(int i=0;i<array[1].length;i++){
			array[1][i] = (int)(Math.random()*100);
			array[2][i] = (int)(Math.random()*100);
		}
		return array;
	}

	public static double[][] sortArray(double[][] x){
		double[] a = new double[4];
		for(int i=0;i<x.length-1;i++){
			for(int j=0;j<x[1].length-1;j++){
				if(x[3][j]<x[3][j+1]){
					a[1] = x[1][j];
					a[2] = x[2][j];
					a[3] = x[3][j];
					x[1][j] = x[1][j+1];
					x[2][j] = x[2][j+1];
					x[3][j] = x[3][j+1];
					x[1][j+1] = a[1];
					x[2][j+1] = a[2];
					x[3][j+1] = a[3];
				}
			}
		}
		return x;
	}

}
