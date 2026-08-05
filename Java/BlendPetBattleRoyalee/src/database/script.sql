-- =====================================================================
-- SCRIPT DE RESET E POPULAÇÃO COMPLETA DO BANCO DE DADOS (BATTLEPET)
-- =====================================================================
CREATE DATABASE battlepet;
use battlepet;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    moedas INT DEFAULT 100
);

-- 2. TABELA RACA
CREATE TABLE raca (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_raca VARCHAR(50) NOT NULL,
    descricao TEXT
);

-- 3. TABELA HABILIDADE
CREATE TABLE habilidade (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_habilidade VARCHAR(50) NOT NULL,
    descricao TEXT,
    dano_base INT NOT NULL,
    custo_energia INT DEFAULT 0
);

-- 4. TABELA RACA_HABILIDADE (Vínculo de golpes por raça)
CREATE TABLE raca_habilidade (
    raca_id INT,
    habilidade_id INT,
    nivel_desbloqueio INT DEFAULT 1,
    PRIMARY KEY (raca_id, habilidade_id),
    FOREIGN KEY (raca_id) REFERENCES raca(id) ON DELETE CASCADE,
    FOREIGN KEY (habilidade_id) REFERENCES habilidade(id) ON DELETE CASCADE
);

-- 5. TABELA PET
CREATE TABLE pet (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    nivel INT DEFAULT 1,
    experiencia INT DEFAULT 0,
    usuario_id INT,
    raca_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON DELETE SET NULL,
    FOREIGN KEY (raca_id) REFERENCES raca(id)
);

-- 6. TABELA TORNEIO
CREATE TABLE torneio (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    status ENUM('inscricoes_abertas', 'em_andamento', 'finalizado') DEFAULT 'inscricoes_abertas',
    data_inicio DATETIME DEFAULT CURRENT_TIMESTAMP,
    vencedor_torneio_id INT NULL,
    FOREIGN KEY (vencedor_torneio_id) REFERENCES pet(id)
);

-- 7. TABELA PET_TORNEIO (Inscrição dos 8 pets no torneio)
CREATE TABLE pet_torneio (
    torneio_id INT,
    pet_id INT,
    posicao_final INT NULL,
    PRIMARY KEY (torneio_id, pet_id),
    FOREIGN KEY (torneio_id) REFERENCES torneio(id) ON DELETE CASCADE,
    FOREIGN KEY (pet_id) REFERENCES pet(id) ON DELETE CASCADE
);

-- 8. TABELA BATALHA (Lutas comuns ou do Torneio)
CREATE TABLE batalha (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pet_desafiante_id INT,
    pet_oponente_id INT,
    vencedor_id INT NULL,
    status ENUM('pendente', 'em_andamento', 'finalizada') DEFAULT 'pendente',
    torneio_id INT NULL,
    fase ENUM('comum', 'quartas', 'semifinal', 'final') DEFAULT 'comum',
    data_batalha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (pet_desafiante_id) REFERENCES pet(id),
    FOREIGN KEY (pet_oponente_id) REFERENCES pet(id),
    FOREIGN KEY (vencedor_id) REFERENCES pet(id),
    FOREIGN KEY (torneio_id) REFERENCES torneio(id) ON DELETE CASCADE
);

-- 9. TABELA ITENS
CREATE TABLE itens (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_item VARCHAR(50) NOT NULL,
    descricao TEXT,
    preco INT NOT NULL,
    efeito_valor INT DEFAULT 0 -- Ex: se for poção, cura 50. Se for coleira, dá +10 de ataque.
);

-- 1. Desativa a checagem de chaves para permitir a limpeza e inserção limpa
SET FOREIGN_KEY_CHECKS = 0;

-- 2. Limpa completamente os resquícios das tentativas anteriores
TRUNCATE TABLE batalha;
TRUNCATE TABLE pet_torneio;
TRUNCATE TABLE torneio;
TRUNCATE TABLE pet;
TRUNCATE TABLE raca_habilidade;
TRUNCATE TABLE habilidade;
TRUNCATE TABLE raca;
TRUNCATE TABLE usuario;
TRUNCATE TABLE itens;

-- ==========================================
-- 3. INSERINDO OS USUÁRIOS (IDs de 1 a 8)
-- ==========================================
INSERT INTO usuario (id, nome, email, moedas) VALUES
(1, 'Lucas Silva', 'lucas@email.com', 500),
(2, 'Beatriz Santos', 'bia@email.com', 1200),
(3, 'Carlos Oliveira', 'carlos@email.com', 50),
(4, 'Mariana Costa', 'mari@email.com', 2500),
(5, 'Gabriel Souza', 'gabriel@email.com', 350),
(6, 'Amanda Lima', 'amanda@email.com', 800),
(7, 'Rafael Ribeiro', 'rafael@email.com', 150),
(8, 'Juliana Martins', 'ju@email.com', 3000);

-- ==========================================
-- 4. INSERINDO AS RAÇAS (IDs de 1 a 16)
-- ==========================================
INSERT INTO raca (id, nome_raca, descricao) VALUES
(1, 'Cachorro', 'Pet inicial equilibrado - 0 pontos'),
(2, 'Gato', 'Ágil e sorrateiro - 4 pontos'),
(3, 'Hamster', 'Pequeno e rápido - 2 pontos'),
(4, 'Cobra', 'Ataques venenosos - 5 pontos'),
(5, 'Porco', 'Muita resistência - 8 pontos'),
(6, 'Iguana', 'Pele blindada - 3 pontos'),
(7, 'Aranha', 'Teias paralisantes - 3 pontos'),
(8, 'Papagaio', 'Ataques aéreos - 2 pontos'),
(9, 'Coelho', 'Velocidade extrema - 4 pontos'),
(10, 'Cabra', 'Chifradas brutais - 6 pontos'),
(11, 'Tartaruga', 'Defesa máxima - 5 pontos'),
(12, 'Peixe', 'Lutador aquático exótico - 2 pontos'),
(13, 'Burro', 'Coices devastadores - 7 pontos'),
(14, 'Furão', 'Rápido e furtivo - 4 pontos'),
(15, 'Pato', 'Versátil na terra e água - 4 pontos'),
(16, 'Ovelha', 'Cabeçadas insistentes - 6 pontos');

