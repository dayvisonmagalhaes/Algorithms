package br.com.kmeans.centers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.kmeans.record.Record;

public class Centroide {
	private List<Record> records;
	private LinkedList<Double> centers;
	
	public Centroide() {
		this.records = new ArrayList<Record>();
		this.centers = new LinkedList<Double>();
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public LinkedList<Double> getCenters() {
		return centers;
	}

	public void setCenters(LinkedList<Double> centers) {
		this.centers = centers;
	}
	
	public void addRecord (Record record) {
		this.records.add(record);
	}
	
	public void calculateCenter() {
		this.centers = new LinkedList<Double>();
		
		if(records.size() > 0) {
			for(int i = 0; i < this.records.get(0).getAttributes().size() - 1; i++) {
				double attValue = 0;
				
				for(Record record : records) {
					attValue += record.getAttributes().get(i).getValue();
				}
				
				attValue = attValue / this.records.size();
				
				this.centers.add(i, attValue);
			}
		}
	}
}
