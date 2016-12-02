-- CRIANDO BASE DE DADOS
CREATE SCHEMA rental_cars;

-- UTILIZANDO BASE DE DADOS
USE rental_cars;

-- CRIANDO TABELA USUARIOS

CREATE TABLE users(
	id int unsigned not null primary key auto_increment, -----<<<<------- IDENTIFICAÇÃO DO USUARIO
	username varchar(45) not null , ------<<<<------- NOME DE USUARIO || APELIDO DO USUARIO
	password varchar(45) not null, ------<<<<------- SENHA DE ACEESO DO USUARIO AO SISTEMA
	nome  varchar(45) not null, ------<<<<------- NOME COMPLETO  DO USUARIO
	email varchar(45) not null , ------<<<<------- EMAIL  DO USUARIO
	perfil varchar(45) not null ------<<<<------- PERFIL DE ACESSO DO USUARIO NO SISTEMA COM PREVILEGIOS OU NÃO

);

-- CRIANDO TABELA DE VEICULOS

CREATE TABLE veiculos(
	id int unsigned not null primary key auto_increment, ------<<<<------- IDENTIFICAÇÃO DO VEICULO
	montadora  varchar(45) not null, ------<<<<------- FABRICANTE DO VEICULO
	modelo varchar(45) not null, ------<<<<------- MODELO DO VEICULO
	placa varchar(45) not null, ------<<<<------- PLACA DO VEICULO
	combustivel varchar(45) not null, -----<<<<------- COR DO VEICULO
	cor varchar(45) not null,  ------<<<<------- TIPO DE COMBUSTIVEL DO VEICULO GASOLINA || ALCOOL || FLEX || GAS
	ano_fab	varchar(10) not null, ------<<<<------- ANO DE FABRICA��O DO VEICULO
	ano_model varchar(10) not null, ------<<<<------- ANO DE MODELO DO VEICULO
	valor_dia DECIMAL(6,2) not null  --<<< VALOR DO ALUGUEL DO VEICULO--
);


-- CRIANDO TABELA DE CLIENTES

CREATE TABLE clientes(
	id int unsigned not null primary key auto_increment, -----<<<<------- IDENTIFICAÇÃO DO CLIENTE
	nome  varchar(255) not null, -----<<<<------- NOME COMPLETO DO CLIENTE
	email varchar(45) not null, -----<<<<------- NUMERO DE CPF - (CADASTRO PESSOA FISICA) DO CLIENTE
	nasc  varchar(10) not null, ----<<<<------- NUEMRO DE RG ( REGISTRO GERAL) DO CLIENTE
	sexo  varchar(9) not null, -----<<<<------- DATA DE NASCIMENTO DO CLIENTE
	cpf   varchar(15) not null, -----<<<<------- EMAIL DO CLIENTE
	rg   varchar(15) not null,  -----<<<<------- PSEXO DO CLIENTE
	celular   varchar(12) not null,   -----<<<<------- TELEFONE CELULAR DO CLIENTE
	fone  varchar(11) not null,  -----<<<<------- TELEFONE FIXO DO CLIENTE
	rua   varchar(45) not null, -----<<<<------- ENDEREÇO - RUA DO CLIENTE
	cidade   varchar(45) not null,  -----<<<<------- ENDEREÇO - CIDADE DO CLIENTE
	cep  varchar(8) not null, -----<<<<------- ENDEREÇO - NUMERO CEP (CODIGO ENDEREÇAMENTO POSTAL) DO CLIENTE
	n    varchar(4) not null, ----<<<<------- ENDEREÇO - NUEMRO RESIDENTIAL DO CLIENTE
	uf    varchar(2) not null -----<<<<------- ENDEREÇO - UF(UNIDADE DA FEDERAÇÃO) ESTADO DO CLIENTE
);

-- CRIANDO TABELA DE LOCAÇÕES COM REFERENCIAS DAS TABELAS CLIENTES E VEICULOS

CREATE TABLE locacoes (
id int(3)  unsigned not null auto_increment, ------<<<<------- Data e Hora que a nota foi gerada
veiculo_id int(3) unsigned not null,  ------<<<<------- REFERENCIA DA TABELA DE  VEICULOS
cliente_id int(3) unsigned not null, ------<<<<------- REFERENCIA DA TABELA DE  CLIENTES
quantidade_dias int(3) not null,  ------<<<<------- Quantidade de dias que o veiculo esta sendo contrado
data_locacao  timestamp not null default CURRENT_TIMESTAMP,------<<<<------- Dinheiro || Cart�o de Cr�dito
forma_pagamento varchar(32) not null,------<<<<------- Dinheiro || Cart�o de Cr�dito
parcelas int(2) not null, ------------<<<<----- Quantidadede de parcelas
valor_dia decimal(6,2) not null,------<<<<------- Por veiculo
valor_total decimal(6,2) not null,  ------<<<<------- Valor total Apos multiplicar por quatidade de dias
valor_parcela decimal(6,2) not null, ------<<<<------- Valor da Parcela a ser paga
situacao varchar(20) not null, ------<<<<------- Reserva || Pagamento Confirmado
primary key (id),
constraint fk_veiculos_func foreign key (veiculo_id) references veiculos (id),
constraint fk_clientes_func foreign key (cliente_id) references clientes (id)
);




-- INSERINDO DADOS NA TABELA USUARIOS

INSERT INTO users (username,password,nome,email,perfil) VALUES ('admin','admin','Administrador','admin@admin.com','admin');
INSERT INTO users (username,password,nome,email,perfil) VALUES ('Aleph','123456','Aleph Junio','Aleph@admin.com','user');

-- INSERINDO DADOS NA TABELA VEICULOS

INSERT INTO veiculos (montadora,modelo,placa,combustivel,cor,ano_fab,ano_model,valor_dia) VALUES ('Fiat','Uno','HHH-3356','Flex','Branco','2016','2017',350.00);
INSERT INTO veiculos (montadora,modelo,placa,combustivel,cor,ano_fab,ano_model,valor_dia) VALUES ('Fiat','Palio','JFR-3356','Gasolina','Amarelo','2014','2015',250.00);

-- INSERINDO DADOS NA TABELA CLIENTES

INSERT INTO clientes (nome,email,nasc,sexo,cpf,rg,celular,fone,rua,cidade,cep,n,uf) VALUES ('Aleph Junio','alephjunio@teste.com','12/12/1991','M','444.636.445.99','444.636.445.9','11956894512','1146894512','Taubaté','Itaquá','08577958','354','SP');
INSERT INTO clientes (nome,email,nasc,sexo,cpf,rg,celular,fone,rua,cidade,cep,n,uf) VALUES ('Fabio Araujo','Fabio@teste.com','12/12/1991','M','444.636.445.99','444.636.445.9','11956894512','1146894512','Taubaté','Itaquá','08577958','354','SP');


-- INSERINDO DADOS NA TABELA LOCAÇÕES

INSERT INTO locacoes (veiculo_id,cliente_id,quantidade_dias,forma_pagamento,parcelas,valor_dia,valor_total,valor_parcela,situacao) VALUES (1,1,3,'Dinheiro',1,250.00,750.00,750.00,'Reservado');
INSERT INTO locacoes (veiculo_id,cliente_id,quantidade_dias,forma_pagamento,parcelas,valor_dia,valor_total,valor_parcela,situacao) VALUES (1,1,3,'Dinheiro',1,250.00,750.00,750.00,'Reservado');
