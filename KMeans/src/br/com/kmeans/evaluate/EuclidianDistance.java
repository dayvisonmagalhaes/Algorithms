package br.com.kmeans.evaluate;

import br.com.kmeans.centroid.Centroid;
import br.com.kmeans.record.Record;

public class EuclidianDistance {
	public static double calculaDistance(Centroid center, Record record) {
		double distance = 0;
		
		for(int i = 0; i < center.getCenters().size(); i++) {
			if(i == 5) {
				int a = 0;
				
				int b = a;
			}
			
			distance += Math.pow(center.getCenters().get(i) - record.getAttributes().get(i).getValue(), 2);
		}
		
		return distance * distance;
	}
}
