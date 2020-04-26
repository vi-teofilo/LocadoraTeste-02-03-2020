package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.FilmeDAO;
import br.com.foursys.locadora.model.Filme;

public class FilmeListarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			FilmeDAO dao = new FilmeDAO(bd);
			List<Filme> filmes = dao.buscarTodos();
			for (Filme filme : filmes) {
				System.out.println("Codigo: " + filme.getCodigo());
				System.out.println("Nome: " + filme.getNome());
				System.out.println("Genero: " + filme.getGenero());
				System.out.println("Valor: " + filme.getValor());
				System.out.println("Disponivel: " + filme.isDisponivel());
				System.out.println("Promocao: " + filme.isPromocao());
				System.out.println("Valor da Promocao: " + filme.getValorPromocao() + "\n");
			}
			bd.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar filme.");
			e.printStackTrace();
		}
	}

}
