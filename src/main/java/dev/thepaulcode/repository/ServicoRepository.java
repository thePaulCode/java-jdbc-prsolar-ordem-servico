package dev.thepaulcode.repository;

import dev.thepaulcode.model.Servico;
import dev.thepaulcode.sql.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ServicoRepository {

    private Connection conexao;
    public ServicoRepository(){
        conexao = FabricaConexao.criarConexao();
    }

    // Metodos

    // DML -- INSERT -- Salvar Servico
    public void salvar (Servico servico){
        String sql = "INSERT INTO tab_servico (descricao, valor) VALUES (?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, servico.getDescricao());
            statement.setDouble(2, servico.getValor());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo serviço foi inserido corretamente!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DML -- SET -- Alterar Servico
    public void alterar(Servico servico){

        try {
            String sql = "UPDATE tab_servico SET descricao=?, valor=? WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, servico.getDescricao());
            statement.setDouble(2, servico.getValor());
            statement.setInt(3, servico.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Serviço alterado corretamente!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // DML -- DELETE
    public void excluir(Integer id){
        try {
            String sql = "DELETE FROM tab_servico  WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Serviço excluído corretamente.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DQL - SELECT WHERE id=?

    public Servico buscarPorId(Integer id){

        Servico servico = null;

        try{
            String sql = "SELECT * FROM tab_servico WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                servico = new Servico();
                servico.setId(result.getInt("id"));
                servico.setDescricao(result.getString("descricao"));
                servico.setValor(result.getDouble("valor"));

            }

        } catch (Exception e){

            e.printStackTrace();

        }

        return servico;
    }

    // DQL -- SELECT
    public List<Servico> listar(){
        List<Servico> registros = new ArrayList<>();

        try{
            String sql = "SELECT * FROM tab_servico";

            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                Servico servico1 = new Servico();

                servico1.setId(result.getInt("id"));
                servico1.setDescricao((result.getString("descricao")));
                servico1.setValor(result.getDouble("valor"));

                registros.add(servico1);
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return registros;
    }

}
