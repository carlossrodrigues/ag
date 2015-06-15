package res.dia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import res.conexao.ConnectionFactory;

public class DiaDAO {
	private ArrayList<Dia> dias;

	public void load() {
		Connection conexao = ConnectionFactory.get();

		try {
			PreparedStatement ps = conexao.prepareStatement("SELECT * FROM dias");

			ResultSet rs = ps.executeQuery();

			dias = new ArrayList<Dia>();

			while (rs.next()) {
				int id = rs.getInt("codigo");
				String desc = rs.getString("dia");

				dias.add(new Dia(id, desc));
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Dia> list(){
		return new ArrayList<Dia>(dias);
	}

	public Dia get(int id) {
		for(Dia d : dias){
			if(d.getId() == id){
				return d;
			}
		}
		
		return null;
	}
}
