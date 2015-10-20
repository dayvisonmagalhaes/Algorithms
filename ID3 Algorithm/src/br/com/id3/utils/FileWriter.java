package br.com.id3.utils;

import java.io.PrintWriter;

import br.com.id3.tree.Node;

public class FileWriter {
	/**
	 * Função recursiva para impressão da árvore resultante dos algoritmos de
	 * árvore de decisão.
	 * 
	 * @param root		- Nó que será impresso
	 * @param writer	- Arquivo onde será impresso
	 * @param treeLevel	- Nível em que a árvore se encontra
	 */
	public static void writeTree(Node root, PrintWriter writer, int treeLevel) {
		String line = "";
		
		//Verifica se existe apenas o resultado ou se existe um outro campo a ser avaliado
		if(root.getTestAttribute().getName().isEmpty()) {
			line = root.getTestAttribute().getValue() + "    ";
		} else {
			line = root.getValue() + " -> " + root.getTestAttribute().getName() + "    ";
		}
		
		//Imprime o nível do nó
		for(int i = 0; i < treeLevel * 2; i++){
			writer.print("\t");
		}
		
		//Aumenta em 1 o nível da árvore
		treeLevel++;
		
		writer.print(line + "\n");
		
		//Imprime de forma recursiva as folhas desse nó
		if(root.getChildren() != null) {
			for(Node child : root.getChildren()) {
				writeTree(child, writer, treeLevel);
			}
		}
		
		return;
	}
}
