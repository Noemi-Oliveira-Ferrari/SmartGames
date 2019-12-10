create database db_smart_games;
use db_smart_games;

create table tbl_jogo(
	id_jogo int not null primary key auto_increment,
	titulo_jogo varchar(200) not null,
    descricao text not null,
    idade int not null,
    preco double not null,
    ano_lancamento int not null,
    foto_mobile text not null,
    foto_web text not null,
    avaliacao int not null,
    id_genero int not null,
    id_console int not null,
    id_loja int not null,
    id_desenvolvedor int not null,
    CONSTRAINT fk_genero FOREIGN KEY (id_genero) REFERENCES tbl_genero(id_genero),
    CONSTRAINT fk_console FOREIGN KEY (id_console) REFERENCES tbl_console(id_console),
    CONSTRAINT fk_loja FOREIGN KEY (id_loja) REFERENCES tbl_loja(id_loja),
    CONSTRAINT fk_desenvolvedor FOREIGN KEY (id_desenvolvedor) REFERENCES tbl_desenvolvedor(id_desenvolvedor)
);

create table tbl_desenvolvedor(
	id_desenvolvedor int not null primary key auto_increment,
    titulo_desenvolvedor varchar(200) not null
);

create table tbl_genero(
	id_genero int not null primary key auto_increment,
    titulo_genero varchar(200) not null
);

create table tbl_console(
	id_console int not null primary key auto_increment,
    titulo_console varchar(200) not null
);

create table tbl_loja(
	id_loja int not null primary key auto_increment,
    titulo_loja_shopping varchar(200) not null,
    id_endereco int not null,
    CONSTRAINT fk_endereco FOREIGN KEY (id_endereco) REFERENCES tbl_endereco(id_endereco)
);

create table tbl_endereco(
	id_endereco int not null primary key auto_increment,
    logradouro varchar(200) not null,
    local_mapa text not null,
    id_uf int not null,
    bairro varchar(200),
    numero int,
    id_coordenadas int not null,
    CONSTRAINT fk_uf FOREIGN KEY (id_uf) REFERENCES tbl_uf(id_uf),
    CONSTRAINT fk_coordenadas FOREIGN KEY (id_coordenadas) REFERENCES tbl_coordenadas(id_coordenadas)
);

create table tbl_uf(
	id_uf  int not null primary key auto_increment,
	uf varchar(2) NOT NULL,
	estado varchar(50) NOT NULL
);

create table tbl_coordenadas(
	id_coordenadas int not null primary key auto_increment,
    longitude varchar(100) not null,
    latitude varchar(100) not null
);
