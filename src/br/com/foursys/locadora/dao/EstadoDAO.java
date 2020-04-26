package br.com.foursys.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.model.Estado;

public class EstadoDAO {

	private Connection bd;

	public EstadoDAO(Connection bd) {
		this.bd = bd;
	}

	public List<Estado> buscarTodos() throws SQLException {
		String sql = "SELECT * FROM estado ORDER BY uf";
		PreparedStatement comando = bd.prepareStatement(sql);
		ResultSet cursor = comando.executeQuery(sql);
		List<Estado> listaEstados = new ArrayList<Estado>();
		while (cursor.next()) {
			Estado estado = new Estado();
			estado.setNome(cursor.getString("nome"));
			estado.setUf(cursor.getString("uf"));
			listaEstados.add(estado);
		}
		return listaEstados;
	}

	public Estado buscarPorNome(String estado) throws SQLException {
		String sql = "SELECT * FROM estado WHERE nome=?";
		PreparedStatement comando = bd.prepareStatement(sql);
		comando.setString(1, estado);
		ResultSet cursor = comando.executeQuery();
		Estado estadoRetorno = new Estado();
		while (cursor.next()) {
			estadoRetorno.setNome(cursor.getString("nome"));
			estadoRetorno.setUf(cursor.getString("uf"));
		}
		return estadoRetorno;
	}

}