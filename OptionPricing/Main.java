
public class Main {

	public static void main(String[] args) {

		//class変数を用いないで計算する方法ある?

		EuropeanOption.n = 1000;
		EuropeanOption.u = 1.106;
		EuropeanOption.d = 1/EuropeanOption.u;
		EuropeanOption.p = 0.5;
		EuropeanOption.S = 100;
		AmericanOption.n = EuropeanOption.n;
		AmericanOption.u = EuropeanOption.u;
		AmericanOption.d = EuropeanOption.d;
		AmericanOption.p = EuropeanOption.p;
		AmericanOption.S = EuropeanOption.S;
		long start, end;

		start = System.nanoTime();
		EuropeanOption.point = 0;
		Node root1 = new Node();
		root1 = EuropeanOption.calcEuropeanOption(root1,0,0);
		System.out.println("EuropeanOption:"+(int)root1.O+", # of Node:"+EuropeanOption.point);
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + "ms");

		System.out.println();

		start = System.nanoTime();
		AmericanOption.point = 0;
		Node root2 = new Node();
		root2 = new Node();
		root2 = AmericanOption.calcOptionWithBinomialTree(root2,0,0);
		System.out.println("AmericanOption:"+(int)root2.O+", # of Node:"+AmericanOption.point);
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + "ms");

		return;
	}



}
