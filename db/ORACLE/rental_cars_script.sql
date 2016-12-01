-------------------------------------------------------
--- AUTO INCREMENTE PARA INSER��O DE ID-----

CREATE SEQUENCE sequencia
minvalue 1
maxvalue 999999999
START WITH 1
INCREMENT BY 1
nocache
nocycle;
-----------------------------


CREATE TABLE users (
id NUMBER(3) PRIMARY KEY, --auto increment ------<<<<------- IDENTIFICAÇÃO DO USUARIO
username varchar(45) not null unique, ------<<<<------- NOME DE USUARIO || APELIDO DO USUARIO
senha varchar(45) not null, ------<<<<------- SENHA DE ACEESO DO USUARIO AO SISTEMA
nome  varchar(45) not null, ------<<<<------- NOME COMPLETO  DO USUARIO
email varchar(45) not null, ------<<<<------- EMAIL  DO USUARIO
perfil varchar(45) not null ------<<<<------- PERFIL DE ACESSO DO USUARIO NO SISTEMA COM PREVILEGIOS OU NÃO
);
------------------------------------------------------


CREATE TABLE clientes(
id NUMBER(3) PRIMARY KEY, --auto increment--  -----<<<<------- IDENTIFICAÇÃO DO CLIENTE
nome VARCHAR2(20) NOT NULL,  -----<<<<------- NOME COMPLETO DO CLIENTE
cpf NUMBER(11) UNIQUE,  -----<<<<------- NUMERO DE CPF - (CADASTRO PESSOA FISICA) DO CLIENTE
rg NUMBER(9) NOT NULL,  -----<<<<------- NUEMRO DE RG ( REGISTRO GERAL) DO CLIENTE
data_nasc VARCHAR2(10) NOT NULL,  -----<<<<------- DATA DE NASCIMENTO DO CLIENTE
email varchar(45) NOT NULL,  -----<<<<------- EMAIL DO CLIENTE
sexo char(1) NOT NULL,  -----<<<<------- PSEXO DO CLIENTE
celular varchar(12) NOT NULL,  -----<<<<------- TELEFONE CELULAR DO CLIENTE
fone varchar(11) NULL,  -----<<<<------- TELEFONE FIXO DO CLIENTE
rua varchar(45) NOT NULL,  -----<<<<------- ENDEREÇO - RUA DO CLIENTE
cidade varchar(45) NOT NULL,  -----<<<<------- ENDEREÇO - CIDADE DO CLIENTE
cep  varchar(8) NOT NULL,  -----<<<<------- ENDEREÇO - NUMERO CEP (CODIGO ENDEREÇAMENTO POSTAL) DO CLIENTE
n  varchar(4) NOT NULL,  -----<<<<------- ENDEREÇO - NUEMRO RESIDENTIAL DO CLIENTE
uf varchar(2) NOT NULL  -----<<<<------- ENDEREÇO - UF(UNIDADE DA FEDERAÇÃO) ESTADO DO CLIENTE
);
-------------------------------------------------------
CREATE TABLE veiculos(
id NUMBER(3) PRIMARY KEY, --auto increment-- ------<<<<------- IDENTIFICAÇÃO DO VEICULO
marca VARCHAR2(20) NOT NULL,  ------<<<<------- FABRICANTE DO VEICULO
modelo VARCHAR2(20) NOT NULL,  ------<<<<------- MODELO DO VEICULO
placa VARCHAR2(8) UNIQUE,  ------<<<<------- PLACA DO VEICULO
cor varchar(32) NOT NULL,  ------<<<<------- COR DO VEICULO
combustivel varchar(45) NOT NULL, ------<<<<------- TIPO DE COMBUSTIVEL DO VEICULO GASOLINA || ALCOOL || FLEX || GAS
ano_fab	varchar(10) NOT NULL, ------<<<<------- ANO DE FABRICA��O DO VEICULO
ano_model varchar(10) not null, ------<<<<------- ANO DE MODELO DO VEICULO
valor_dia NUMBER(6,2) NOT NULL,         --<<< VALOR DO ALUGUEL DO VEICULO--
situacao VARCHAR2(10) NOT NULL          --<<< Indisponivel || Disponivel--
);
-------------------------------------------------------------------------------------------------
CREATE TABLE notas(
id number(3) primary key, --auto increment--
data_locacao SYSDATE, ------<<<<------- Data e Hora que a nota foi gerada
quantidade_dias NUMBER(3) NOT NULL, ------<<<<------- Quantidade de dias que o veiculo esta sendo contrado
valor_total NUMBER(7,2) NOT NULL,  ------<<<<------- Valor total Apos multiplicar por quatidade de dias
valor_parcela NUMBER(6,2) not null,   ------<<<<------- Valor da Parcela a ser paga
forma_pagamento varchar2(32) not null, ------<<<<------- Dinheiro || Cart�o de Cr�dito
valor_dia NUMBER(6,2) NOT NULL,       ------<<<<------- Por veiculo
situacao VARCHAR2(10) NOT NULL,       ------<<<<------- Reserva || Pagamento Confirmado
cliente_id NUMBER(3)NOT NULL , ------<<<<------- REFERENCIA DA TABELA DE  CLIENTES
veiculo-id NUMBER(3) NOT NULL, ------<<<<------- REFERENCIA DA TABELA DE  VEICULOS
FOREIGN KEY(users_id)   REFERENCES users(id),
FOREIGN KEY(cliente_id) REFERENCES clientes(id),
FOREIGN KEY(veiculo_id) REFERENCES veiculos(id)
);
------------------------------------------------------------------------------------------------------------------------------------------------------------
--Inserindo info na tabela USERS
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'admin',root,'ADM','admin@admin.com','admin');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'aleph','123456','Aleph Junio','Aleph@admin.com','user');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'artuf','123456','Artur Filipe','artuf@admin.com','user');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'fabiogda','123456','Fabio Gomes','fabiogda@admin.com','user');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'edcarlosz','123456','Edcarlos da Rocha','edcarlosz@admin.com','user');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'gabrielabm','123456','Gabriela Basse','gabrielabm@admin.com','user');
INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,'patriciar','123456','Patricia Rocha','patriciar@admin.com','user');
------------------------------------------------------------------------------------------------------------------------------------------------------------
--Inserindo info na tabela clientes

