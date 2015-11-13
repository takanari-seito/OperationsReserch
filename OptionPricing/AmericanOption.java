
public class AmericanOption {

	static int n;
	static double u;
	static double d;
	static double p;
	static double S;
	static int point;
	//木のノード数は
	//BinomialTree = n^2/2+3n/2+1
	//BinaryTree = 2^(n+1)-1

	public static void main(String[] args) {
		//American Optionを求める
		//Payoff=max(S-X,0)
		//Option(i)=max(Payoff(i),E[Option(i-1)])

		n = 1000;
		u = 1.106;
		d = 1/u;
		p = 0.5;
		S = 100;

		long start, end;

		start = System.nanoTime();
		point = 0;
		Node root = new Node();
		root = calcOptionWithBinomialTree(root,0,0);
		System.out.println("Algrithm with Binomial Tree");
		System.out.println("Option:"+(int)root.O+", # of Node:"+point);
		end = System.nanoTime();
		System.out.println("Time:" + (end - start) / 1000000 + "ms");


		return;
	}

	public static Node calcOptionWithBinomialTree(Node node,int i,int j){
		//AmericanOptionを計算するための関数
		//2項木構造を用いるのでWithBinaryTreeよりも速い
		//↑グラフの合流(兄弟)を認識できる

		point++;

		node.i = i;
		node.j = j;

		//行使価格Xの計算
		node.X = S*Math.pow(u,node.i-node.j)*Math.pow(d,node.j);

		//Payoff Pの計算
		node.P = Math.max(S-node.X,0);

		//葉なら,出力
		if(node.i==n){
			node.O = node.P;
			return node;
		}

		//長男なら,その長男と次男のOptionを計算,自らのOptionを計算
		if(node.j==0){
			node.child1 = new Node();
			node.child1 = calcOptionWithBinomialTree(node.child1,node.i+1,0);
			node.child2 = new Node();
			node.child2.brother1 = node.child1;
			node.child2 = calcOptionWithBinomialTree(node.child2,node.i+1,1);
			node.O = Math.max(node.P,p*node.child1.O+(1-p)*node.child2.O);
			return node;
		}

		//次男なら,その長男を設定,次男のOptionを計算,自らのOptionを計算して出力
		node.child1 = node.brother1.child2;
		node.child2 = new Node();
		node.child2.brother1 = node.child1;
		node.child2 = calcOptionWithBinomialTree(node.child2,node.i+1,node.j+1);
		node.O = Math.max(node.P,p*node.child1.O+(1-p)*node.child2.O);
		return node;

	}

	public static Node calcAmericanOption(Node node,int i,int j){

		point++;

		//頂点番号の入力
		node.i = i;
		node.j = j;

		//System.out.println("("+node.i+","+node.j+")");

		//行使価格の計算
		node.X = S*Math.pow(u,node.i-node.j)*Math.pow(d,node.j);

		//Payoff Pの計算
		node.P = Math.max(S-node.X,0);

		//葉なら,Payoffを計算して出力
		if(node.i==n){
			node.O = node.P;
			return node;
		}

		//長男なら,
		if(node.j==0){
			//子供1を作る
			node.child1 = new Node();
			//子供1のOptionを計算
			node.child1 = calcAmericanOption(node.child1,node.i+1,0);
		}
		//長男でないなら,
		else{
			//子供1を兄の子供1に設定
			node.child1 = node.brother1.child2;
		}

		//子供2を作る
		node.child2 = new Node();
		//子供2の兄を子供1に設定
		node.child2.brother1 = node.child1;
		//子供2のOptionを計算
		node.child2 = calcAmericanOption(node.child2,node.i+1,node.j+1);

		//Optionを計算
		node.O = Math.max(node.P,p*node.child1.O+(1-p)*node.child2.O);

		return node;
	}

}
