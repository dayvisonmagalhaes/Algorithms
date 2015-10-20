package br.com.id3.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.id3.dataset.AttributeInfo;
import br.com.id3.dataset.DiscreteAttributeValues;
import br.com.id3.record.Record;
import br.com.id3.tree.Node;

public class Utils {
	public static ArrayList<Record> subset(Node root, int attr, int value) {
		ArrayList<Record> subset = new ArrayList<Record>();
		
		for(Record record : root.getData()) {
			if(record.getAttributes().get(attr).getValue() == value) {
				subset.add(record);
			}
		}
		
		return subset;
	}
	
	public static ArrayList<Record> subset(List<Record> data, int attr, int value) {
		ArrayList<Record> subset = new ArrayList<Record>();
		
		for(Record record : data) {
			if(record.getAttributes().get(attr).getValue() == value) {
				subset.add(record);
			}
		}
		
		return subset;
	}

	public static int getMajority(List<Record> data, DiscreteAttributeValues discreteAttributeValues, int position) {
		int length = 0;
		int positionResult = -1;
		
		for(int j = 0; j < discreteAttributeValues.getQuantity(); j++) {
			int subsetLength = Utils.subset(data, position, j).size();
			
			if(subsetLength > length) {
				length = subsetLength;
				positionResult = j;
			}
		}
		
		return positionResult;
	}

	public static int getAttributePositionOnRecords(AttributeInfo chosen, Record record) {
		for(int i = 0; i < record.getAttributes().size(); i++) {
			if(record.getAttributes().get(i).getName().equals(chosen.getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
