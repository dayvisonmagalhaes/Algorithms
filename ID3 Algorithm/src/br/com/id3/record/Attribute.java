package br.com.id3.record;

public class Attribute {
	private String name;
	private double value;
	private boolean isUnknown;
	
	public Attribute(String name, double value) {
		this.name = name;
		this.value = value;
		isUnknown = false;
	}
	
	public Attribute(String name, String value) {
		this.name = name;
		try {
			this.value = Double.valueOf(value);
			this.isUnknown = false;

		}
		catch(NumberFormatException nfe) {
			this.value = -1;
			this.isUnknown = true;
		}
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
