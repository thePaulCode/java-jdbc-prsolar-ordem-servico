package dev.thepaulcode;

import dev.thepaulcode.model.*;
import dev.thepaulcode.repository.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Emissão de Ordem de Serviços de Sistemas Solar Fotovoltaico
// Com Persistência de dados usando Postgresql com JDBC
// @author: Paulo Santos
public class PrsolarOrdemServicosApplication {
    public static void main(String[] args) {


        // INÍCIO Operações CRUD - CAMADA EQUIPAMENTO
        salvarEquipamneto();

        //alterarEquipamento();
        //excluirEquipamento();
        // FIM Operações CRUD - CAMADA EQUIPAMENTO

        // INÍCIO Operações CRUD - CAMADA CLIENTE
       // salvarCliente();
       // excluirCliente();
       // listarClientes();
        //buscarClientePorId();
        //alterarCliente();
        //listarClientes();
        // FIM Operações CRUD - CAMADA CLIENTE

        // INÍCIO Operações CRUD - CAMADA SERVIÇOS
        //salverServico();
        // alterarServico();
        //buscarServicoPorId();
        // listarServicos();
        // excluirServico();
        // listarServicos();
        // FIM Operações CRUD - CAMADA SERVIÇOS

        // INÍCIO Operações CRUD - CAMADA ESTABELECIMENTO
        //salvarEstabelecimento();
       // buscarEstabelecimentoPorId();
        // FIM Operações CRUD - CAMADA ESTABELECIMENTO

    }

    // INÍCIO Operações CRUD - CAMADA CLIENTE
    static void salvarCliente(){

        // Cliente
        Cliente cliente = new Cliente();

        cliente.setCpfCnpj("07038768928");
        cliente.setNome("ANA SANTOS");
        cliente.setCelular(21987596644L);

        // Salvar cliente no no DB
        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.salvar(cliente);

    }

    static void alterarCliente(){
        Cliente cliente = buscarClientePorId();

        cliente.setId(1);
        cliente.setCpfCnpj("90088452311");
        cliente.setNome("STELLA DOS SANTOS");
        cliente.setCelular(43999207229L);

        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.alterar(cliente);

    }

    static void listarClientes(){
       ClienteRepository clienteRepository = new ClienteRepository();

        List<Cliente> cliente = clienteRepository.listar();

        for(Cliente c:cliente){
            System.out.println("LISTA DE CLIENTES:"+ "\n" + c.getNome());
        }
    }

    static void excluirCliente(){
        ClienteRepository clienteRepository = new ClienteRepository();

        clienteRepository.excluir(3);

    }

    static Cliente buscarClientePorId(){
        ClienteRepository clienteRepository = new ClienteRepository();
        Cliente cliente = null;

        cliente = clienteRepository.buscarPorId(1);
        System.out.println(cliente);
        return cliente;
    }


    // FIM Operações CRUD - CAMADA CLIENTE

    // INÍCIO Operações CRUD - CAMADA SERVIÇOS
    static void salvarServico(){

        // Serviços prestados
        Servico servico = new Servico();

        servico.setDescricao("LAUDO TERMOGRÁFICO NO PAINEL ELÉTRICO");
        servico.setValor(2250.0);

        // Salvar serviço no no DB
        ServicoRepository servicoRepository = new ServicoRepository();

        servicoRepository.salvar(servico);

    }

    static void alterarServico(){

        Servico servico = buscarServicoPorId();

        // Alterar serviços prestados
        //Servico servico = new Servico();

       // servico.setId(buscarServicoPorId());
        servico.setDescricao("CONFIGURAÇÃO MONITORAMENTO DA PLANTA SOLAR");
        servico.setValor(350.49);

        // Salvar serviço no no DB
        ServicoRepository servicoRepository = new ServicoRepository();
        servicoRepository.alterar(servico);
        buscarServicoPorId();

    }

    static void listarServicos(){

        ServicoRepository servicoRepository = new ServicoRepository();

        List<Servico> servicos = servicoRepository.listar();
        for(Servico s: servicos){
            System.out.println(s.getDescricao());
        }
    }

