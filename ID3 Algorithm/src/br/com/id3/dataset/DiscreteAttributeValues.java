package br.com.id3.dataset;

import java.util.LinkedList;

public class DiscreteAttributeValues {
	private LinkedList<String> values;

	public DiscreteAttributeValues() {
		this.values = new LinkedList<String>();
	}
	
	public void setValue(String key) {
		for(String value : this.values) {
			if(value.equals(key)) {
				return;
			}
		}
		
		this.values.add(this.values.size(), key);
	}
	
	public String getValue(int numericValue) {
		return this.values.get(numericValue);
	}
	
	public int getNumericValue(String key) {
		for(int i = 0; i < this.values.size(); i++) {
			if(this.values.get(i).equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public int getQuantity() {
		return this.values.size();
	}
}
