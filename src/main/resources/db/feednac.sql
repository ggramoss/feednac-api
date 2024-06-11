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

CREATE TABLE feedback (
    fdb_id SERIAL PRIMARY KEY,
    aula_id INT,
    data DATE,
    nota_geral INT,
    comentario_adicional TEXT,
    CONSTRAINT fk_aula_id FOREIGN KEY (aula_id) REFERENCES aula(aul_id)
);

CREATE TABLE pergunta (
  per_id SERIAL PRIMARY KEY,
  valor TEXT
);

CREATE TABLE opcao_resposta (
    opr_id SERIAL PRIMARY KEY,
    pergunta_id INT,
    valor TEXT,
    CONSTRAINT fk_pergunta_id FOREIGN KEY (pergunta_id) REFERENCES pergunta(per_id)
);

CREATE TABLE resposta_pergunta (
  rsp_id SERIAL PRIMARY KEY,
  feedback_id INT,
  pergunta_id INT,
  opcao_id INT,
  CONSTRAINT fk_feedback_id FOREIGN KEY (feedback_id) REFERENCES feedback(fdb_id),
  CONSTRAINT fk_pergunta_id FOREIGN KEY (pergunta_id) REFERENCES pergunta(per_id),
  CONSTRAINT fk_opcao_id FOREIGN KEY (opcao_id) REFERENCES opcao_resposta(opr_id)
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


--- INSERT QUESTAO ---
INSERT INTO pergunta(valor) VALUES
('Você achou o conteúdo apresentado durante a aula claro e compreensível?'),
('Em uma escala de 1 a 5, quão satisfeito você está com a aula em geral?'),
('A aula conseguiu manter seu interesse pelo assunto?'),
('Como você classificaria a qualidade geral da aula?'),
('Você sente que aprendeu algo novo durante esta aula?');


--- INSERT ALTERNATIVA RESPOSTA ---
INSERT INTO opcao_resposta(pergunta_id, valor) VALUES
(1, 'Sim, o conteúdo foi muito claro e compreensível'), -- 1
(1, 'Sim, na maior parte do tempo, mas alguns pontos poderiam ser melhor explicados'), -- 2
(1, 'Alguns trechos foram claros, mas outros foram um pouco confusos'), -- 3
(1, 'Não, achei o conteúdo difícil de seguir em várias partes'), -- 4
(1, 'Não, o conteúdo foi confuso e pouco compreensível'), -- 5
(2, '5 (muito satisfeito) - A aula atendeu todas as minhas expectativas'), -- 6
(2, '4 (satisfeito) - A aula foi boa, mas há espaço para melhorias.'), -- 7
(2, '3 (neutro) - A aula foi mediana, nem boa nem ruim'), -- 8
(2, '2 (pouco satisfeito) - A aula deixou a desejar em vários aspectos'), -- 9
(2, '1 (muito insatisfeito) - A aula não atendeu minhas expectativas'), -- 10
(3, 'Sim, a aula foi muito interessante e manteve meu interesse o tempo todo.'), -- 11
(3, 'Sim, a maior parte da aula conseguiu manter meu interesse.'), -- 12
(3, 'Parcialmente, alguns momentos foram interessantes, mas outros foram entediantes.'), -- 13
(3, 'Não muito, a aula teve várias partes monótonas.'), -- 14
(3, 'Não, a aula não conseguiu manter meu interesse.'), -- 15
(4, 'Excelente - A aula foi muito bem estruturada e apresentada.'), -- 16
(4, 'Boa - A qualidade da aula foi boa, mas pode melhorar.'), -- 17
(4, 'Regular - A qualidade da aula foi mediana, com pontos altos e baixos.'), -- 18
(4, 'Ruim - A qualidade da aula deixou a desejar.'), -- 19
(4, 'Péssima - A qualidade da aula foi muito baixa.'), -- 20
(5, 'Sim, aprendi muitas coisas novas que serão úteis.'), -- 21
(5, 'Sim, aprendi algumas coisas novas que eu não conhecia.'), -- 22
(5, 'Aprendi poucas coisas novas, a maioria do conteúdo já era familiar'), -- 23
(5, 'Não muito, já conhecia a maior parte do conteúdo.'), -- 24
(5, 'Não, não aprendi nada de novo nesta aula.'); -- 25


--- INSERT FEEDBACK ---
INSERT INTO feedback(aula_id, data, nota_geral, comentario_adicional) VALUES
(1, '03/06/2024', 9, 'Muito boa aula!'),
(3, '04/06/2024', 7, 'Explicaçao boa no geral');


--- INSERT RESPOSTAS ---
INSERT INTO resposta_pergunta(feedback_id, pergunta_id, opcao_id) VALUES
(1, 1, 1),
(1, 2, 7),
(1, 3, 11),
(1, 4, 16),
(1, 5, 22),
(2, 1, 3),
(2, 2, 8),
(2, 3, 14),
(2, 4, 18),
(2, 5, 25);