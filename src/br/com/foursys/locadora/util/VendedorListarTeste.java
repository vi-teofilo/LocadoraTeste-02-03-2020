package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.VendedorDAO;
import br.com.foursys.locadora.model.Vendedor;

public class VendedorListarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			VendedorDAO dao = new VendedorDAO(bd);
			List<Vendedor> vendedores = dao.buscarTodos();
			for (Vendedor vendedor : vendedores) {
				System.out.println("Nome: " + vendedor.getNome());
				System.out.println("�rea de venda: " + vendedor.getAreaVenda());
				System.out.println("Cidade: " + vendedor.getCidade().getNome());
				System.out.println("Estado: " + vendedor.getEstado().getNome() + "-" + vendedor.getEstado().getUf());
				System.out.println("Sexo: " + vendedor.getSexo());
				System.out.println("Idade: " + vendedor.getIdade());
				System.out.println("Sal�rio: " + vendedor.getSalario() + "\n");
			}
			bd.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar vendedor.");
			e.printStackTrace();
		}
	}

}
