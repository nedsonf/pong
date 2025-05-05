-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;
-- Administrador
INSERT INTO Administrador (nome, email, senha, idFuncionario, dataCadastro, dataAlteracao) VALUES 
('João Silva', 'joao@admin.com', 'senha123', 'ADM001', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Cliente
INSERT INTO Cliente (nome, email, senha, cpf, cep, endereco, dataCadastro, dataAlteracao) VALUES 
('Maria Souza', 'maria@cliente.com', 'senha456', '12345678900', '77000000', 'Rua A, 123', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- CorBorracha
INSERT INTO CorBorracha (nome, cor, dataCadastro, dataAlteracao) VALUES 
('Vermelha', '#FF0000', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Preta', '#000000', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- EspessuraBorracha
INSERT INTO EspessuraBorracha (espessura, dataCadastro, dataAlteracao) VALUES 
(2.1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
(1.5, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Fabricante
INSERT INTO Fabricante (nome, email, cnpj, dataCadastro, dataAlteracao) VALUES 
('Butterfly', 'contato@butterfly.com', '12345678000199', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Donic', 'suporte@donic.com', '98765432000188', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Lote
INSERT INTO Lote (descricao, dataCadastro, dataAlteracao) VALUES 
('Lote A', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Lote B', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Raquete (usa dados inseridos nas tabelas anteriores com IDs assumidos manualmente)
INSERT INTO Raquete (nome, preco, estoqueDisponivel, tipo, id_fabricante, id_cor_borracha, id_espessura_borracha, id_lote, dataCadastro, dataAlteracao) VALUES 
('Raquete Pro 1', 349.90, 10, 'INVERTIDAS', 1, 1, 1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Raquete Pro 2', 299.90, 15, 'PINOSCURTOS', 2, 2, 2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
