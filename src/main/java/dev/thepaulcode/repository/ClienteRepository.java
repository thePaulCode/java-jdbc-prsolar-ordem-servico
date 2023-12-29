package dev.thepaulcode.repository;

import dev.thepaulcode.model.Cliente;
import dev.thepaulcode.model.Servico;
import dev.thepaulcode.sql.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private Connection conexao;
    public ClienteRepository() {
        conexao = FabricaConexao.criarConexao();
    }

    // Metodos

    // DML -- INSERT -- Salvar Servico
    public void salvar (Cliente cliente){
        String sql = "INSERT INTO tab_cliente (cpf_cnpj, nome, celular) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, cliente.getCpfCnpj());
            statement.setString(2, cliente.getNome());
            statement.setLong(3, cliente.getCelular());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo cliente foi cadastrado!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DML -- SET -- Alterar Servico
    public void alterar(Cliente cliente){

        try {
            String sql = "UPDATE tab_cliente SET cpf_cnpj=?, nome=?, celular=? WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, cliente.getCpfCnpj());
            statement.setString(2, cliente.getNome());
            statement.setLong(3, cliente.getCelular());
            statement.setInt(4, cliente.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Dados do cliente foram alterados.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // DML -- DELETE
    public void excluir(Integer id){
        try {
            String sql = "DELETE FROM tab_cliente  WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Cliente excluído corretamente.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DQL - SELECT WHERE id=?

    public Cliente buscarPorId(Integer id){

       Cliente cliente = null;

        try{
            String sql = "SELECT * FROM tab_cliente WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                cliente = new Cliente();
                cliente.setId(result.getInt("id"));
                cliente.setCpfCnpj(result.getString("cpf_cnpj"));
                cliente.setNome(result.getString("nome"));
                cliente.setCelular(result.getLong("celular"));

            }

        } catch (Exception e){

            e.printStackTrace();

        }

        return cliente;
    }

    // DQL -- SELECT
    public List<Cliente> listar(){
        List<Cliente> registros = new ArrayList<>();

        try{
            String sql = "SELECT * FROM tab_cliente";

            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                Cliente cliente = new Cliente();

                cliente.setId(result.getInt("id"));
                cliente.setCpfCnpj((result.getString("cpf_cnpj")));
                cliente.setNome(result.getString("nome"));
                cliente.setCelular(result.getLong("celular"));

                registros.add(cliente);
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return registros;
    }




}
