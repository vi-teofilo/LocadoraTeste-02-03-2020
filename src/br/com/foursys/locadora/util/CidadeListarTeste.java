package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.CidadeDAO;
import br.com.foursys.locadora.model.Cidade;

public class CidadeListarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			CidadeDAO dao = new CidadeDAO(bd);
			List<Cidade> cidades = dao.buscarTodos();
			for (Cidade cidade : cidades) {
				System.out.println("Cidade: " + cidade.getNome() + "\n");
			}
			bd.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar cidade.");
			e.printStackTrace();
		}
	}

}
