package br.com.kmeans.record;

import java.util.LinkedList;

public class Record {
	private LinkedList<Attribute> attributes;

	/**
	 * Obtem a lista de atributos do registro
	 * 
	 * @return
	 */
	public LinkedList<Attribute> getAttributes() {
		return attributes;
	}
	
	/**
	 * Adiciona uma lista de atributos ao registro
	 * 
	 * @param attributes
	 */
	public void setAttributes(LinkedList<Attribute> attributes) {
		this.attributes = attributes;
	}
}
