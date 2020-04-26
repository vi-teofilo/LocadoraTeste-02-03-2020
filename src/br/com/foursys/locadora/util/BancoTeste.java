package br.com.foursys.locadora.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class BancoTeste {// INICIO DA CLASSE

	public static void main(String[] args) {// INICIO DO MAIN

		String local = "jdbc:mysql://localhost/locadora"; // FAZ A CONEXÃO COM BANCO DE DADOS MYSQL NO LOCALHOST NA DATABASE
														// TURMAS
		String login = "root";
		String senha = "root";

		Connection bd = null;// VARIÁVEL DE CONEXÃO
		try {
			Class.forName("com.mysql.jdbc.Driver");// CARREGA O DRIVER QUE INTERMEDIA A CONEXÃO COM O BANCO DE DADOS
			System.out.println("Driver carregado com sucesso!");
			bd = (Connection) DriverManager.getConnection(local, login, senha);// ESTABELECE A CONEXÃO
			System.out.println("Conexão estabelecida com sucesso!");
			bd.close();// FECHA A CONEXÃO
			System.out.println("Conexão encerrada com sucesso!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Falha ao carregar o driver.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao estabelecer conexão.");
		}

	}// FIM DO MAIN

}// FIM DA CLASSE
