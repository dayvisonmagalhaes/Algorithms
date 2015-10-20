package br.com.id3.dataset;

import java.util.LinkedList;

public class ListDiscreteAttributes {
	LinkedList<AttributeInfo> listAttributes;

	public ListDiscreteAttributes() {
		this.listAttributes = new LinkedList<AttributeInfo>();
	}
	
	public void setAttribute(String key) {
		for(AttributeInfo attribute : this.listAttributes) {
			if(attribute.getName().equals(key)) {
				return;
			}
		}
		
		this.listAttributes.add(new AttributeInfo(key));
	}
	
	public void setAttribute(String key, int position) {
		for(int i = 0; i < this.listAttributes.size(); i++) {
			if(this.listAttributes.get(i).getName().equals(key)) {
				AttributeInfo temp = this.listAttributes.get(i);
				
				this.listAttributes.remove(i);
				this.listAttributes.add(i, temp);
			}
		}
	
		this.listAttributes.add(position, new AttributeInfo(key));
	}
	
	public DiscreteAttributeValues getAttributeValues(String key) {
		for(AttributeInfo attribute : this.listAttributes) {
			if(attribute.getName().equals(key)) {
				return attribute.getListAttributes();
			}
		}
		
		return null;
	}
	
	public int getAttributePosition(String key) {
		for(int i = 0; i < this.listAttributes.size(); i++) {
			if(this.listAttributes.get(i).getName().equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	public String getAttribute(int position) {
		return this.listAttributes.get(position).getName();
	}
	
	public AttributeInfo getAttributeInfo (int position) {
		return this.listAttributes.get(position);
	}
	
	public int getAttributeQuantity () {
		return this.listAttributes.size();
	}
	
	public void removeAttribute (int position) {
		this.listAttributes.remove(position);
	}
	
	public ListDiscreteAttributes clone() {
		LinkedList<AttributeInfo> attributes = new LinkedList<AttributeInfo>();
		
		attributes.addAll(this.listAttributes);
		
		return new ListDiscreteAttributes(attributes);
	}

	public ListDiscreteAttributes(LinkedList<AttributeInfo> listAttributes) {
		super();
		this.listAttributes = listAttributes;
	}
}
