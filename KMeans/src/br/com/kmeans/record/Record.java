package br.com.kmeans.record;

import java.util.LinkedList;

public class Record {
	private LinkedList<Attribute> attributes;
	private int group;

	public Record () {
		this.attributes = new LinkedList<Attribute>();
		this.group = -1;
	}
	
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

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
}
