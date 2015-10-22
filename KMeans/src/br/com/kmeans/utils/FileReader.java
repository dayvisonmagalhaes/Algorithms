package br.com.kmeans.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import br.com.kmeans.dataset.ListAttributes;
import br.com.kmeans.record.Attribute;
import br.com.kmeans.record.Record;

public class FileReader {
	/**
	 * Abre o arquivo e le todos os registros e seus atributos. Ignorando a primeira linha
	 * pois a mesma deve conter o cabe�alho da base de dados.
	 * 
	 * @param path
	 * @param attributes
	 * @return
	 */
	public static List<Record> readDataset(String path, ListAttributes attributes) {
		ArrayList<Record> records = new ArrayList<Record>();
		
		BufferedReader reader = readFile(path);

		String line;
		Record record = null;

		LinkedList<Attribute> recordAttributes;
		
		try {
			//remove the attributes names
			reader.readLine();
			
			//Faz a leitura de cada objeto (linha)
			while((line = reader.readLine()) != null) {
				
				//Posicao do atributo no arquivo
				int position = 0;
				recordAttributes = new LinkedList<Attribute>();
				
				//Faz a quebra de linha por ;
				StringTokenizer st = new StringTokenizer(line, ";");
				record = new Record();
				
				//Faz a leitura de cada atributo
				while (st.hasMoreTokens()) {
					//Obtem o nome do atributo
					String attributeName = attributes.getAttribute(position);
					//Pega o valor do arquivo
					String attributeValue = st.nextToken();
					
					recordAttributes.add(new Attribute(attributeName, Double.valueOf(attributeValue)));
					
					position++;
				}

				//Adiciona o atributo ao objeto
				record.setAttributes(recordAttributes);
				records.add(record);
			}
		} catch (IOException e) {
			System.out.println("Error reading file " + path);
			e.printStackTrace();
		}
		
		return records;
	}

	/**
	 * Abre um arquivo para leitura a partir de um caminho especificado
	 * 
	 * @param path		- Caminho para o arquivo
	 * @return			- Buffer para a leitura
	 */
	private static BufferedReader readFile(String path) {
		//Instancia no arquivo
		File f = new File(path);
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(f);
		} catch (FileNotFoundException e1) {
			System.out.println("Error reading file " + path);
			e1.printStackTrace();
		}

		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		return reader;
	}

	/**
	 * Faz uma leitura dos nomes dos atributos presentes na base de dados
	 * 
	 * @param path		- Caminho para o arquivo com a base de dados
	 * @return			- Lista dos atributos
	 */
	public static ListAttributes readAttributes(String path) {
		ListAttributes attributes = new ListAttributes();
		
		//Leitura do arquivo
		BufferedReader reader = readFile(path);

		String line;
		
		try {
			//Apenas a primeira linha (cabe�alho) � lida
			if ((line = reader.readLine()) != null) {
				int position = 0;
				
				StringTokenizer st = new StringTokenizer(line, ";");
	
				//Adiciona os nomes dos atributos a lista
				while (st.hasMoreTokens()) {
					attributes.setAttribute(st.nextToken(), position);
					position++;
				}
			}
		} catch (IOException e) {
			System.out.println("Error reading file " + path);
			e.printStackTrace();
		}
	
		return attributes;
	}
	
	
}
