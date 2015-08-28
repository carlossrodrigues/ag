package res.prioridade;

import res.dia.Dia;
import res.horario.Horario;
import res.professor.Professor;

public class Prioridade {
	private Professor professor;
	private Dia dia;
	private int valor;
	private Horario horario;
	public Prioridade(Professor professor, Dia dia, int valor, Horario horario) {
		super();
		this.professor = professor;
		this.dia = dia;
		this.valor = valor;
		this.horario = horario;
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
	public Horario getHorario() {
		return horario;
	}
}