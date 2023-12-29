package dev.thepaulcode.repository;

import dev.thepaulcode.model.Equipamento;
import dev.thepaulcode.model.Estabelecimento;
import dev.thepaulcode.sql.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstabelecimentoRepository {

    private Connection conexao;
    public EstabelecimentoRepository(){
        conexao = FabricaConexao.criarConexao();
    }

    // Metodos
    // DML -- INSERT -- Salvar Estabelecimento
    public void salvar (Estabelecimento estabelecimento){
        String sql = "INSERT INTO tab_estabelecimento (cpf_cnpj, nome, celular) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, estabelecimento.getCpfCnpj());
            statement.setString(2, estabelecimento.getNome());
            statement.setLong(3, estabelecimento.getCelular());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo estabelecimento foi cadastrado!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DML -- SET -- Alterar Estabelecimento
    public void alterar(Estabelecimento estabelecimento){

        try {
            String sql = "UPDATE tab_estabelecimento SET cpf_cpnj=?, nome=?, celular=? WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, estabelecimento.getCpfCnpj());
            statement.setString(2, estabelecimento.getNome());
            statement.setLong(3, estabelecimento.getCelular());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Dados do estabelecimento foram alterados.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // DML -- DELETE WHERE id=?
    public void excluir(Integer id){
        try {
            String sql = "DELETE FROM tab_estabelecimento  WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Estabelecimento excluído corretamente.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DQL - SELECT WHERE id=?
    public Estabelecimento buscarPorId(Integer id){

        Estabelecimento estabelecimento = null;

        try{
            String sql = "SELECT * FROM tab_estabelecimento WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                estabelecimento = new Estabelecimento();
                estabelecimento.setId(result.getInt("id"));
                estabelecimento.setCpfCnpj(result.getString("cpf_cnpj"));
                estabelecimento.setNome(result.getString("nome"));
                estabelecimento.setCelular(result.getLong("celular"));
            }

        } catch (Exception e){

            e.printStackTrace();

        }

        return estabelecimento;
    }

    // DQL -- SELECT
    public List<Estabelecimento> listar(){
        List<Estabelecimento> registros = new ArrayList<>();

        try{
            String sql = "SELECT * FROM tab_estabelecimento";

            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                Estabelecimento estabelecimento = new Estabelecimento();

                estabelecimento.setId(result.getInt("id"));
                estabelecimento.setCpfCnpj(result.getString("cpf_cnpj"));
                estabelecimento.setNome(result.getString("nome"));
                estabelecimento.setCelular(result.getLong("celular"));

                registros.add(estabelecimento);
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return registros;
    }

}
