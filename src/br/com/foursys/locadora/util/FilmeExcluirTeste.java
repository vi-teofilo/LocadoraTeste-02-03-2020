package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;


public class FilmeExcluirTeste {
public static void main(String[] args) {
	try {
		Connection bd = ConnectionFactory.getConnection();
		Filme filme = new Filme(1, "O Iluminado", "Terror", 5.99, true, false, 0);
		FilmeDAO dao = new FilmeDAO(bd);
		dao.excluir(filme);
		bd.close();
		System.out.println("Filme excluido com sucesso!");
	} catch (SQLException e) {
		e.printStackTrace();
		System.out.println("Falha ao excluir filme.");
	}
}
}
