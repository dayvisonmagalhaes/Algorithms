package br.com.id3.utils;

import java.io.PrintWriter;

import br.com.id3.tree.Node;

public class FileWriter {
	/**
	 * Fun��o recursiva para impress�o da �rvore resultante dos algoritmos de
	 * �rvore de decis�o.
	 * 
	 * @param root		- N� que ser� impresso
	 * @param writer	- Arquivo onde ser� impresso
	 * @param treeLevel	- N�vel em que a �rvore se encontra
	 */
	public static void writeTree(Node root, PrintWriter writer, int treeLevel) {
		String line = "";
		
		//Verifica se existe apenas o resultado ou se existe um outro campo a ser avaliado
		if(root.getTestAttribute().getName().isEmpty()) {
			line = root.getTestAttribute().getValue() + "    ";
		} else {
			line = root.getValue() + " -> " + root.getTestAttribute().getName() + "    ";
		}
		
		//Imprime o n�vel do n�
		for(int i = 0; i < treeLevel * 2; i++){
			writer.print("\t");
		}
		
		//Aumenta em 1 o n�vel da �rvore
		treeLevel++;
		
		writer.print(line + "\n");
		
		//Imprime de forma recursiva as folhas desse n�
		if(root.getChildren() != null) {
			for(Node child : root.getChildren()) {
				writeTree(child, writer, treeLevel);
			}
		}
		
		return;
	}
}
