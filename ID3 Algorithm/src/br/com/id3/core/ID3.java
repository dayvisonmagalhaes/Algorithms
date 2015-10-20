package br.com.id3.core;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.id3.dataset.AttributeInfo;
import br.com.id3.dataset.ListDiscreteAttributes;
import br.com.id3.evaluate.Entropy;
import br.com.id3.evaluate.InformationGain;
import br.com.id3.record.Record;
import br.com.id3.tree.Node;
import br.com.id3.utils.Utils;

public class ID3 {

	public Node generateTree(List<Record> records, Node root, ListDiscreteAttributes learningSet) {
		
		int bestAttribute = -1;
		double bestGain = 0.0;
		
		root.setEntropy(Entropy.calculateEntropy(root.getData(), learningSet));
		
		if(root.getEntropy() == 0) {
			return populateResult(root.getData(), root, learningSet);
		}
		
		for(int i = 0; i < learningSet.getAttributeQuantity() - 1; i++) {
			double entropy = 0;
			
			LinkedList<Double> entropies = new LinkedList<Double>();
			LinkedList<Integer> setSizes = new LinkedList<Integer>();

			int attributePositionRecord = Utils.getAttributePositionOnRecords(learningSet.getAttributeInfo(i), root.getData().get(0));
			
			for(int j = 0; j < learningSet.getAttributeInfo(i).getListAttributes().getQuantity(); j++) {
				ArrayList<Record> subset = Utils.subset(root, attributePositionRecord, j);
				setSizes.add(subset.size());
				
				if(subset.size() != 0) {
					entropy = Entropy.calculateEntropy(subset, learningSet);
					entropies.add(entropy);
				} else {
					entropies.add(0.0);
				}
			}
			
			double gain = InformationGain.calculateGain(root.getEntropy(), entropies, setSizes, root.getData().size());
			
			if(gain > bestGain) {
				bestAttribute = i;
				bestGain = gain;
			}
		}
		
		if(bestAttribute != -1) {
			AttributeInfo chosen = learningSet.getAttributeInfo(bestAttribute); 
			String testedAttributeName = root.getTestAttribute().getValue();
			
			root.setTestAttribute(chosen);
			root.setValue(testedAttributeName);
			root.children = new Node[chosen.getListAttributes().getQuantity()];
			root.setUsed(true);
			
			learningSet.removeAttribute(bestAttribute);
			
			int bestAttributePositionRecord = Utils.getAttributePositionOnRecords(chosen, records.get(0));
			
			for (int j = 0; j < chosen.getListAttributes().getQuantity(); j++) {
				root.children[j] = new Node();
				root.children[j].setParent(root);
				root.children[j].setData(Utils.subset(root, bestAttributePositionRecord, j));
				root.children[j].getTestAttribute().setValue(chosen.getListAttributes().getValue(j));
			}

			for (int j = 0; j < chosen.getListAttributes().getQuantity(); j++) {
				generateTree(records, root.children[j], learningSet.clone());
			}
		}
		else {
			return populateResult(root.getData(), root, learningSet);
		}
		
		return root;
	}

	private Node populateResult(List<Record> records, Node root, ListDiscreteAttributes learningSet) {
		AttributeInfo chosen = learningSet.getAttributeInfo(learningSet.getAttributeQuantity() - 1);
		
		root.children = new Node[1];
		
		root.children[0] = new Node();
		root.children[0].setParent(root);
		
		int classAttributePositionRecord = Utils.getAttributePositionOnRecords(chosen, records.get(0));
		int resultPosition = Utils.getMajority(root.getData(), learningSet.getAttributeInfo(learningSet.getAttributeQuantity() - 1).getListAttributes(), classAttributePositionRecord);
		
		root.children[0].getTestAttribute().setValue(chosen.getListAttributes().getValue(resultPosition));			
		
		return root;
	}
}
