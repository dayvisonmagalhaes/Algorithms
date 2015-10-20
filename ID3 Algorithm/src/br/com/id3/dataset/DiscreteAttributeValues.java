package br.com.id3.dataset;

import java.util.LinkedList;

public class DiscreteAttributeValues {
	private LinkedList<String> values;

	public DiscreteAttributeValues() {
		this.values = new LinkedList<String>();
	}
	
	/**
	 * Adiciona valor a lista de possíveis valores
	 * 
	 * @param key
	 */
	public void setValue(String key) {
		for(String value : this.values) {
			if(value.equals(key)) {
				return;
			}
		}
		
		this.values.add(this.values.size(), key);
	}
	
	/**
	 * Obtem a String que representa o valor a partir do valor numerico do mesmo
	 * 
	 * @param numericValue
	 * @return
	 */
	public String getValue(int numericValue) {
		return this.values.get(numericValue);
	}
	
	/**
	 * Obtem o valor numero a partir da String que representa o atributo
	 * 
	 * @param key
	 * @return
	 */
	public int getNumericValue(String key) {
		for(int i = 0; i < this.values.size(); i++) {
			if(this.values.get(i).equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Obtem a quantidade de valores do atributo
	 * 
	 * @return
	 */
	public int getQuantity() {
		return this.values.size();
	}
}
