package br.com.foursys.locadora.util;

import java.sql.SQLException;
import java.util.List;

import com.mysql.jdbc.Connection;

import br.com.foursys.locadora.dao.ClienteDAO;
import br.com.foursys.locadora.model.Cliente;

public class ClienteListarTeste {

	public static void main(String[] args) {
		try {
			Connection bd = ConnectionFactory.getConnection();
			ClienteDAO dao = new ClienteDAO(bd);
			List<Cliente> clientes = dao.buscarTodos();
			for (Cliente cliente : clientes) {
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("Logradouro: " + cliente.getLogradouro());
				System.out.println("Nº: " + cliente.getNumeroLogradouro());
				System.out.println("Bairro: " + cliente.getBairro());
				System.out.println("Cidade: " + cliente.getCidade().getNome());
				System.out.println("Estado:" + cliente.getEstado().getNome());
				System.out.println("Telefone:" + cliente.getTelefone());
				System.out.println("CPF:" + cliente.getCpf());
				System.out.println("RG:" + cliente.getRg());
				System.out.println("Sexo:" + cliente.getSexo());
				System.out.println("Data de Nascimento:" + cliente.getDataNascimento());
				System.out.println("Idade:" + cliente.getIdade() + "\n");
			}
			bd.close();
		} catch (SQLException e) {
			System.out.println("Erro ao buscar cliente.");
			e.printStackTrace();
		}

	}

}