INSERT INTO clientes (id,nome,sobrenome,sexo,celular,fone,rua,cidade,cep,n,uf,cpf,rg,data_nasc) VALUES (sequencia.nextval,'teste','teste1','M','11-987451231','3481-2121','Rua dos Admin','S�o Paulo',02800150,20,'sp',12345678911,999877456,'01/01/1999');
INSERT INTO clientes (id,nome,sobrenome,sexo,celular,fone,rua,cidade,cep,n,uf,cpf,rg,data_nasc) VALUES (sequencia.nextval,'Alef','Junio','M','11-987455844','3411-5811','Rua Galvao','Itaqu�',02834150,186,'sp',12351364911,998765456,'01/01/1994');
INSERT INTO clientes (id,nome,sobrenome,sexo,celular,fone,rua,cidade,cep,n,uf,cpf,rg,data_nasc) VALUES (sequencia.nextval,'Fabio','Gomes','M','11-957354544','3813-6407','Rua da Matriz','S�o Paulo',02832490,429,'sp',12353462851,990165126,'01/01/1991');
------------------------------------------------------------------------------------------------------------------------------------------------------------
--Inserindo info na tabela veiculos
INSERT INTO veiculos (id,marca,modelo,placa,cor,combustivel,ano_fab,ano_model,valor_dia) VALUES (sequencia.nextval,'wolkswagen','Gol G3','AAA-1234','azul','Gasolina',2012,2013,300.00);
INSERT INTO veiculos (id,marca,modelo,placa,cor,combustivel,ano_fab,ano_model,valor_dia) VALUES (sequencia.nextval,'Fiat','Palio','JFR-3356','verde','Alcool',2013,2014,200.00)
INSERT INTO veiculos (id,marca,modelo,placa,cor,combustivel,ano_fab,ano_model,valor_dia) VALUES (sequencia.nextval,'Fiat','Uno','HHK-3356','prata','flex',2012,2013,250.00)
------------------------------------------------------------------------------------------------------------------------------------------------------------
--Inserindo info na tabela de nota de locação
INSERT INTO notas (id,data_locacao,quantidade_dias,valor_total,valor_parcela,forma_pagamento,valor_dia,situacao) VALUES (sequencia.nextval,sysdate,3,650.00,3,'cartao',116.66,'Pagamento Confirmado');
INSERT INTO notas (id,data_locacao,quantidade_dias,valor_total,valor_parcela,forma_pagamento,valor_dia,situacao) VALUES (sequencia.nextval,sysdate,3,650.00,3,'cartao',116.66,'Reverva');
------------------------------------------------------------------------------------------------------------------------------------------------------------


