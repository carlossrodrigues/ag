package res.dh;

import res.dia.Dia;
import res.horario.Horario;

public class DH {
	private Dia dia;
	private Horario horario;
	public DH(Dia dia, Horario horario) {
		super();
		this.dia = dia;
		this.horario = horario;
	}
	public Dia getDia() {
		return dia;
	}
	public Horario getHorario() {
		return horario;
	}
}