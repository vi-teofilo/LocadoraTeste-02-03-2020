package br.com.foursys.locadora.util;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Estado;
import br.com.foursys.locadora.model.Vendedor;

public class VendedorAlterarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			Estado estado = new Estado("Rio de Janeiro", "RJ");
			Cidade cidade = new Cidade("Niterói");
			Vendedor vendedor = new Vendedor("Pedro", "Estoque", cidade, estado, 'M', 19, 2700.00);
			VendedorDAO dao = new VendedorDAO(bd);
			dao.alterar(vendedor);
			System.out.println("Vendedor alterado com sucesso!");
			bd.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
