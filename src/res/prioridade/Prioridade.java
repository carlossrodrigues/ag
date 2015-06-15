package res.prioridade;

import res.dia.Dia;
import res.professor.Professor;

public class Prioridade {
	private Professor professor;
	private Dia dia;
	private int valor;
	public Prioridade(Professor professor, Dia dia, int valor) {
		super();
		this.professor = professor;
		this.dia = dia;
		this.valor = valor;
	}
	public Professor getProfessor() {
		return professor;
	}
	public Dia getDia() {
		return dia;
	}
	public int getValor() {
		return valor;
	}
}
