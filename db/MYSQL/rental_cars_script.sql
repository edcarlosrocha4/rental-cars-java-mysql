-- CRIANDO BASE DE DADOS 
CREATE SCHEMA rental_cars;

-- UTILIZANDO BASE DE DADOS
USE rental_cars;

-- CRIANDO TABELA USUARIOS

CREATE TABLE users(
	id int unsigned not null primary key auto_increment,
	username varchar(45) not null ,
	password varchar(45) not null,
	nome  varchar(45) not null,
	email varchar(45) not null ,
	perfil varchar(45) not null

);

-- CRIANDO TABELA DE VEICULOS

CREATE TABLE veiculos(
	id int unsigned not null primary key auto_increment,
	montadora  varchar(45) not null,
	modelo varchar(45) not null,
	placa varchar(45) not null,
	combustivel varchar(45) not null,
	cor varchar(45) not null,
	ano_fab	varchar(10) not null,
	ano_model varchar(10) not null,
	valor_dia DECIMAL(6,2) not null
);


-- CRIANDO TABELA DE CLIENTES

CREATE TABLE clientes(
	id int unsigned not null primary key auto_increment,
	nome  varchar(255) not null,
	email varchar(45) not null,
	nasc  varchar(10) not null,
	sexo  char(1) not null,
	cpf   varchar(15) not null,
	rg   varchar(15) not null,
	celular   varchar(12) not null,
	fone  varchar(11) not null,
	rua   varchar(45) not null,
	cidade   varchar(45) not null,
	cep  varchar(8) not null,
	n    varchar(4) not null,
	uf    varchar(2) not null
);

-- CRIANDO TABELA DE LOCAÇÕES COM REFERENCIAS DAS TABELAS CLIENTES E VEICULOS

CREATE TABLE locacoes (
id int(3)  unsigned not null auto_increment,
veiculo_id int(3) unsigned not null,
cliente_id int(3) unsigned not null,
quantidade_dias int(3) not null, 
data_locacao  timestamp not null default CURRENT_TIMESTAMP,
forma_pagamento varchar(32) not null,
parcelas int(2) not null,
valor_dia decimal(6,2) not null,
valor_total decimal(6,2) not null,
valor_parcela decimal(6,2) not null,
situacao varchar(20) not null,
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
