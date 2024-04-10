CREATE DATABASE feednac;

\c feednac;

CREATE TABLE curso (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    categoria INT
);

CREATE TABLE estudante (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    curso_id INT,
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso(id)
);

INSERT INTO curso (name, categoria)
VALUES ('Analise e Desenvolvimento de Sistemas', 0);

INSERT INTO curso (name, categoria)
VALUES ('Sistemas para Internet', 0);

INSERT INTO estudante (nome, curso_id)
VALUES ('João', 1);

INSERT INTO estudante (nome, curso_id)
VALUES ('Maria', 2);
