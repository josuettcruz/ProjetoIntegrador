# ProjetoIntegrador

## Sistema de estoque de loja

*Este é um sistema de estoque de loja cujo objetivo é organizar os produtos que estão a venda.*

**Mas ao contrário dos sistemas atuais, nesse sistema, cada produto é cadastrado individualmente**

**Exemplo**

- Leite Longa Vida - 12 unidades

> Ao invés de cadastrar todos os produtos com um mesmo código, cada produto recebe um código individual.
> Similar à um __IMEI__ de um __SMARDPHONE__

## Tecnologia aplicada

### Produtos na loja

#### Banco de Dados SQL

Sistema de tabela __1:N__

- Tabela ITEM
- Tabela PRODUTO
- Tabela MARCA

> A tabela ITEM, registra cada item individualmente.
> A tabela PRODUTO, registra o item coletivamente
> Já a tabela marca, registra a marca do produto e pode ser opcional

Fica assim:
> ITEM 1:N PRODUTO 1:N MARCA

*A tabela item, vai registrar cada item individualmente.
A mesma terá um __Foreign Key__ para a tebala PRODUTOS
que por sua vez, terá um __Foreign Key__ para a tabela MARCA*

## Time de Desenvolvimento

O sistema começa com o Banco de Dados SQL com essas 3 tabelas.

Logo após vem a parte JAVA onde será integrada ao Banco de Dados.

> Todo o sistema deve contar com possíveis atualizações futuras.
> Pois é importante lembrar que no decorrer do projeto, haverá novas implementações que irá incluir um sistema de AUTOMAÇÃO

## Sistema em Desenvolvimento

[ ] - Controle de produto na loja
> Sistema atual desse projeto

[ ] - Controle de produto no transporte
> Próximo passo, não será desenvolvido até terminar o primeiro

[ ] - Sistema de AUTOMAÇÃO
> Não está previsto para esse projeto, mas em algum momento vai aparecer.
> Ou seja, cedo ou mais tarde, será desenvolvido um sistema automático com robôs com um scanner para identificar, separar e distribuir produtos com o mínimo de intervenção humana.

## Sistema SQL

### Tabela ITEM

- ID

- Data de fabricação

- LOCAL DE FABRICAÇÃO

- Especificações

- Status (VENDIDO, DISPONÍVEL, VIOLADO)

- Chave Estrangeira para PRODUTO

### Tabela PRODUTO

- ID

- Nome do PRODUTO

- Detalhes do PRODUTO

- Tipo de Produto
> ALIMENTÍCIO, FARMACÊUTICO, LETRÔNICO

- Chave Estrangeira para MARCA

### Tabela MARCA

- ID

- NOME

- CNPJ

- DESCRIÇÃO
