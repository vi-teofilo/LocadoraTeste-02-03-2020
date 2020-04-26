package br.com.foursys.locadora.util;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class BancoTeste {// INICIO DA CLASSE

	public static void main(String[] args) {// INICIO DO MAIN

		String local = "jdbc:mysql://localhost/locadora"; // FAZ A CONEX�O COM BANCO DE DADOS MYSQL NO LOCALHOST NA DATABASE
														// TURMAS
		String login = "root";
		String senha = "root";

		Connection bd = null;// VARI�VEL DE CONEX�O
		try {
			Class.forName("com.mysql.jdbc.Driver");// CARREGA O DRIVER QUE INTERMEDIA A CONEX�O COM O BANCO DE DADOS
			System.out.println("Driver carregado com sucesso!");
			bd = (Connection) DriverManager.getConnection(local, login, senha);// ESTABELECE A CONEX�O
			System.out.println("Conex�o estabelecida com sucesso!");
			bd.close();// FECHA A CONEX�O
			System.out.println("Conex�o encerrada com sucesso!");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Falha ao carregar o driver.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao estabelecer conex�o.");
		}

	}// FIM DO MAIN

}// FIM DA CLASSE
