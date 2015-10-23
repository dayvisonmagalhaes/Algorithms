package br.com.id3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import br.com.id3.core.ID3;
import br.com.id3.dataset.ListDiscreteAttributes;
import br.com.id3.record.Record;
import br.com.id3.tree.Node;
import br.com.id3.utils.FileReader;
import br.com.id3.utils.FileWriter;

public class Start {

	/**
	 * Função main, ela que irá carregar os dados e iniciar o processamento da árvore.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Caminho para a pasta onde será lido o arquivo com a base de dados
		String path = "";
		
		//Carrega os atributos da base de dados
		ListDiscreteAttributes attributes = FileReader.readAttributes(path + "PlayGolf.txt");
		
		//Carrega os registros da base de dados
		List<Record> records = FileReader.readDataset(path + "PlayGolf.txt", attributes);
		
		//Instância o primeiro ramo da nossa árvore
		Node root = new Node();
		root.setData(records);
		
		//Inicia o processamento da árvore
		ID3 id3 = new ID3();
		id3.generateTree(records, root, attributes);
		
		//Imprime a arvore resultante no arquivo Result.txt
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(path + "Result.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		FileWriter.writeTree(root, writer, 0);
		
		//Fecha o arquivo
		writer.close();
	}

}
