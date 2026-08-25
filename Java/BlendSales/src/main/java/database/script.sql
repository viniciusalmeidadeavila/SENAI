-- =========================================================
-- Sistema de Vendas Online - Esquema do Banco de Dados
-- MySQL
-- =========================================================

CREATE DATABASE IF NOT EXISTS BlendSales
    DEFAULT CHARACTER SET utf8mb4;
USE BlendSales;

-- ---------------------------------------------------------
-- Tabela: usuario
-- Usuários que acessam o sistema (vendedor/administrador),
-- usada na tela de login.
-- A senha é armazenada JÁ CRIPTOGRAFADA (hash, ex: bcrypt).
-- A regra de "mínimo 13 dígitos" vale para a senha em texto
-- puro digitada pelo usuário e deve ser validada na camada
-- de aplicação ANTES de gerar o hash, não no banco.
-- ---------------------------------------------------------
CREATE TABLE usuario (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(100)  NOT NULL,
    login          VARCHAR(50)   NOT NULL UNIQUE,
    senha          VARCHAR(255)  NOT NULL, -- hash da senha (ex: BCrypt gera ~60 caracteres)
    perfil         ENUM('ADMIN', 'VENDEDOR') NOT NULL DEFAULT 'VENDEDOR',
    ativo          BOOLEAN       NOT NULL DEFAULT TRUE,
    data_cadastro  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP
);

-- ---------------------------------------------------------
-- Tabela: cliente
-- Dados do cliente. Campos como CEP/endereço podem ser
-- preenchidos automaticamente consultando uma API externa
-- (ex: ViaCEP) a partir do CEP informado.
-- ---------------------------------------------------------
CREATE TABLE cliente (
    id             INT AUTO_INCREMENT PRIMARY KEY,
    nome           VARCHAR(150)  NOT NULL,
    cpf            VARCHAR(14)   NOT NULL UNIQUE,
    email          VARCHAR(150),
    telefone       VARCHAR(20),
    cep            VARCHAR(9),
    endereco       VARCHAR(200),
    cidade         VARCHAR(100),
    uf             CHAR(2),
    data_cadastro  TIMESTAMP     DEFAULT CURRENT_TIMESTAMP
);

-- ---------------------------------------------------------
-- Tabela: produto
-- Estoque nunca pode ficar negativo (regra reforçada com
-- CHECK aqui e validada também na aplicação antes da venda).
-- ---------------------------------------------------------
CREATE TABLE produto (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    nome    VARCHAR(150)   NOT NULL,
    preco   DECIMAL(10,2)  NOT NULL,
    estoque INT            NOT NULL DEFAULT 0,
    CONSTRAINT chk_estoque_nao_negativo CHECK (estoque >= 0)
);

-- ---------------------------------------------------------
-- Tabela: forma_pagamento
-- Catálogo das formas de pagamento aceitas (Pix, cartão de
-- crédito, boleto etc.). Fica assim porque o sistema pede
-- "formas de pagamento" no plural — melhor que um texto
-- livre repetido em cada venda.
-- ---------------------------------------------------------
CREATE TABLE forma_pagamento (
    id        INT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO forma_pagamento (descricao) VALUES
    ('Cartão de crédito'),
    ('Cartão de débito'),
    ('Pix'),
    ('Boleto');

-- ---------------------------------------------------------
-- Tabela: venda
-- Cabeçalho da venda: quem comprou, quem atendeu (se houver),
-- forma de pagamento e status.
-- ---------------------------------------------------------
CREATE TABLE venda (
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id         INT            NOT NULL,
    usuario_id         INT            NULL, -- pode ser NULL se a compra for feita pelo próprio cliente, sem atendente
    forma_pagamento_id INT            NOT NULL,
    data_venda         TIMESTAMP      DEFAULT CURRENT_TIMESTAMP,
    valor_total        DECIMAL(10,2)  NOT NULL,
    status             ENUM('PENDENTE', 'APROVADA', 'CANCELADA') NOT NULL DEFAULT 'PENDENTE',
    FOREIGN KEY (cliente_id)         REFERENCES cliente(id),
    FOREIGN KEY (usuario_id)         REFERENCES usuario(id),
    FOREIGN KEY (forma_pagamento_id) REFERENCES forma_pagamento(id)
);

-- ---------------------------------------------------------
-- Tabela: item_venda
-- Um produto pode aparecer em várias vendas, e uma venda
-- pode ter vários produtos -> tabela associativa (N:N)
-- que também guarda a quantidade e o preço no momento da
-- venda (o preço do produto pode mudar depois).
-- ---------------------------------------------------------
CREATE TABLE item_venda (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    venda_id        INT           NOT NULL,
    produto_id      INT           NOT NULL,
    quantidade      INT           NOT NULL,
    preco_unitario  DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (venda_id)   REFERENCES venda(id),
    FOREIGN KEY (produto_id) REFERENCES produto(id),
    CONSTRAINT chk_quantidade_positiva CHECK (quantidade > 0)
);