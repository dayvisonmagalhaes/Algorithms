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

	/**
	 * Adiciona o no pai
	 * 
	 * @param parent
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Obtem o no pai
	 * 
	 * @return
	 */
	public Node getParent() {
		return parent;
	}
	
	/**
	 * Adiciona o subconjunto de registros referentes a esse no
	 * 
	 * @param records
	 */
	public void setData(List<Record> records) {
		this.data = records;
	}

	/**
	 * Obtem o subconjunto de registros referentes a esse no
	 * 
	 * @return
	 */
	public List<Record> getData() {
		return data;
	}

	/**
	 * Adiciona a entropia do subconjunto
	 * 
	 * @param entropy
	 */
	public void setEntropy(double entropy) {
		this.entropy = entropy;
	}

	/**
	 * Obtem a entropia do subconjunto
	 * 
	 * @return
	 */
	public double getEntropy() {
		return entropy;
	}

	/**
	 * Adiciona os nos filhos
	 * 
	 * @param children
	 */
	public void setChildren(Node[] children) {
		this.children = children;
	}

	/**
	 * Obtem os nos filhos
	 * 
	 * @return
	 */
	public Node[] getChildren() {
		return children;
	}

	/**
	 * Marca o no como ja usado
	 * 
	 * @param isUsed
	 */
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * Verifica se o no ja foi usado
	 * 
	 * @return
	 */
	public boolean isUsed() {
		return isUsed;
	}

	/**
	 * Adiciona o atributo usado para a divisao da base
	 * 
	 * @param testAttribute
	 */
	public void setTestAttribute(AttributeInfo testAttribute) {
		this.testAttribute = testAttribute;
	}

	/**
	 * Obtem o atributo usado para a divisao da base
	 * 
	 * @return
	 */
	public AttributeInfo getTestAttribute() {
		return testAttribute;
	}

	/**
	 * Obtem o valor que gerou o no
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Adiciona o valor que gerou o no
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
