create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
create table cliente (id bigint not null auto_increment, data_cadastro date not null, documento varchar(255) not null, email varchar(255) not null, nome varchar(255) not null, senha varchar(5) not null, primary key (id)) engine=MyISAM
create table fornecedor (id bigint not null auto_increment, cnpj varchar(255) not null, nome varchar(255) not null, primary key (id)) engine=MyISAM
create table produto (id bigint not null auto_increment, categoria varchar(255) not null, codigo_produto varchar(255) not null, imagem varchar(255) not null, nome varchar(255) not null, promocao bit not null, quantidade integer not null, valor decimal(19,2) not null, valor_promo decimal(19,2), fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda (id bigint not null auto_increment, data_compra date not null, total_compra decimal(19,2) not null, cliente_id bigint not null, fornecedor_id bigint not null, primary key (id)) engine=MyISAM
create table venda_produtos (venda_id bigint not null, produto_id bigint not null) engine=MyISAM
alter table produto add constraint FKo6c1dbi17sempey5dpnx6ovrj foreign key (fornecedor_id) references fornecedor (id)
alter table venda add constraint FK50murhuotq9h2dnxej317jjiy foreign key (cliente_id) references cliente (id)
alter table venda add constraint FK29grb6hh30perue3v1btueq6d foreign key (fornecedor_id) references fornecedor (id)
alter table venda_produtos add constraint FK4ofxqhf0ow5emuwmdbflwaen9 foreign key (produto_id) references produto (id)
alter table venda_produtos add constraint FK66sx48snxj3x5us4avomrfkli foreign key (venda_id) references venda (id)
