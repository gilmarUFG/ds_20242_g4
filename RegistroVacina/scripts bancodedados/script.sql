create database calendario_vacinacao;
use calendario_vacinacao;
create table calendario( 
id int not null auto_increment primary key, 
categoria_id int not null,
dose_id int not null,
faixaetaria_id int not null
);

create table categoria(
id int not null auto_increment primary key, 
nome varchar(15) not null
);

create table faixa_etaria(
id int not null auto_increment primary key, 
meses_inicial int not null,
meses_final int not null,
vacinas_id int not null
);

create table vacinas(
id int not null auto_increment primary key,
nome_vacina varchar(60) not null

);

create table doses(
id int  not null auto_increment primary key,
quantidade_dose varchar (5) not null
);


-- Tabela 'calendario' referenciando 'categoria' e 'doses'
alter table calendario
add constraint fk_calendario_categoria
foreign key (categoria_id) references categoria(id),
add constraint fk_calendario_dose
foreign key (dose_id) references doses(id);


-- Tabela 'faixa_etaria' referenciando 'vacinas'
alter table faixa_etaria
add constraint fk_faixaetaria_vacinas
foreign key (vacinas_id) references vacinas(id);

ALTER TABLE categoria DROP FOREIGN KEY fk_categoria_faixaetaria;
alter table categoria drop column faixaetaria_id;




