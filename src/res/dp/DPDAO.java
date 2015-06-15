package res.dp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;
import res.disciplinas.Disciplina;
import res.disciplinas.DisciplinaDAO;
import res.professor.Professor;
import res.professor.ProfessorDAO;

public class DPDAO {
	private DisciplinaDAO disciplinaDAO;
	private ProfessorDAO professorDAO;

	private ArrayList<DP> dps;

	public DPDAO(DisciplinaDAO disciplinaDAO, ProfessorDAO professorDAO) {
		super();
		this.disciplinaDAO = disciplinaDAO;
		this.professorDAO = professorDAO;
	}

	public void load(){
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM professores_disciplinas");
			ResultSet rs = ps.executeQuery();

			dps = new ArrayList<DP>();

			while(rs.next()){
				int idDisciplina = rs.getInt("codigo_disciplina");
				int idProfessor = rs.getInt("codigo_professor");

				Disciplina disciplina = disciplinaDAO.get(idDisciplina);
				Professor professor = professorDAO.get(idProfessor);

				int nAulas = disciplina.getCargaHoraria() == 60 ? 4 : 2;

				for(int i=0; i<nAulas; i++){
					DP dp = new DP(disciplina, professor);

					dps.add(dp);
				}
			}

			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<DP> list(){
		return new ArrayList<DP>(dps);
	}
}
