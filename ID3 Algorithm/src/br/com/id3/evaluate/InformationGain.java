package br.com.id3.evaluate;

import java.util.LinkedList;

public class InformationGain {
	public static double calculateGain(double rootEntropy, LinkedList<Double> subEntropies, LinkedList<Integer> setSizes, int data) {
		double gain = rootEntropy; 
		
		for(int i = 0; i < subEntropies.size(); i++) {
			gain += -((setSizes.get(i) / (double)data) * subEntropies.get(i));
		}
		
		return gain;
	}
}
