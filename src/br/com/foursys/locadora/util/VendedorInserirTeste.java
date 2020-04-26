package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Estado;
import br.com.foursys.locadora.model.Vendedor;

public class VendedorInserirTeste {

	public static void main(String[] args) {
		Connection bd = ConnectionFactory.getConnection();
		Estado estado = new Estado("São Paulo", "SP");
		Cidade cidade = new Cidade("Osasco");
		Vendedor vendedor = new Vendedor("Pedro", "Caixa", cidade, estado, 'M', 19, 1700.00);
		VendedorDAO dao = new VendedorDAO(bd);
		try {
			dao.inserir(vendedor);
			System.out.println("Vendedor inserido com sucesso!");
			bd.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Falha ao inserir Vendedor.");
		}
	}

}
