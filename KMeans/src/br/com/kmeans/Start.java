package br.com.kmeans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.kmeans.centers.Centroide;
import br.com.kmeans.dataset.ListAttributes;
import br.com.kmeans.evaluate.EuclidianDistance;
import br.com.kmeans.record.Record;
import br.com.kmeans.utils.FileReader;
import br.com.kmeans.utils.Utils;

public class Start {

	public static void main(String[] args) {
		// Caminho para a pasta onde será lido o arquivo com a base de dados
		String path = "C:\\Users\\davidson.sestaro\\Dropbox\\IA\\";

		// Quantidade de grupos
		int k = 3;
		
		// Quantidade Maxima de iteracoes
		int maxIterations = 1000;
		int iterations = 0;
		
		// Verifica se houve alteração
		boolean changed = true;
				
		// Carrega os atributos da base de dados
		ListAttributes attributes = FileReader.readAttributes(path + "Iris.txt");

		// Carrega os registros da base de dados
		List<Record> records = FileReader.readDataset(path + "Iris.txt", attributes);
		
		// Inicia os centroides
		LinkedList<Centroide> centers = Utils.getInitalCenters(k, records);
		
		// Inicializa os centroides
		for(Centroide center : centers) {
			center.calculateCenter();
		}
		
		while(iterations < maxIterations && changed) {
			// Marca que nao houveram alteracoes
			changed = false;
			
			// Incrementa em um o numero de iteracoes
			iterations++;
			
			// Remove os registros dos centros
			for(int i = 0; i < centers.size(); i++) {
				centers.get(i).setRecords(new ArrayList<Record>());
			}
			
			// Calcula a distancia do registro para cada centro
			for(Record record : records) {
				double minDistance = Double.MAX_VALUE;
				int minCenter = -1;
				
				for(int i = 0; i < centers.size(); i++) {
					if(EuclidianDistance.calculaDistance(centers.get(i), record) < minDistance) {
						minDistance = EuclidianDistance.calculaDistance(centers.get(i), record);
						minCenter = i;
					}
				}
				
				centers.get(minCenter).addRecord(record);
				
				if(record.getGroup() != minCenter) {
					changed = true;
				} else {
					record.setGroup(minCenter);
				}
			}
			
			// Recalcula os centros de cada grupo
			for(int i = 0; i < centers.size(); i++) {
				centers.get(i).calculateCenter();
			}
		}
		
		for(int i = 0; i < centers.size(); i++) {
			System.out.println("Grupo " + i + " possui " + centers.get(i).getRecords().size() + " registros.");
		}
	}
}
