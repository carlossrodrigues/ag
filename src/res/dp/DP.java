package res.dp;

import res.disciplinas.Disciplina;
import res.professor.Professor;

public class DP {
	private Disciplina disciplina;
	private Professor professor;
	public DP(Disciplina disciplina, Professor professor) {
		super();
		this.disciplina = disciplina;
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
}
