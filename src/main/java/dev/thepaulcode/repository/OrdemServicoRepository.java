package dev.thepaulcode.repository;

import dev.thepaulcode.model.*;
import dev.thepaulcode.sql.FabricaConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdemServicoRepository {

    private Connection conexao;
    private ClienteRepository clienteRepository;
    private EquipamentoRepository equipamentoRepository;
    private EstabelecimentoRepository estabelecimentoRepository;
    private ServicoRepository servicoRepository;

    public OrdemServicoRepository(){
        conexao = FabricaConexao.criarConexao();
    }
    // TODO
    // Metodos
    // DML -- INSERT -- Salvar OrdemServico
    public void salvar(OrdemServico ordemServico, Estabelecimento estabelecimento, Servico servico, Equipamento equipamento, Cliente cliente) {
        String sql = "INSERT INTO tab_ordemservico (data_hora_abertura, data_hora_fechamento, valor_total, estabelecimento_id, servico_id, equipamento_id, cliente_id ) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Convert java.util.Date to java.sql.Date
            java.sql.Date sqlDataHoraAbertura = new java.sql.Date(ordemServico.getDataHoraAbertura().getTime());
            java.sql.Date sqlDataHoraFechamento = new java.sql.Date(ordemServico.getDataHoraFechamento().getTime());

            // Set parameters in the prepared statement
            statement.setDate(1, sqlDataHoraAbertura);
            statement.setDate(2, sqlDataHoraFechamento);
            statement.setDouble(3, ordemServico.getValorTotal());
            statement.setInt(4, estabelecimento.getId());  // Assuming getEstabelecimento() returns an int
            statement.setInt(5, servico.getId());         // Assuming getServico() returns an int
            statement.setInt(6, equipamento.getId());     // Assuming getEquipamento() returns an int
            statement.setInt(7, cliente.getId());         // Assuming getCliente() returns an int

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Uma nova ordem de serviço foi cadastrada!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
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
*/
    /*
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
*/
    // DQL - SELECT WHERE id=?
//    public OrdemServico buscarPorId(Integer id){
//
//        OrdemServico ordemServico = null;
//
//        try{
//            String sql = "SELECT tab_equipamento.*, tab_cliente.cpf_cnpj, tab_cliente.nome " +
//                    "FROM tab_estabelecimento INNER JOIN tab_cliente ON tab_cliente.id = tab_equipamento.id";
//
//            PreparedStatement statement = conexao.prepareStatement(sql);
//            statement.setInt(1, id);
//
//            ResultSet result = statement.executeQuery();
//
//            while (result.next()){
//                ordemServico = new OrdemServico();
//                ordemServico.setId(result.getInt("id"));
//                ordemServico.setCpfCnpj(result.getString("cpf_cnpj"));
//                ordemServico.setNome(result.getString("nome"));
//                ordemServico.setCelular(result.getLong("celular"));
//            }
//
//        } catch (Exception e){
//
//            e.printStackTrace();
//
//        }
//
//        return ordemServico;
//    }

    // DQL -- SELECT
    public List<OrdemServico> listar(){
        List<OrdemServico> registros = new ArrayList<>();

        try{
            String sql = "SELECT tab_equipamento.*, tab_cliente.cpf_cnpj, tab_cliente.nome FROM tab_equipamento INNER JOIN tab_cliente ON tab_cliente.id = tab_equipamento.id";


            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){

                OrdemServico ordemServico = new OrdemServico();
                ordemServico.setId(result.getInt("id"));
                ordemServico.setDataHoraAbertura(result.getDate("data_hora_abertura"));
                ordemServico.setDataHoraFechamento(result.getDate("data_hora_fechamento"));
                ordemServico.setValorTotal(result.getDouble("valor_total"));
                ordemServico.setEstabelecimento(result.getInt("estabelecimento_id"));
                ordemServico.setServico(result.getInt("servico_id"));
                ordemServico.setEstabelecimento(result.getInt("equipamento_id"));
                ordemServico.setEstabelecimento(result.getInt("cliente_id"));


                registros.add(ordemServico);
            }

        }catch (Exception e){

            e.printStackTrace();

        }

        return registros;
    }


    public void salvar(OrdemServico ordemServico) {
    }
}
