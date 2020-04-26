package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;

public class FilmeAlterarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			Filme filme = new Filme(1, "O Iluminado", "Terror", 5.99, true, false, 0);
			FilmeDAO dao = new FilmeDAO(bd);
			dao.alterar(filme);
			System.out.println("Filme alterado com sucesso!");
			bd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