-- ==========================================
-- 5. INSERINDO AS HABILIDADES (IDs de 1 a 8)
-- ==========================================
INSERT INTO habilidade (id, nome_habilidade, descricao, dano_base, custo_energia) VALUES
(1, 'Mordida Rápida', 'Um ataque veloz com os dentes.', 15, 10),
(2, 'Arranhão Profundo', 'Garras afiadas que ferem o oponente.', 18, 12),
(3, 'Bote Venenoso', 'Presas venenosas que causam grande estrago.', 25, 20),
(4, 'Super Chifrada', 'Impacto bruto frontal.', 30, 25),
(5, 'Giro de Casco', 'Ataque giratório pesado.', 20, 15),
(6, 'Coice Devastador', 'Um golpe traseiro fortíssimo.', 35, 30),
(7, 'Bicada Flamejante', 'Ataque rápido com o bico.', 12, 5),
(8, 'Teia Aprisionadora', 'Prende o oponente reduzindo sua reação.', 10, 15);

-- ==========================================
-- 6. INSERINDO OS VÍNCULOS RAÇA x HABILIDADE
-- ==========================================
INSERT INTO raca_habilidade (raca_id, habilidade_id, nivel_desbloqueio) VALUES
(1, 1, 1),  -- Cachorro -> Mordida Rápida
(2, 2, 1),  -- Gato -> Arranhão Profundo
(4, 3, 1),  -- Cobra -> Bote Venenoso
(10, 4, 1), -- Cabra -> Super Chifrada
(11, 5, 1), -- Tartaruga -> Giro de Casco
(13, 6, 1), -- Burro -> Coice Devastador
(8, 7, 1),  -- Papagaio -> Bicada
(7, 8, 1);  -- Aranha -> Teia

-- ==========================================
-- 7. INSERINDO OS PETS (IDs de 1 a 8)
-- Cada pet pertence a um usuário e uma raça existente
-- ==========================================
INSERT INTO pet (id, nome, nivel, experiencia, usuario_id, raca_id) VALUES
(1, 'Rex', 5, 450, 1, 1),       -- Cachorro do Lucas
(2, 'Mingau', 4, 300, 2, 2),    -- Gato da Beatriz
(3, 'Asmodeus', 6, 600, 3, 4),  -- Cobra do Carlos
(4, 'Pumba', 7, 800, 4, 5),     -- Porco da Mariana
(5, 'Salada', 3, 120, 5, 9),    -- Coelho do Gabriel
(6, 'Donatello', 5, 400, 6, 11),-- Tartaruga da Amanda
(7, 'Soneca', 4, 250, 7, 13),   -- Burro do Rafael
(8, 'Quack', 5, 380, 8, 15);    -- Pato da Juliana

-- ==========================================
-- 8. INSERINDO O TORNEIO (ID 1)
-- ==========================================
INSERT INTO torneio (id, nome, status, vencedor_torneio_id) VALUES
(1, 'Grande Rinha da Arena Central - Edição #1', 'em_andamento', NULL);

-- ==========================================
-- 9. INSERINDO OS PETS NO TORNEIO
-- Todos os IDs vinculados aqui (1 a 8) existem de verdade agora
-- ==========================================
INSERT INTO pet_torneio (torneio_id, pet_id, posicao_final) VALUES
(1, 1, NULL),
(1, 2, NULL),
(1, 3, NULL),
(1, 4, NULL),
(1, 5, NULL),
(1, 6, NULL),
(1, 7, NULL),
(1, 8, NULL);

-- ==========================================
-- 10. INSERINDO AS BATALHAS DO TORNEIO
-- ==========================================
INSERT INTO batalha (pet_desafiante_id, pet_oponente_id, vencedor_id, status, torneio_id, fase) VALUES
(1, 2, 1, 'finalizada', 1, 'quartas'),
(3, 4, 4, 'finalizada', 1, 'quartas'),
(5, 6, NULL, 'em_andamento', 1, 'quartas'),
(7, 8, NULL, 'pendente', 1, 'quartas');

-- ==========================================
-- 11. INSERINDO OS ITENS (LOJA DE POÇÕES)
-- ==========================================
INSERT INTO itens (id, nome_item, descricao, preco, efeito_valor) VALUES
(1, 'Poção de Cura P', 'Cura instantaneamente 30 de Vida do pet.', 50, 30),
(2, 'Poção de Cura G', 'Cura instantaneamente 80 de Vida do pet.', 120, 80),
(3, 'Elixir de Força', 'Aumenta temporariamente o ataque em +15 na rinha.', 150, 15),
(4, 'Suco de Velocidade', 'Garante +20 de velocidade no primeiro turno.', 100, 20),
(5, 'Tônico de Energia', 'Restaura 40 de estamina/energia para usar habilidades.', 75, 40);

-- 12. Reativa a segurança das chaves estrangeiras para o uso normal do sistema
SET FOREIGN_KEY_CHECKS = 1;
