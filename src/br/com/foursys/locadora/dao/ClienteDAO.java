package br.com.foursys.locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.foursys.locadora.model.Cidade;
import br.com.foursys.locadora.model.Cliente;

public class ClienteDAO {

    private Connection bd;

    public ClienteDAO(Connection bd) {
        this.bd = bd;
    }

    public void inserir(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, logradouro, numero_logradouro, bairro,"
                + " cidade, estado, telefone, cpf, rg, sexo, data_nascimento, idade) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement comando = bd.prepareStatement(sql);
        comando.setString(1, cliente.getNome());
        comando.setString(2, cliente.getLogradouro());
        comando.setInt(3, cliente.getNumeroLogradouro());
        comando.setString(4, cliente.getBairro());
        comando.setString(5, cliente.getCidade().getNome());
        comando.setString(6, cliente.getEstado().getNome());
        comando.setString(7, cliente.getTelefone());
        comando.setString(8, cliente.getCpf());
        comando.setString(9, cliente.getRg());
        comando.setString(10, String.valueOf(cliente.getSexo()));
        comando.setString(11, cliente.getDataNascimento());
        comando.setInt(12, cliente.getIdade());
        comando.execute();
    }

    public void alterar(Cliente cliente) throws SQLException {
        String sql = "UPDATE cliente SET logradouro=?, numero_logradouro=?, bairro=?, cidade=?, estado=?, telefone=?, cpf=?, rg=?, "
                + "sexo=?, data_nascimento=?, idade=? WHERE nome=?";
        PreparedStatement comando = bd.prepareStatement(sql);
        comando.setString(1, cliente.getLogradouro());
        comando.setInt(2, cliente.getNumeroLogradouro());
        comando.setString(3, cliente.getBairro());
        comando.setString(4, cliente.getCidade().getNome());
        comando.setString(5, cliente.getEstado().getNome());
        comando.setString(6, cliente.getTelefone());
        comando.setString(7, cliente.getCpf());
        comando.setString(8, cliente.getRg());
        comando.setString(9, String.valueOf(cliente.getSexo()));
        comando.setString(10, cliente.getDataNascimento());
        comando.setInt(11, cliente.getIdade());
        comando.setString(12, cliente.getNome());
        comando.execute();
    }

    public List<Cliente> buscarTodos() throws SQLException {
        String sql = "SELECT * FROM cliente ORDER BY nome";
        PreparedStatement comando = bd.prepareStatement(sql);
        ResultSet cursor = comando.executeQuery(sql);
        List<Cliente> listaClientes = new ArrayList<Cliente>();
        while (cursor.next()) {
            Cliente cliente = new Cliente();
            Cidade cidade = new Cidade();
            cliente.setNome(cursor.getString("nome"));
            cliente.setLogradouro(cursor.getString("logradouro"));
            cliente.setNumeroLogradouro(cursor.getInt("numero_logradouro"));
            cliente.setBairro(cursor.getString("bairro"));
            cidade.setNome(cursor.getString("cidade"));
            cliente.setCidade(cidade);
            EstadoDAO estadoDAO = new EstadoDAO(bd);
            cliente.setEstado(estadoDAO.buscarPorNome(cursor.getString("estado")));
            cliente.setTelefone(cursor.getString("telefone"));
            cliente.setCpf(cursor.getString("cpf"));
            cliente.setRg(cursor.getString("rg"));
            cliente.setSexo(cursor.getString("sexo").charAt(0));
            cliente.setDataNascimento(cursor.getString("data_nascimento"));
            cliente.setIdade(cursor.getInt("idade"));
            listaClientes.add(cliente);
        }
        return listaClientes;
    }

    public void excluir(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM cliente WHERE nome=?";
        PreparedStatement comando = bd.prepareStatement(sql);
        comando.setString(1, cliente.getNome());
        comando.execute();

    }
}
