package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;

public class FilmeInserirTeste {

	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		Filme filme = new Filme(1, "Ela", "Drama", 5.99, true, false, 0);
		FilmeDAO dao = new FilmeDAO(bd);
		try {
			dao.inserir(filme);
			System.out.println("Filme inserido com sucesso!");
			bd.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir Filme.");
		}
	}

}
