package br.com.id3.tree;

import java.util.ArrayList;
import java.util.List;

import br.com.id3.dataset.AttributeInfo;
import br.com.id3.record.Record;

public class Node {
	public Node[] children;
	
	private Node parent;
	private List<Record> data;
	private double entropy;
	private String value;
	private boolean isUsed;
	
	private AttributeInfo testAttribute;

	public Node() {
		this.data = new ArrayList<Record>();
		
		this.entropy = 0.0;
		this.parent = null;
		this.children = null;
		this.isUsed = false;
		this.value = "";
		
		this.testAttribute = new AttributeInfo("");
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public Node getParent() {
		return parent;
	}

	public void setData(List<Record> records) {
		this.data = records;
	}

	public List<Record> getData() {
		return data;
	}

	public void setEntropy(double entropy) {
		this.entropy = entropy;
	}

	public double getEntropy() {
		return entropy;
	}

	public void setChildren(Node[] children) {
		this.children = children;
	}

	public Node[] getChildren() {
		return children;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setTestAttribute(AttributeInfo testAttribute) {
		this.testAttribute = testAttribute;
	}

	public AttributeInfo getTestAttribute() {
		return testAttribute;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
