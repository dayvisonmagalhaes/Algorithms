package br.com.kmeans;

import java.util.List;

import br.com.kmeans.dataset.ListAttributes;
import br.com.kmeans.record.Record;
import br.com.kmeans.utils.FileReader;

public class Start {

	public static void main(String[] args) {
		// Caminho para a pasta onde será lido o arquivo com a base de dados
		String path = "C:\\Users\\davidson.sestaro\\Dropbox\\IA\\";

		// Carrega os atributos da base de dados
		ListAttributes attributes = FileReader.readAttributes(path + "PlayGolf.txt");

		// Carrega os registros da base de dados
		List<Record> records = FileReader.readDataset(path + "PlayGolf.txt", attributes);
		
		
	}
}
