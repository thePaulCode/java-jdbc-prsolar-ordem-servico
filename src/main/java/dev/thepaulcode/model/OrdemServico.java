package dev.thepaulcode.model;

import dev.thepaulcode.repository.OrdemServicoRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class OrdemServico  {

    private Integer id;
    private Date dataHoraAbertura;
    private Date dataHoraFechamento;
    private Double valorTotal;
    private Integer estabelecimentoId;
    private Integer servicoId;
    private Integer equipamentoId;
    private Integer clienteId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(Date dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public Date getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(Date dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }


    public void setEstabelecimento(Integer estabelecimentoId) {
        this.estabelecimentoId = estabelecimentoId;
    }

    public void setServico(Integer servicoId) {
        this.servicoId = servicoId;
    }

    public void setEquipamento(Integer equipamentoId) {
        this.equipamentoId = equipamentoId;
    }

    public void setCliente(Integer clienteId) {
        this.clienteId = clienteId;
    }
/*
* // INÍCIO Operações CRUD - CAMADA CAMADA ORDEM DE SERVIÇO
    static void salvarOrdemServico(){

        // Estabelecimento
        OrdemServico ordemServico = new OrdemServico();

        java.sql.Date sqlDataHoraAbertura = java.sql.Date.valueOf("2023-12-20");
        java.sql.Date sqlDataHoraFechamento = java.sql.Date.valueOf("2023-12-25");


        ordemServico.setId(1000);
        ordemServico.setDataHoraAbertura(sqlDataHoraAbertura);
        ordemServico.setDataHoraAbertura(sqlDataHoraFechamento);
        ordemServico.setValorTotal(1999.55);
        ordemServico.setEstabelecimento(buscarEstabelecimentoPorId().getId());
        ordemServico.setServico(buscarServicoPorId().getId());
        ordemServico.setEquipamento(buscarEquipamentoPorId().getId());
        ordemServico.setCliente(buscarClientePorId().getId());



        // Salvar estabelecimento no no DB
        OrdemServicoRepository ordemServicoRepository = new OrdemServicoRepository();
        ordemServicoRepository.salvar(ordemServico);

    }

/*
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

static void listarOrdemServico(){*/
/*
    OrdemServicoRepository ordemServicoRepository = new OrdemServicoRepository();

    List<OrdemServico> ordemServicos = ordemServicoRepository.listar();
    for(OrdemServico o: ordemServicos){
        if(!ordemServicos.isEmpty()){
            System.out.println("Lista vazia");
        }
        System.out.println(o);
    }
}
/*
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
    // FIM Operações CRUD - CAMADA ORDEM DE SERVIÇO
*/


}
