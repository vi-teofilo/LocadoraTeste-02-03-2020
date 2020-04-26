package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.EstadoDAO;
import br.com.foursys.locadora.model.Estado;

public class EstadoListarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			EstadoDAO dao = new EstadoDAO(bd);
			List<Estado> estados = dao.buscarTodos();
			for (Estado estado : estados) {
				System.out.println("Estado: " + estado.getNome() + "-" + estado.getUf());
			}
			bd.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar cidade.");
			e.printStackTrace();
		}
	}

}
