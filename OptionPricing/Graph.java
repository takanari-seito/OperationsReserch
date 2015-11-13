import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Graph extends JFrame{

	XYSeriesCollection data;
	XYSeries series;

	//データを逐次追加する場合のコンストラクタ
	Graph(){
		this.data = new XYSeriesCollection();
		this.series = new XYSeries("");
	}
	//データの逐次追加(int)
	public void addData(int x,int y){
		this.series.add(x,y);
	}

	//データの逐次追加(double)
	public void addData(int x,double y){
		this.series.add(x,y);
	}

	//データの逐次追加(double)
	public void addData(double x,double y){
		this.series.add(x,y);
	}

	//グラフの表示(軸の最大最小値は手動で調節)
	public void showGraph1(){
		this.data.addSeries(this.series);
		JFreeChart chart =
			      ChartFactory.createScatterPlot("title",
			                                     "x",
			                                     "y",
			                                     this.data,
			                                     PlotOrientation.VERTICAL,
			                                     false,
			                                     false,
			                                     false);
		XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(Color.WHITE);
		ChartPanel cpanel = new ChartPanel(chart);
		getContentPane().add(cpanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 500);
		setVisible(true);
	}


	//データを配列として追加する場合のコンストラクタ(中途半端)
	Graph(int[] a,double[] b){
		JFreeChart chart =
			      ChartFactory.createScatterPlot("title",
			                                     "x",
			                                     "y",
			                                     createData(a,b),
			                                     PlotOrientation.VERTICAL,
			                                     false,
			                                     false,
			                                     false);
		XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(Color.WHITE);
		ChartPanel cpanel = new ChartPanel(chart);
		getContentPane().add(cpanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 500);
		setVisible(true);
	}

	Graph(double[] a,double[] b){
		JFreeChart chart =
			      ChartFactory.createScatterPlot("title",
			                                     "x",
			                                     "y",
			                                     createData(a,b),
			                                     PlotOrientation.VERTICAL,
			                                     false,
			                                     false,
			                                     false);
		XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(Color.WHITE);
		ChartPanel cpanel = new ChartPanel(chart);
		getContentPane().add(cpanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 500);
		setVisible(true);
	}

	private XYSeriesCollection createData(int[] a,double[] b){
		XYSeriesCollection data = new XYSeriesCollection();
	    XYSeries series = new XYSeries("series");
	    for (int i= 0;i<a.length;i++){
	      series.add(a[i], b[i]);
	    }
	    data.addSeries(series);
	    return data;
	  }

	private XYSeriesCollection createData(double[] a,double[] b){
	    XYSeriesCollection data = new XYSeriesCollection();
	    XYSeries series = new XYSeries("series");
	    for (int i= 0;i<a.length;i++){
	      series.add(a[i], b[i]);
	    }
	    data.addSeries(series);
	    return data;
	  }

	public void showGraph2(){
		this.data.addSeries(this.series);//??????エラー
		JFreeChart chart =
			      ChartFactory.createScatterPlot("title",
			                                     "x",
			                                     "y",
			                                     this.data,
			                                     PlotOrientation.VERTICAL,
			                                     false,
			                                     false,
			                                     false);
		XYPlot plot = (XYPlot)chart.getPlot();
	    plot.setBackgroundPaint(Color.WHITE);
		ChartPanel cpanel = new ChartPanel(chart);
		getContentPane().add(cpanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 10, 500, 500);
		setVisible(true);
	}

}