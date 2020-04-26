package br.com.foursys.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Vendedor;

public class VendedorDAO {

	private Connection bd;

	public VendedorDAO(Connection bd) {
		this.bd = bd;
	}

	public void inserir(Vendedor vendedor) throws SQLException {
		String sql = "INSERT INTO vendedor (nome, area_venda, cidade, estado, sexo, idade, salario) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, vendedor.getNome());
		comando.setString(2, vendedor.getAreaVenda());
		comando.setString(3, vendedor.getCidade().getNome());
		comando.setString(4, vendedor.getEstado().getNome());
		comando.setString(5, String.valueOf(vendedor.getSexo()));
		comando.setInt(6, vendedor.getIdade());
		comando.setDouble(7, vendedor.getSalario());
		comando.execute();
	}

	public void alterar(Vendedor vendedor) throws SQLException {
		String sql = "UPDATE vendedor SET area_venda=?, cidade=?, estado=?, sexo=?, idade=?, salario=? WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, vendedor.getAreaVenda());
		comando.setString(2, vendedor.getCidade().getNome());
		comando.setString(3, vendedor.getEstado().getNome());
		comando.setString(4, String.valueOf(vendedor.getSexo()));
		comando.setInt(5, vendedor.getIdade());
		comando.setDouble(6, vendedor.getSalario());
		comando.setString(7, vendedor.getNome());
		comando.execute();
	}

	public List<Vendedor> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM vendedor ORDER BY nome";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery(sql);
		List<Vendedor> listaVendedores = new ArrayList<Vendedor>();
		while (cursor.next()) {
			Vendedor vendedor = new Vendedor();
			Cidade cidade = new Cidade();
			vendedor.setNome(cursor.getString("nome"));
			vendedor.setAreaVenda(cursor.getString("area_venda"));
			cidade.setNome(cursor.getString("cidade"));
			vendedor.setCidade(cidade);						
			EstadoDAO estadoDAO = new EstadoDAO(bd);
			vendedor.setEstado(estadoDAO.buscarPorNome(cursor.getString("estado")));
			vendedor.setSexo(cursor.getString("sexo").charAt(0));
			vendedor.setIdade(cursor.getInt("idade"));
			vendedor.setSalario(cursor.getDouble("salario"));
			listaVendedores.add(vendedor);
		}
		return listaVendedores;
	}

	public void excluir(Vendedor vendedor) throws SQLException {
		String sql = "DELETE FROM vendedor WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, vendedor.getNome());
		comando.execute();

	}
}
