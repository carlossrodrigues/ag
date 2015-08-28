package ag.entity;

import java.util.ArrayList;

public class Cromossomo {
	private ArrayList<Celula> gene;
	private double fitness;
	public Cromossomo(ArrayList<Celula> gene, double fitness) {
		super();
		this.gene = gene;
		this.fitness = fitness;
	}
	public ArrayList<Celula> getGene() {
		return gene;
	}
	public void setGene(ArrayList<Celula> gene) {
		this.gene = gene;
	}
	public double getFitness() {
		return fitness;
	}
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
}
