CREATE DATABASE IF NOT EXISTS BlendLivrary;

USE BlendLivrary;

CREATE TABLE IF NOT EXISTS Livro(
	id INT auto_increment PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    tipo ENUM('FISICO', 'DIGITAL')
);