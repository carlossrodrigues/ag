package res.professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;

public class ProfessorDAO {
	private ArrayList<Professor> professores;
	public void load() {
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM professores");

			ResultSet rs = ps.executeQuery();

			professores = new ArrayList<Professor>();

			while (rs.next()) {
				int id = rs.getInt("codigo");
				String nome = rs.getString("nome");

				professores.add(new Professor(id, nome));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Professor> list(){
		return new ArrayList<Professor>(professores);
	}
	
	public Professor get(int id) {
		for(Professor d : professores){
			if(d.getId() == id){
				return d;
			}
		}
		
		return null;
	}
}
