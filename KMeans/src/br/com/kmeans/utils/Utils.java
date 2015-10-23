package br.com.kmeans.utils;

import java.util.LinkedList;
import java.util.List;

import br.com.kmeans.centroid.Centroid;
import br.com.kmeans.record.Record;

public class Utils {
	public static LinkedList<Centroid> getInitalCenters(int k, List<Record> records) {
		LinkedList<Centroid> centers = new LinkedList<Centroid>();
		
		for(int i = 0; i < k; i++) {
			int record = (int) Math.round(Math.random() * records.size());
			
			Centroid center = new Centroid();
			
			center.addRecord(records.get(record));
			
			centers.add(center);
		}
		
		return centers;
	}
}
