DROP TABLE IF EXISTS interview_has_questions;
DROP TABLE IF EXISTS interview;
DROP TABLE IF EXISTS example_answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS person;
DROP TABLE IF EXISTS candidate;

CREATE TABLE candidate (
    id int,
    lastname VARCHAR(20),
    firstname VARCHAR(20),
    email VARCHAR(40),
    role char,
    active BIT(1),
    PRIMARY KEY(id)
);

CREATE TABLE person (
    id int,
    lastname VARCHAR(20),
    firstname VARCHAR(20),
    email VARCHAR(40),
    password VARCHAR(50),
    role char,
    active BIT(1),
    PRIMARY KEY(id)
);

CREATE TABLE question (
    id int,
    category char,
    question_type char,
    answer_type char,
    role char,
    question VARCHAR(255),
    active BIT(1),
    PRIMARY KEY(id),
    CONSTRAINT fk_question_language FOREIGN KEY (language_id) REFERENCES language(id),
);

CREATE TABLE example_answer (
    id int,
    question_id int,
    answer VARCHAR(255),
    active BIT(1),
    PRIMARY KEY(id),
    CONSTRAINT fk_question_answer FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE interview (
    id int,
    person_id int,
    candidate_id int,
    day date,
    startime time,
    PRIMARY KEY(id),
    CONSTRAINT fk_interview_candidate FOREIGN KEY (candidate_id) REFERENCES candidate(id),
    CONSTRAINT fk_interview_person FOREIGN KEY (person_id) REFERENCES person(id)
);

CREATE TABLE interview_has_questions (
    id int,
    interview_id int,
    question_id int,
    rating VARCHAR(255),
    PRIMARY KEY(id),
    CONSTRAINT fk_has_question_interview FOREIGN KEY (interview_id) REFERENCES interview(id),
    CONSTRAINT fk_has_question_question FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE language (
    id int,
    language VARCHAR(25),
    PRIMARY KEY(id)
);

INSERT INTO interview_tool.dbo.candidate(id, lastname, firstname, email, role, active) VALUES (1,'John', 'Doe','john@doe.com','j',1);
INSERT INTO interview_tool.dbo.language(id, language) VALUES (1, 'Java EE'), (2, 'Elixir'), (3, 'C++'), (4, 'C#'), (5, 'Dart & Flutter'), (6, 'Python'), (7, 'JavaScript'), (8, 'Assembly');
