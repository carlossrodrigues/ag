package res.professor;

public class Professor {
	private int id;
	private String nome;
	public Professor(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
}
