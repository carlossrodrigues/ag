package res.horario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;

public class HorarioDAO {
	private ArrayList<Horario> horarios;

	public void load() {
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM horarios");

			ResultSet rs = ps.executeQuery();

			horarios = new ArrayList<Horario>();

			while (rs.next()) {
				int id = rs.getInt("codigo");
				String desc = rs.getString("horario");
				
				horarios.add(new Horario(id, desc));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Horario> list(){
		return new ArrayList<Horario>(horarios);
	}

	public Horario get(int id) {
		for(Horario d : horarios){
			if(d.getId() == id){
				return d;
			}
		}
		
		return null;
	}
}
