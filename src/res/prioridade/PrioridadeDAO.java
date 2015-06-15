package res.prioridade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;
import res.dia.Dia;
import res.dia.DiaDAO;
import res.professor.Professor;
import res.professor.ProfessorDAO;

public class PrioridadeDAO {
	private ProfessorDAO professorDAO;
	private DiaDAO diaDAO;
	private ArrayList<Prioridade> prioridades;
	
	public PrioridadeDAO(ProfessorDAO professorDAO, DiaDAO diaDAO){
		this.professorDAO = professorDAO;
		this.diaDAO = diaDAO;
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
				
				Professor professor = professorDAO.get(idProfessor);
				Dia dia = diaDAO.get(idDia);
				
				int valor = rs.getInt("prioridade");
				
				Prioridade prioridade = new Prioridade(professor, dia, valor);
				
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
