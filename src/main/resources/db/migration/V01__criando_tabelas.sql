
create table cliente (
id bigint not null auto_increment, 
data_cadastro date not null, 
documento varchar(255) not null, 
email varchar(255) not null, 
nome varchar(255) not null, 
senha varchar(5) not null, 
primary key (id)) engine=InnoDB default charset=utf8;

create table fornecedor (
id bigint not null auto_increment, 
cnpj varchar(255) not null, 
nome varchar(255) not null, 
primary key (id)) engine=InnoDB default charset=utf8;

create table produto (
id bigint not null auto_increment, 
categoria varchar(255) not null, 
codigo_produto varchar(255) not null, 
imagem varchar(255) not null, 
nome varchar(255) not null, 
promocao bit not null, 
quantidade integer not null, 
valor decimal(19,2) not null, 
valor_promo decimal(19,2), 
fornecedor_id bigint not null, 
primary key (id)) engine=InnoDB default charset=utf8;

create table venda (
id bigint not null auto_increment, 
data_compra date not null, 
total_compra decimal(19,2) not null, 
cliente_id bigint not null, 
fornecedor_id bigint not null, 
primary key (id)) engine=InnoDB default charset=utf8;

create table venda_produtos (
venda_id bigint not null, 
produto_id bigint not null) engine=InnoDB default charset=utf8;

alter table produto add constraint fk_fornecedor_id foreign key (fornecedor_id) references fornecedor (id);
alter table venda add constraint fk_venda_cliente_id foreign key (cliente_id) references cliente (id);
alter table venda add constraint fk_venda_fornecedor_id foreign key (fornecedor_id) references fornecedor (id);
alter table venda_produtos add constraint fk_venda_produtos_id foreign key (produto_id) references produto (id);
alter table venda_produtos add constraint fk_produtos_venda_id foreign key (venda_id) references venda (id);