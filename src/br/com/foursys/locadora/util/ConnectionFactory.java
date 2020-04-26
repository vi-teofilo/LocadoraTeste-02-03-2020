package br.com.foursys.locadora.util;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {

		String local = "jdbc:mysql://localhost/locadora";
		String login = "root";
		String senha = "root";

		Connection conexao = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = (Connection) DriverManager.getConnection(local, login, senha);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Falha ao carregar o driver.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao estabelecer conexão.");
		}
		return conexao;
	}

}
