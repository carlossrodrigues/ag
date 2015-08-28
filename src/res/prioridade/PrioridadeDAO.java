package res.prioridade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;
import res.dia.Dia;
import res.dia.DiaDAO;
import res.horario.Horario;
import res.horario.HorarioDAO;
import res.professor.Professor;
import res.professor.ProfessorDAO;

public class PrioridadeDAO {
	private ProfessorDAO professorDAO;
	private DiaDAO diaDAO;
	private HorarioDAO horarioDAO;
	private ArrayList<Prioridade> prioridades;
	
	public PrioridadeDAO(ProfessorDAO professorDAO, DiaDAO diaDAO, HorarioDAO horarioDAO){
		this.professorDAO = professorDAO;
		this.diaDAO = diaDAO;
		this.horarioDAO = horarioDAO;
	}
	public void load() {
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM professores_dias");

			ResultSet rs = ps.executeQuery();

			prioridades = new ArrayList<Prioridade>();

			while (rs.next()) {
				int idProfessor = rs.getInt("codigo_professor");
				int idDia = rs.getInt("codigo_dia");
				int idHorario = rs.getInt("codigo_horario_prioritario");
				
				Professor professor = professorDAO.get(idProfessor);
				Dia dia = diaDAO.get(idDia);
				Horario horario = horarioDAO.get(idHorario);
				
				System.out.println("H: "+horario);
				
				int valor = rs.getInt("prioridade");
				
				Prioridade prioridade = new Prioridade(professor, dia, valor, horario);
				
				prioridades.add(prioridade);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Prioridade> list(){
		return new ArrayList<Prioridade>(prioridades);
	}
	
	public Prioridade get(Professor professor, Dia dia) {
		for(Prioridade d : prioridades){
			if(d.getProfessor() == professor && d.getDia()==dia){
				return d;
			}
		}
		return null;
	}
}
