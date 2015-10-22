package br.com.kmeans.record;

public class Attribute {
	private String name;
	private double value;
	private boolean isUnknown;
	
	public Attribute(String name, double value) {
		this.name = name;
		this.value = value;
		isUnknown = false;
	}
	
	/**
	 * Adiciona o nome do atributo
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Obtem o nome do atributo
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adiciona o valor do atributi
	 * 
	 * @param value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Obtem o valor do atributo
	 * 
	 * @return
	 */
	public double getValue() {
		return value;
	}
	
	/**
	 * Define se o atributo possui valor desconhecido
	 * 
	 * @param isUnknown
	 */
	public void setUnknown(boolean isUnknown) {
		this.isUnknown = isUnknown;
	}

	/**
	 * Verifica se o valor do atributo é conhecido
	 * 
	 * @return
	 */
	public boolean isUnknown() {
		return isUnknown;
	}
}
