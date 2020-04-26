package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Cliente;
import br.com.foursys.locadora.model.Estado;

public class ClienteExcluirTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			Estado estado = new Estado("São Paulo", "SP");
			Cidade cidade = new Cidade("Barueri");
			Cliente cliente = new Cliente("Pedro", "Avenida Mariazinha", 477, "Jd. das Flores", cidade, estado,
					"(11)99712-6322", "457.888.888-57", "37.124.555-5", 'M', "04/06/200", 19);
			ClienteDAO dao = new ClienteDAO(bd);
			dao.excluir(cliente);
			bd.close();
			System.out.println("Cliente excluido com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao excluir cliente.");
		}

	}

}
