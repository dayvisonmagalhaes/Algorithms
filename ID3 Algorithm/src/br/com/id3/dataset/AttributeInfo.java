package br.com.id3.dataset;


public class AttributeInfo {
	DiscreteAttributeValues listAttributes;
	private String name;
	private String value;
	private boolean isUsed;
	
	public AttributeInfo(String name) {
		this.name = name;
		this.value = "";
		this.isUsed = false;
		this.listAttributes = new DiscreteAttributeValues();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String string) {
		this.value = string;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public DiscreteAttributeValues getListAttributes() {
		return listAttributes;
	}

	public void setListAttributes(DiscreteAttributeValues listAttributes) {
		this.listAttributes = listAttributes;
	}
}