    static void excluirServico(){
        ServicoRepository servicoRepository = new ServicoRepository();
        servicoRepository.excluir(2);

    }

    static Servico buscarServicoPorId(){
        ServicoRepository servicoRepository = new ServicoRepository();
        Servico servico =null;
        System.out.println("Serviço por ID:" + servicoRepository.buscarPorId(4));
        servico = servicoRepository.buscarPorId(4);
        return servico;
    }

    // FIM Operações CRUD - CAMADA SERVIÇOS

    // INÍCIO Operações CRUD - CAMADA EQUIPAMENTO
    static void salvarEquipamneto(){

        // Equipamentos
        Equipamento equipamento = new Equipamento();

        equipamento.setTipo("INSPEÇÃO");
        equipamento.setDescricao("INSPEÇÃO ELÉTRICA NO PAINEL DE PROTEÇÃO GERAL");

        // Salvar serviço no no DB
        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();

        equipamentoRepository.salvar(equipamento);


    }
    static void alterarEquipamento(){

        Equipamento equipamento = buscarEquipamentoPorId();

        // Alterar equipamento

        equipamento.setTipo("PLACA");
        equipamento.setDescricao("LIMPEZA PLACA SOLAR");

        // Salvar Euipamento no no DB
        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();

        equipamentoRepository.alterar(equipamento);

    }

    static void listarEquipamentos(){

        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();

        List<Equipamento> equipamentos = equipamentoRepository.listar();
        for(Equipamento e: equipamentos){
            System.out.println(e.getDescricao());
        }
    }

    static void excluirEquipamento(){
        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();
        equipamentoRepository.excluir(5);
    }

    static Equipamento buscarEquipamentoPorId(){
        EquipamentoRepository equipamentoRepository = new EquipamentoRepository();
        Equipamento equipamento = null;
        equipamento = equipamentoRepository.buscarPorId(1);
        System.out.println("Equipamento por ID:" + equipamento);
        return equipamento;
    }
    // FIM Operações CRUD - CAMADA EQUIPAMENTO

    // INÍCIO Operações CRUD - CAMADA ESTABELECIMENTO
    static void salvarEstabelecimento(){

        // Estabelecimento
        Estabelecimento estabelecimento = new Estabelecimento();

        estabelecimento.setCpfCnpj("30682920100089");
        estabelecimento.setNome("PRSOLAR SOLUÇÕES EM ENERGIA E SERVIÇOS");
        estabelecimento.setCelular(43984753237L);

        // Salvar estabelecimento no no DB
        EstabelecimentoRepository estabelecimentoRepository = new EstabelecimentoRepository();
        estabelecimentoRepository.salvar(estabelecimento);

    }

    static void alterarEstabelecimento(){

        Estabelecimento estabelecimento = buscarEstabelecimentoPorId();

        // Alterar estabelecimento

        estabelecimento.setCpfCnpj("070301654000198");
        estabelecimento.setNome("PRS Engenharia");
        estabelecimento.setCelular(43991299664L);
        // Salvar estabelecimento no no DB
        EstabelecimentoRepository estabelecimentoRepository = new EstabelecimentoRepository();

        estabelecimentoRepository.alterar(estabelecimento);

    }

    static void listarEstabelecimentos(){

        EstabelecimentoRepository estabelecimentoRepository = new EstabelecimentoRepository();

        List<Estabelecimento> estabelecimentos = estabelecimentoRepository.listar();
        for(Estabelecimento e: estabelecimentos){
            System.out.println(e.getNome());
        }
    }

    static void excluirEstabelecimento(){
        EstabelecimentoRepository estabelecimentoRepository = new EstabelecimentoRepository();
        estabelecimentoRepository.excluir(1);
    }

    static Estabelecimento buscarEstabelecimentoPorId(){
        EstabelecimentoRepository estabelecimentoRepository = new EstabelecimentoRepository();
        Estabelecimento estabelecimento = null;
        estabelecimento = estabelecimentoRepository.buscarPorId(1);
        System.out.println("Estabelecimento por ID:" + estabelecimento);
        return estabelecimento;
    }
    // FIM Operações CRUD - CAMADA ESTABELECIMENTO




}