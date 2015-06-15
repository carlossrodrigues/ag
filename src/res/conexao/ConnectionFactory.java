package res.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection conexao;
	public static Connection get(){
		return conexao;
	}
	public static void open(){
		try {
			Class.forName("com.mysql.jdbc.Driver");

			String server, database, user, pass;
			int port;

			server = "localhost";
			database = "AG";
			user = "root";
			pass = "";

			port = 3306;

			String url = "jdbc:mysql://#server:#port/#database";

			url = url.replaceAll("#server", server);
			url = url.replaceAll("#port", Integer.toString(port));
			url = url.replaceAll("#database", database);

			conexao = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(){
		try {
			conexao.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}