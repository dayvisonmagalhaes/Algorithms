package br.com.kmeans.chart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import br.com.kmeans.centroid.Centroid;
import br.com.kmeans.record.Record;

public class PlotChart extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final String title = "Iris DataSet";

	public PlotChart(String title, LinkedList<Centroid> centers) {
		super(title);

		final ChartPanel chartPanel = createDemoPanel(centers);

		this.add(chartPanel, BorderLayout.CENTER);

		JPanel control = new JPanel();

		this.add(control, BorderLayout.SOUTH);
	}

	private ChartPanel createDemoPanel(LinkedList<Centroid> centers) {
		JFreeChart jfreechart = ChartFactory.createScatterPlot(title, "X", "Y", createSampleData(centers),
				PlotOrientation.VERTICAL, true, true, false);
		
		XYPlot xyPlot = (XYPlot) jfreechart.getPlot();
		
		xyPlot.setDomainCrosshairVisible(true);
		xyPlot.setRangeCrosshairVisible(true);
		
		XYItemRenderer renderer = xyPlot.getRenderer();
		
		renderer.setSeriesPaint(0, Color.blue);
		
		NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
		
		domain.setRange(0.00, 35.00);
		domain.setTickUnit(new NumberTickUnit(1));
		
		domain.setVerticalTickLabels(true);
		
		NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
		range.setRange(0.0, 20.0);
		
		range.setTickUnit(new NumberTickUnit(1));
		
		return new ChartPanel(jfreechart);
	}

	private XYDataset createSampleData(LinkedList<Centroid> centers) {
		XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
		
		for(int i = 0; i < centers.size(); i++) {
			XYSeries series = new XYSeries(i);
			
			for(Record record : centers.get(i).getRecords()) {
				double x = record.getAttributes().get(0).getValue();
				double y = record.getAttributes().get(1).getValue();
				
				series.add(x, y);
			}
			
			xySeriesCollection.addSeries(series);
		}
		
		return xySeriesCollection;
	}
}