--Atualizando tabela de veiculos coluna valor da diaria do mesmo

--<<< Alterando valor da diaria de veiculos para 150 reais os veiculos que a diaria é menor que 100 reais  <<<--
update veiculos set valor_dia = 150.00 where valor_dia < 100.00 ;

--<<< Alterando valor da diaria de veiculos para 350 reais os veiculos que a diaria é igual  280 reais <<<--
update veiculos set valor_dia = 350.00 where valor_dia = 280.00 ;

--<<< Alterando valor da diaria de veiculos para 450 reais os veiculos que a diaria é menor que 330 reais <<<--
update veiculos set valor_dia = 400.50 where valor_dia < 330.00 ;

-----------------------------------------------------------------------------------------------------------------------------------------------------

-----------------------------------------------------------------------------------------
------|-->>> Bloco de decis�o caso ja possua cadastro para LOGAR no sistema  <<<--|------
-----------------------------------------------------------------------------------------
DECLARE
v_username users.username%type:=&Digite_um_apelido;
v_senha users.senha%type:=&Digite_sua_senha;

BEGIN
IF username = v_username AND senha = v_senha THEN
  dbms_output.put_line('Login efetuado com sucesso');

ELSE
  dbms_output.put_line('Digite um login valido');
end IF;
end;
/

--------------------------------------------------------------------------
------|-->>> Bloco de decis�o com Variaveis de cadastro USERS <<<--|------
--------------------------------------------------------------------------
  DECLARE
v_username users.username%type:=&Digite_um_apelido;
v_senha users.senha%type:=&Digite_uma_senha;
v_nome users.nome%type:=&Digite_nome;
v_email users.email%type:=&Digite_email;
v_perfil users.perfil%type:=&Digite_o_perfil;


BEGIN
IF username = v_username AND senha = v_senha THEN
	INSERT INTO users (users_id,username,senha,nome,email,perfil) VALUES (sequencia.nextval,v_username,v_senha,v_nome,v_email,v_perfil);
	dbms_output.put_line('Cadastro efetuado com sucesso');

ELSE
  dbms_output.put_line('Você não cadastrou..');
end IF;
end;
/

---------------------------------------------------------------------------------
------|-->>> Bloco de decis�o com Variaveis de cadastro CLIENTE e IF <<<--|------
---------------------------------------------------------------------------------
DECLARE
v_nome cliente.nome%type:=&Digite_seu_nome;
v_sobrenome cliente.sobrenome%type:=&Digite_seu_sobrenome;
v_sexo cliente.sexo%type:=&Digite_seu_sexo_(F/M);
v_celular cliente.celular%type:=&Digite_um_numero_de_celular;
v_fone cliente.fone%type:=&Digite_um_numero_de_telefone;
v_rua cliente.rua%type:=&Digite_sua_rua;
v_cidade cliente.cidade%type:=&Digite_sua_cidade;
v_cep cliente.cep%type:=&Digite_seu_cep;
v_n cliente.n%type:=&Digite_o_numero_da_casa;
v_uf cliente.uf%type:=&Digite_o_estado;
v_cpf cliente.cpf%type:=&Digite_seu_CPF;
v_rg cliente.rg%type:=&Digite_seu_RG;
v_datanasc cliente.data_nasc%type:=&Digite_sua_data_de_nascimento;
v_cadastro char(3):=&Deseja_cadastrar_este_cliente?


BEGIN
IF v_cadastro = s || v_cadastro = S || v_cadastro = sim || v_cadastro = SIM THEN
	INSERT INTO cliente (cliente_id,nome,sobrenome,sexo,celular,fone,rua,cidade,cep,n,uf,cpf,rg,data_nasc) VALUES (sequencia.nextval,v_nome,v_sobrenome,v_sexo,v_celular,v_fone,v_rua,v_cidade,v_cep,v_n,v_uf,v_cpf,v_rg,v_datanasc);--<<< Arrumar essa linha
	dbms_output.put_line('Cadastro efetuado com sucesso');

