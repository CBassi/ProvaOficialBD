create database tabela10k;

use tabela10k;

create table trajeto (id BIGINT NOT NULL AUTO_INCREMENT, IDARQUIVO bigint(100) not null,data varchar(100) not null, hora varchar(100) ,LATITUDE float(20) not null,LONGITUDE float(20) not null, PRIMARY KEY (ID));

create table trajetoIndex (id BIGINT NOT NULL AUTO_INCREMENT, IDARQUIVO bigint(100) not null,data varchar(100) not null, hora varchar(100) ,LATITUDE float(20) not null,LONGITUDE float(20) not null, PRIMARY KEY (ID));

-->CRIANDO INDEX
	ALTER TABLE trajetoIndex ADD INDEX(IDARQUIVO);



-->> Criar uma pasta e colocar todos os arquivos TXT nesta pasta

-->>Acessar CMD e acessar a pasta em que estão os arquivos TXT

-->usar o comando type *TXT > (nome do arquivo agrupado).TXT