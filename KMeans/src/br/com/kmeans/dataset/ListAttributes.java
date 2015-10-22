package br.com.kmeans.dataset;

import java.util.LinkedList;

public class ListAttributes {
	LinkedList<AttributeInfo> listAttributes;

	public ListAttributes() {
		this.listAttributes = new LinkedList<AttributeInfo>();
	}
	
	/**
	 * Adiciona um novo atributo a lista
	 * 
	 * @param key
	 */
	public void setAttribute(String key) {
		for(AttributeInfo attribute : this.listAttributes) {
			if(attribute.getName().equals(key)) {
				return;
			}
		}
		
		this.listAttributes.add(new AttributeInfo(key));
	}
	
	/**
	 * Adiciona um atributo a determinada posicao da lista
	 * 
	 * @param key
	 * @param position
	 */
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
	
	/**
	 * Obtem a posicao do atributo na base de dados
	 * 
	 * @param key
	 * @return
	 */
	public int getAttributePosition(String key) {
		for(int i = 0; i < this.listAttributes.size(); i++) {
			if(this.listAttributes.get(i).getName().equals(key)) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Obtem o atributo a partir da posicao do mesmo
	 * 
	 * @param position
	 * @return
	 */
	public String getAttribute(int position) {
		return this.listAttributes.get(position).getName();
	}
	
	/**
	 * Obtem as informacoes referentes ao atributo
	 * 
	 * @param position
	 * @return
	 */
	public AttributeInfo getAttributeInfo (int position) {
		return this.listAttributes.get(position);
	}
	
	/**
	 * Obtem a quantidade de atributos
	 * 
	 * @return
	 */
	public int getAttributeQuantity () {
		return this.listAttributes.size();
	}
	
	/**
	 * Remove um atributo
	 * 
	 * @param position
	 */
	public void removeAttribute (int position) {
		this.listAttributes.remove(position);
	}
	
	/**
	 * Copia os valores do objeto para um novo objeto
	 * 
	 */
	public ListAttributes clone() {
		LinkedList<AttributeInfo> attributes = new LinkedList<AttributeInfo>();
		
		attributes.addAll(this.listAttributes);
		
		return new ListAttributes(attributes);
	}

	public ListAttributes(LinkedList<AttributeInfo> listAttributes) {
		super();
		this.listAttributes = listAttributes;
	}
}
