package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Cliente;
import br.com.foursys.locadora.model.Estado;

public class ClienteInserirTeste {

	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		Estado estado = new Estado("São Paulo", "SP");
		Cidade cidade = new Cidade("Osasco");
		Cliente cliente = new Cliente("Pedro", "Avenida Jãozinho", 477, "Jd. das Flores", cidade, estado,
				"(11)99712-6322", "457.888.888-57", "37.124.555-5", 'M', "04/06/200", 19);
		ClienteDAO dao = new ClienteDAO(bd);
		try {
			dao.inserir(cliente);
			System.out.println("Cliente inserido com sucesso!");
			bd.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir cliente.");
		}
	}

}
