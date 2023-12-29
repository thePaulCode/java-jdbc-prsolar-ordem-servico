package dev.thepaulcode.repository;

import dev.thepaulcode.model.Cliente;
import dev.thepaulcode.model.Equipamento;
import dev.thepaulcode.sql.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoRepository {

    private Connection conexao;
    public EquipamentoRepository (){

        conexao = FabricaConexao.criarConexao();
    }

    // Metodos
    // DML -- INSERT -- Salvar Equipamento
    public void salvar (Equipamento equipamento){
        String sql = "INSERT INTO tab_equipamento (tipo, descricao) VALUES (?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, equipamento.getTipo());
            statement.setString(2, equipamento.getDescricao());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Um novo equipamento foi cadastrado!");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DML -- SET -- Alterar Equipamento
    public void alterar(Equipamento equipamento){

        try {
            String sql = "UPDATE tab_equipamento SET tipo=?, descricao=? WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setString(1, equipamento.getTipo());
            statement.setString(2, equipamento.getDescricao());
            statement.setLong(3, equipamento.getId());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Dados do equipamento foram alterados.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    // DML -- DELETE WHERE id=?
    public void excluir(Integer id){
        try {
            String sql = "DELETE FROM tab_equipamento  WHERE id=?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Equipamento excluído corretamente.");
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // DQL - SELECT WHERE id=?
    public Equipamento buscarPorId(Integer id){

        Equipamento equipamento = null;

        try{
            String sql = "SELECT * FROM tab_equipamento WHERE id = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            while (result.next()){
                equipamento = new Equipamento();
                equipamento.setId(result.getInt("id"));
                equipamento.setTipo(result.getString("tipo"));
                equipamento.setDescricao(result.getString("descricao"));
            }

        } catch (Exception e){

            e.printStackTrace();

        }

        return equipamento;
    }

    // DQL -- SELECT
    public List<Equipamento> listar(){
        List<Equipamento> registros = new ArrayList<>();

        try{
            String sql = "SELECT * FROM tab_equipamento";

            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                Equipamento equipamento = new Equipamento();

                equipamento.setId(result.getInt("id"));
                equipamento.setTipo((result.getString("tipo")));
                equipamento.setDescricao(result.getString("descricao"));

                registros.add(equipamento);
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return registros;
    }
}
