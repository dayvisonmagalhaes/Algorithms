package br.com.id3.record;

import java.util.LinkedList;

public class Record {
	private LinkedList<Attribute> attributes;

	public LinkedList<Attribute> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(LinkedList<Attribute> attributes) {
		this.attributes = attributes;
	}
}
