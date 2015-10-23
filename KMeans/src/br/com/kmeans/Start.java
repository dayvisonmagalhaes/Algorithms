package br.com.kmeans;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.kmeans.centroid.Centroid;
import br.com.kmeans.chart.PlotChart;
import br.com.kmeans.dataset.ListAttributes;
import br.com.kmeans.evaluate.EuclidianDistance;
import br.com.kmeans.record.Record;
import br.com.kmeans.utils.FileReader;
import br.com.kmeans.utils.Utils;


class Start {
	public static void main(String args[]) throws Exception {

		// Caminho para a pasta onde será lido o arquivo com a base de dados
		String path = "";

		// Carrega os atributos da base de dados
		ListAttributes attributes = FileReader.readAttributes(path + "Iris2D.txt");

		// Carrega os registros da base de dados
		List<Record> records = FileReader.readDataset(path + "Iris2D.txt", attributes);
		
		// Numero de grupos
		int k = 3;
		
		// Inicializa os k centroides com objetos aleatorios
		LinkedList<Centroid> centroids = Utils.getInitalCenters(k, records);
		
		// Inicializa os centros de massa
		for(Centroid centroid : centroids) {
			centroid.calculateCenter();
		}
		
		// Variaveis de controle
		int maxIterations = 1000;
		int iteration = 0;
		
		// Variavel para controle de mudancas
		boolean hasChanged = true;
		
		while (iteration < maxIterations && hasChanged) {
			iteration++;
			hasChanged = false;
			
			for(Centroid centroid : centroids) {
				// Remove os objetos de seus antigos grupos
				centroid.setRecords(new ArrayList<Record>());
			}
			
			for(Record record : records) {
				double distance = Double.MAX_VALUE;
				int closestGroup = -1;
				
				for(int i = 0; i < centroids.size(); i++) {
					// Verifica o grupo com a menor distancia para o registro
					if(EuclidianDistance.calculaDistance(centroids.get(i), record) < distance) {
						distance = EuclidianDistance.calculaDistance(centroids.get(i), record);
						closestGroup = i;
					}
				}
				
				if(closestGroup != record.getGroup()) {
					hasChanged = true;
				}
				
				record.setGroup(closestGroup);
				centroids.get(closestGroup).addRecord(record);
			}
			
			// Recalcula os centros de massa
			for(Centroid centroid : centroids) {
				centroid.calculateCenter();
			}
		}
		
		if(attributes.getAttributeQuantity() <= 3) {
			PlotChart demo = new PlotChart("K-Means", centroids);
	        demo.pack();
	        demo.setLocationRelativeTo(null);
	        demo.setVisible(true);
		}
	}
}
