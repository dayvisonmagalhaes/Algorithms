package br.com.id3.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.id3.dataset.AttributeInfo;
import br.com.id3.dataset.DiscreteAttributeValues;
import br.com.id3.record.Record;
import br.com.id3.tree.Node;

public class Utils {
	/**
	 * Gera um subset dado um no da arvore
	 * 
	 * @param root		- No da arvore
	 * @param attr		- Atributo pelo qual a base deve ser dividade
	 * @param value		- Valor do atributo
	 * @return
	 */
	public static ArrayList<Record> subset(Node root, int attr, int value) {
		ArrayList<Record> subset = new ArrayList<Record>();
		
		for(Record record : root.getData()) {
			if(record.getAttributes().get(attr).getValue() == value) {
				subset.add(record);
			}
		}
		
		return subset;
	}
	
	/**
	 * Gera um subset dado uma lista de registros
	 * 
	 * @param data		- Lista com os registros
	 * @param attr		- Atributo pelo qual a base deve ser dividade
	 * @param value		- Valor do atributo
	 * @return
	 */
	public static ArrayList<Record> subset(List<Record> data, int attr, int value) {
		ArrayList<Record> subset = new ArrayList<Record>();
		
		for(Record record : data) {
			if(record.getAttributes().get(attr).getValue() == value) {
				subset.add(record);
			}
		}
		
		return subset;
	}

	/**
	 * Verifica qual classe compoe a maioria na lista de registros dada a posicao do atributo
	 * 
	 * @param data						- Lista de registros
	 * @param discreteAttributeValues	- Valores possiveis do atributo
	 * @param position					- Posicao do atributo
	 * @return
	 */
	public static int getMajority(List<Record> data, DiscreteAttributeValues discreteAttributeValues, int position) {
		int length = 0;
		int positionResult = -1;
		
		for(int j = 0; j < discreteAttributeValues.getQuantity(); j++) {
			int subsetLength = Utils.subset(data, position, j).size();
			
			if(subsetLength > length) {
				length = subsetLength;
				positionResult = j;
			}
		}
		
		return positionResult;
	}

	/**
	 * Obtem a posicao do atributo nos registros
	 * 
	 * @param chosen	- Atributo a ser verifica a posicao
	 * @param record	- Exemplo de registro
	 * @return
	 */
	public static int getAttributePositionOnRecords(AttributeInfo chosen, Record record) {
		for(int i = 0; i < record.getAttributes().size(); i++) {
			if(record.getAttributes().get(i).getName().equals(chosen.getName())) {
				return i;
			}
		}
		
		return -1;
	}
}
