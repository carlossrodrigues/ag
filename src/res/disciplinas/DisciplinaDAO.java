package res.disciplinas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;

public class DisciplinaDAO {
	private ArrayList<Disciplina> disciplinas;

	public void load() {
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM disciplinas");

			ResultSet rs = ps.executeQuery();

			disciplinas = new ArrayList<Disciplina>();

			while (rs.next()) {
				int id = rs.getInt("codigo");
				String nome = rs.getString("nome");
				double cargaHoraria = rs.getDouble("carga_horaria");
				
				disciplinas.add(new Disciplina(id, nome, cargaHoraria));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Disciplina> list(){
		return new ArrayList<Disciplina>(disciplinas);
	}

	public Disciplina get(int id) {
		for(Disciplina d : disciplinas){
			if(d.getId() == id){
				return d;
			}
		}
		
		return null;
	}
}
