package br.com.id3.evaluate;

import java.util.List;

import br.com.id3.dataset.ListDiscreteAttributes;
import br.com.id3.record.Record;

public class Entropy {
	public static double calculateEntropy(List<Record> data, ListDiscreteAttributes learningSet) {
		double entropy = 0;
		
		if(data.size() == 0) {
			return 0;
		}
		
		int positionClass = learningSet.getAttributeQuantity() - 1;
		int positionClassRecord = data.get(0).getAttributes().size() - 1;
		
		for(int i = 0; i < learningSet.getAttributeInfo(positionClass).getListAttributes().getQuantity(); i++) {
			int count = 0;
			for(int j = 0; j < data.size(); j++) {
				Record record = data.get(j);
				
				if(record.getAttributes().get(positionClassRecord).getValue() == i) {
					count++;
				}
			}
				
			double probability = count / (double)data.size();
			if(count > 0) {
				entropy += -probability * (Math.log(probability) / Math.log(2));
			}
		}
		
		return entropy;
	}
}
