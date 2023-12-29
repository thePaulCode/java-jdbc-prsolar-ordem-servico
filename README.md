# Projeto PrsolarOrdemServicos

### Java Explorer: [Paulo Santos](https://www.linkedin.com/in/santospaulo21/)

O propósito deste projeto é explorar os fundamentos do JDBC em Java e aprofundar o conhecimento na persistência de dados no PostgreSQL. O projeto simula a emissão de ordens de serviços para sistemas de energia solar fotovoltaica, utilizando operações CRUD (Create, Read, Update, Delete) em diferentes entidades, como Cliente, Equipamento, Estabelecimento e Serviço.

## Estrutura do Projeto

O projeto está estruturado em classes Java organizadas em pacotes. Cada entidade possui uma classe de modelo (por exemplo, Cliente, Equipamento, etc.) e uma classe de repositório correspondente (por exemplo, ClienteRepository, EquipamentoRepository, etc.) que lida com as operações de persistência no banco de dados PostgreSQL.

### Diagrama de Classes

O diagrama de classes abaixo representa a estrutura do projeto:

[![](https://mermaid.ink/img/pako:eNrdVk2P2jAQ_SuRT0ELK1hgCVaFVEEPK23bVal6aFNVxhmoK8dOHQfBIv57bQgln3yInsoFGL_3ZubZY3mDqAwAYUQ5ieMJIwtFQl84zu6_86JiyYn6qAIIp6CWjMr4bRRxRolmUjgbC3Wcu5Aw4U61YmLx7btD1CJu2JWtL45aY85AaDhwWizAzpMJLEClERrNf1AR_cLOXioNCxlCIUSBJ6Yu7DzLQ-wuBv0UuBnVBnaWkgXH5XE0Hxt5t5inBPxgMrrZtGWpfQFurpAMKtf5u98Ji0houpcnutcskoU2A4ipMl4X4he0-tmIuVnFEmJy0HZLWWr7iDWZAQfKzvXyv-5kOgMnOl8SLo3IRCYzDjdv4xer5uY0_8VGpqP4CSIZMy3V-m9DVApYWYGxFAKoHfI0U4njNg41EL60Bu4B-KCeL5RwDeosClaUJ0zVezJLYkrUi1Ql41K9FMeZOavKNfFn8-tNujg6NZpXuVHJKzoCRxDOZqp25jL0DQ5lNKtdygBG54b_OrfquCXH8kBczFrj3FWsWxzM69a4mAeN6i6RqxwscYrOxXsAPqhXO3UadYMzqV61I-li1olzD4tWa1S-pS4lVg7nxeS6s3qpQGmrLLF842Y6tIDqi6jQzQ5YO4cV1VtC-bhlqvQFaqIQlHnABeYVuDuIPtI_IQQfYfMzgDlJuPaRL7YGShItp2tBEdYqgSZKooBoSN-NCM8Jj000IgLhDVoh3Ln3uv1u23y8h87Q84ZNtEb4wbvv9Lu93mN_0Ol32t5w20SvUoYW3-55j15_4A2G7V672-s3EQS27PfpO9V-7TJ83RFsGds_KLGrUA?type=png)](https://mermaid.live/edit#pako:eNrdVk2P2jAQ_SuRT0ELK1hgCVaFVEEPK23bVal6aFNVxhmoK8dOHQfBIv57bQgln3yInsoFGL_3ZubZY3mDqAwAYUQ5ieMJIwtFQl84zu6_86JiyYn6qAIIp6CWjMr4bRRxRolmUjgbC3Wcu5Aw4U61YmLx7btD1CJu2JWtL45aY85AaDhwWizAzpMJLEClERrNf1AR_cLOXioNCxlCIUSBJ6Yu7DzLQ-wuBv0UuBnVBnaWkgXH5XE0Hxt5t5inBPxgMrrZtGWpfQFurpAMKtf5u98Ji0houpcnutcskoU2A4ipMl4X4he0-tmIuVnFEmJy0HZLWWr7iDWZAQfKzvXyv-5kOgMnOl8SLo3IRCYzDjdv4xer5uY0_8VGpqP4CSIZMy3V-m9DVApYWYGxFAKoHfI0U4njNg41EL60Bu4B-KCeL5RwDeosClaUJ0zVezJLYkrUi1Ql41K9FMeZOavKNfFn8-tNujg6NZpXuVHJKzoCRxDOZqp25jL0DQ5lNKtdygBG54b_OrfquCXH8kBczFrj3FWsWxzM69a4mAeN6i6RqxwscYrOxXsAPqhXO3UadYMzqV61I-li1olzD4tWa1S-pS4lVg7nxeS6s3qpQGmrLLF842Y6tIDqi6jQzQ5YO4cV1VtC-bhlqvQFaqIQlHnABeYVuDuIPtI_IQQfYfMzgDlJuPaRL7YGShItp2tBEdYqgSZKooBoSN-NCM8Jj000IgLhDVoh3Ln3uv1u23y8h87Q84ZNtEb4wbvv9Lu93mN_0Ol32t5w20SvUoYW3-55j15_4A2G7V672-s3EQS27PfpO9V-7TJ83RFsGds_KLGrUA)

# Configuração do Banco de Dados

Certifique-se de ter um banco de dados PostgreSQL configurado com as credenciais corretas. As configurações de conexão estão localizadas no arquivo `FabricaConexao.java`.

# Executando o Projeto

1. Clone o repositório: `git clone https://github.com/thePaulCode/java-jdbc-prsolar-ordem-servico.git`
2. Abra o projeto em sua IDE favorita.
3. Configure as credenciais do banco de dados em `FabricaConexao.java`.
4. Execute a classe `PrsolarOrdemServicosApplication` para iniciar o aplicativo.

# Contribuição

Sinta-se à vontade para contribuir com melhorias, correções de bugs ou novas funcionalidades. Abra uma issue ou envie um pull request!

# Licença

Este projeto é licenciado sob a MIT License - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.
