package res.disciplinas;

public class Disciplina {
	private int id;
	private String nome;
	private double cargaHoraria;
	public Disciplina(int id, String nome, double cargaHoraria) {
		super();
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public double getCargaHoraria() {
		return cargaHoraria;
	}
}