else v_cadastro = n || v_cadastro = N || v_cadastro = nao || v_cadastro = NAO THEN ---<<< USAR EXCEPTION
  dbms_output.put_line('Voc� n�o cadastrou!');
end IF;
end;
/

------------------------------------------------------------------------
----|-->>>   Decis�o se alguem quer cadastradar um veiculo  <<<--|------
------------------------------------------------------------------------
DECLARE
v_cadastro char(3);
v_marca veiculos.marca%type:=&Digite_a_marca_do_veiculo;
v_modelo veiculos.modelo%type:=&Digite_o_modelo_do_veiculo;
v_placa veiculos.placa%type:=&Digite_a_placa_do_veiculo;
v_cor veiculos.cor%type:=&Digite_a_cor;
v_porta veiculos.porta%type:=&Digite_a_quantidade_de_portas;
v_montadora veiculos.montadora%type:=&Digite_a_montadora;
v_combustivel veiculos.combustivel%type:=&Digite_o_tipo_de_combustivel;
v_anofab veiculos.anofab%type:=&Digite_o_ano_de_fabricacao;
v_anomodel veiculos.anomodel%type:=&Digite_o_ano_modelo;
v_valdia veiculos.valdia%type:=&Digite_o_valor_para_aluga-lo;
v_situacao veiculos.situacao%type;
veiculos
BEGIN
IF v_cadastro = s || v_cadastro = S || v_cadastro = sim || v_cadastro = SIM THEN
	INSERT INTO veiculo (veiculo_id,marca,modelo,placa,cor,porta,montadora,combustivel,ano_fab,ano_model,valor_dia,situacao) VALUES (auto,v_marca,v_modelo,v_placa,v_cor,v_porta,v_montadora,v_combustivel,v_anofab,v_anomodel,v_valdia,'Disponivel');   --<<< Arrumar essa linha <<<-------

else v_cadastro = n || v_cadastro = N || v_cadastro = nao || v_cadastro = NAO THEN
	dbms_output.put_line('Voc� n�o cadastrou..');
end IF;
end;
/

---------------------------------------------------------------------
------|-->>>   Decis�o para consultar/alugar o veiculo   <<<--|------
---------------------------------------------------------------------
DECLARE
v_modelo veiculos.modelo%type:=&Qual_modelo_deseja_alugar?;
v_situacao veiculos.situacao%type;

BEGIN
IF modelo = v_modelo THEN
   dbms_output.put_line('Veiculo' || situacao || 'para loca��o!')
   update veiculo set situacao = 'indisponivel' where modelo = v_modelo;      --<<< Arruma essa linha <<<--

else  modelo = v_modelo THEN
   dbms_output.put_line('Veiculo' || situacao || 'para loca��o!')

end IF;
end;
/
----------------------------------------------------------------------------------
------|-->>>   Procedure para inserir, alterar e excluir dados da tabela   <<<--|------
----------------------------------------------------------------------------------

CREATE OR REPLACE PROCEDURE "USERS" (
  vID     INTEGER,
  vNOME   VARCHAR2,
  vSENHA  VARCHAR2,
  vEMAIL  VARCHAR2,
  vPERFIL VARCHAR2,
  vOPR        CHAR
)

IS
  vEXCEPTION EXCEPTION;
BEGIN
  IF (vOPR = 'I') THEN
    INSERT INTO users (id,username,senha,nome,email,perfil) VALUES (vID,  vNOME,  vSENHA,  vEMAIL,  vPERFIL);
  ELSE
  IF(vOPR = 'A') THEN
    UPDATE users SET nome = vNome WHERE id = vID;
  ELSE
  IF(vOPR = 'D')THEN
    DELETE FROM users WHERE id = vID;
  ELSE
    RAISE vEXCEPTION;
  END IF;
  END IF;
  END IF;
  EXCEPTION
    WHEN vEXCEPTION THEN
      RAISE_APPLICATION_ERROR(-20999,'ATENÇÃO! Operação diferente de I, D, A.', FALSE);
END USERS;



---- CHAMANDO Procedure

EXEC USERS(1, 'admin', 'admin', 'admin','admin@admin', 'admin', 'I');
