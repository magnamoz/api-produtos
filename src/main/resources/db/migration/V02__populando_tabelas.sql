INSERT INTO cliente(nome, email, senha, documento, data_cadastro) values ('José Maria Silva', 'zezao@email.com', '123', '789.654.015-42', '2020-11-30');
INSERT INTO cliente(nome, email, senha, documento, data_cadastro) values ('Maria José da Silva', 'maria.sil@email.com', '789', '123.456.369-72', '2020-11-30');
INSERT INTO cliente(nome, email, senha, documento, data_cadastro) values ('Ana Helena Martins', 'ana.martins@email.com', '654', '258.963.741-01', '2020-11-30');
INSERT INTO cliente(nome, email, senha, documento, data_cadastro) values ('Georgina Maria gomes', 'gegomes@email.com', '987', '321.582.789-13', '2020-11-30');
INSERT INTO cliente(nome, email, senha, documento, data_cadastro) values ('Celestino Xavier', 'celestino@email.com', '421', '376.857.915-92', '2020-11-30');

INSERT into fornecedor(nome, cnpj) values ('Amazon', '21.147.452/0001-12');
INSERT into fornecedor(nome, cnpj) values ('Motorola', '13.918.287/0001-42');
INSERT into fornecedor(nome, cnpj) values ('Dell', '74.123.587/0001-24');

insert into produto (nome, codigo_produto, valor, promocao, valor_promo, categoria, imagem, quantidade, fornecedor_id) values ('celular', 'xp2', 10.50, true, 8.50, 'eletronico', 'produto.jpg', 5, 1);
insert into produto (nome, codigo_produto, valor, promocao, valor_promo, categoria, imagem, quantidade, fornecedor_id) values ('tablet', 'y8p', 12.50, false, 9.50, 'eletronico', 'produto.jpg', 6, 1);
