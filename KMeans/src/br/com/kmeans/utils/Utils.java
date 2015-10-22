package br.com.kmeans.utils;

import java.util.LinkedList;
import java.util.List;

import br.com.kmeans.centers.Centroide;
import br.com.kmeans.record.Record;

public class Utils {
	public static LinkedList<Centroide> getInitalCenters(int k, List<Record> records) {
		LinkedList<Centroide> centers = new LinkedList<Centroide>();
		
		for(int i = 0; i < k; i++) {
			int record = (int) Math.round(Math.random() * records.size());
			
			Centroide center = new Centroide();
			
			center.addRecord(records.get(record));
			
			centers.add(center);
		}
		
		return centers;
	}
}
