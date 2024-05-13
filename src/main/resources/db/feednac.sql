CREATE DATABASE feednac;

\c feednac;

CREATE TABLE curso (
    cur_id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    categoria INT
);

CREATE TABLE turma (
    tur_id SERIAL PRIMARY KEY,
    nome VARCHAR(25)
);

CREATE TABLE estudante (
    est_id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    email  VARCHAR(255),
    status BOOLEAN default true,
    data_nascimento VARCHAR(10),
    telefone VARCHAR(13),
    curso_id INT,
    turma_id INT,
    CONSTRAINT fk_curso FOREIGN KEY (curso_id) REFERENCES curso(cur_id),
    CONSTRAINT fk_turma FOREIGN KEY (turma_id) REFERENCES turma(tur_id)
);

CREATE TABLE professor (
    prf_id SERIAL PRIMARY KEY,
    nome VARCHAR(255),
    usuario VARCHAR(20),
    email  VARCHAR(255),
    senha VARCHAR(30),
    telefone VARCHAR(13)
);

CREATE TABLE disciplina (
    dsp_id SERIAL PRIMARY KEY,
    nome varchar(100),
    professor_id INT,
    CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professor(prf_id)
);

CREATE TABLE aula (
    aul_id SERIAL PRIMARY KEY,
    disciplina_id INT,
    turma_id INT,
    duracao VARCHAR(20),
    hora_inicio VARCHAR(20),
    hora_fim VARCHAR(20),
    andar INTEGER,
    sala INTEGER,
    CONSTRAINT fk_disciplina FOREIGN KEY (disciplina_id) REFERENCES disciplina(dsp_id),
    CONSTRAINT fk_turma FOREIGN KEY (turma_id) REFERENCES turma(tur_id)
);

CREATE TABLE cronograma_diario (
    crd_id SERIAL PRIMARY KEY,
    dia_semana INT,
    aula_id INT,
    CONSTRAINT fk_aula FOREIGN KEY (aula_id) REFERENCES aula(aul_id)
);

CREATE TABLE cronogramadiario_estudante (
    cronogramadiario_estudante_id SERIAL PRIMARY KEY,
    cronograma_diario_id INT,
    semestre VARCHAR(30),
    estudante_id INT,
    CONSTRAINT fk_cronograma_diario FOREIGN KEY (cronograma_diario_id) REFERENCES cronograma_diario(crd_id),
    CONSTRAINT fk_estudante_id FOREIGN KEY (estudante_id) REFERENCES estudante(est_id),
    CONSTRAINT cronogramadiario_estudante_unique UNIQUE (cronograma_diario_id, estudante_id)
);


--- INSERT CURSO ---
INSERT INTO curso (nome, categoria) VALUES
('Analise e Desenvolvimento de Sistemas', 0),
('Sistemas para Internet', 0);


--- INSERT TURMA ---
INSERT INTO turma (nome) VALUES
('ADS4N24/1'), ('ADS5M24/1');


--- INSERT ESTUDANTE ---
INSERT INTO estudante (nome, email, status, data_nascimento, telefone, curso_id, turma_id) VALUES
('João', 'joao@gmail.com', true, '10/12/2000', '51985063945', 1, 1),
('Maria', 'maria@gmail.com', true, '03/05/2001', '51957430684', 2, 2);


--- INSERT PROFESSOR ---
INSERT INTO professor (nome, email, usuario, senha, telefone) VALUES
('Alberto', 'alberto@gmail.com', 'alberto', 'senha', '4328472384'),
('Beatriz', 'beatriz@gmail.com', 'beatriz', 'senha', '9876543210'),
('Carlos', 'carlos@gmail.com', 'carlos', 'senha', '1234567890');


--- INSERT DISCIPLINA ---
INSERT INTO disciplina (nome, professor_id) VALUES
('Computacao em nuvem', 1), -- Alberto
('Logica de programacao', 2), -- Beatriz
('Sistemas distribuidos', 3); -- Carlos


--- INSERT AULA ---
INSERT INTO aula (disciplina_id, turma_id, duracao, andar, sala, hora_inicio, hora_fim) VALUES
(1, 1, '3 horas', 1, 103, '19:00', '22:00'), -- Computacao em nuvem, ADS4N24/1
(1, 2, '3 horas', 2, 202, '09:00', '12:00'), -- Computacao em nuvem, ADS5N24/1
(2, 1, '3 horas', 3, 301, '19:00', '22:00'), -- Logica de programacao, ADS4N24/1
(2, 2, '3 horas', 4, 405, '09:00', '12:00'), -- Logica de programacao, ADS5N24/1
(3, 1, '3 horas', 5, 502, '19:00', '22:00'), -- Sistemas distribuidos, ADS4N24/1
(3, 2, '3 horas', 6, 607, '09:00', '12:00'); -- Sistemas distribuidos, ADS5N24/1


--- INSERT CRONOGRAMA DIARIO ---
INSERT INTO cronograma_diario(dia_semana, aula_id) VALUES
(0, 1), --- Segunda, Computacao nuvem -- Alberto
(1, 3), --- Terca, Logica de programacao -- Beatriz
(2, 5), --- Quarta, Sistemas distribuidos -- Carlos
(1, 2), --- Terca,  Computacao em nuvem -- Alberto
(3, 4), --- Quinta, Logica de programacao -- Beatriz
(4, 6); --- Sexta, Sistemas distribuidos -- Alberto


--- INSERT CRONOGRAMA DIARIO ESTUDANTE ---
INSERT INTO cronogramadiario_estudante(cronograma_diario_id, estudante_id, semestre) VALUES
(1 , 1, '4'), --- Segunda, Computacao nuvem -- Alberto -- JOAO
(2 , 1, '4'), --- Terca, Logica de programacao -- Beatriz -- JOAO
(3 , 1, '4'), --- Quarta, Sistemas distribuidos -- Carlos -- JOAO
(4 , 2, '5'), --- Terca,  Computacao em nuvem -- Alberto -- MARIA
(5 , 2, '5'), --- Quinta, Logica de programacao -- Beatriz -- MARIA
(6 , 2, '5'); --- Sexta, Sistemas distribuidos -- Carlos -- MARIA