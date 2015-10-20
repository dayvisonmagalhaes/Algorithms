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

	/**
	 * Obtem o valor do atributo
	 * 
	 * @return
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Adiciona o valor do atributo
	 * 
	 * @param string
	 */
	public void setValue(String string) {
		this.value = string;
	}

	/**
	 * Marca o atributo como usado
	 * 
	 * @param isUsed
	 */
	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	/**
	 * Verifica se o atributo ja foi usado
	 * 
	 * @return
	 */
	public boolean isUsed() {
		return isUsed;
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
	 * Obtem a lista de valores possiveis para o atributo
	 * 
	 * @return
	 */
	public DiscreteAttributeValues getListAttributes() {
		return listAttributes;
	}

	/**
	 * Adiciona a lista de valores possível do atributo
	 * 
	 * @param listAttributes
	 */
	public void setListAttributes(DiscreteAttributeValues listAttributes) {
		this.listAttributes = listAttributes;
	}
}

