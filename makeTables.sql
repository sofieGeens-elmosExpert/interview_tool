DROP TABLE IF EXISTS interview_has_questions;
DROP TABLE IF EXISTS interview;
DROP TABLE IF EXISTS example_answer;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS recruiter;
DROP TABLE IF EXISTS candidate;

CREATE TABLE candidate (
    id int,
    lastname VARCHAR,
    firstname VARCHAR,
    email VARCHAR,
    role char,
    PRIMARY KEY(id)
);

CREATE TABLE recruiter (
    id int,
    lastname VARCHAR,
    firstname VARCHAR,
    email VARCHAR,
    password VARCHAR,
    PRIMARY KEY(id)
);

CREATE TABLE question (
    id int,
    category char,
    question_type char,
    answer_type char,
    role char,
    question VARCHAR,
    PRIMARY KEY(id)
);

CREATE TABLE example_answer (
    id int,
    question_id int,
    answer VARCHAR,
    PRIMARY KEY(id),
    CONSTRAINT fk_question_answer FOREIGN KEY (question_id) REFERENCES question(id)
);

CREATE TABLE interview (
    id int,
    recruiter_id int,
    candidate_id int,
    day date,
    startime time,
    PRIMARY KEY(id),
    CONSTRAINT fk_interview_candidate FOREIGN KEY (candidate_id) REFERENCES candidate(id),
    CONSTRAINT fk_interview_recruiter FOREIGN KEY (recruiter_id) REFERENCES recruiter(id)
);

CREATE TABLE interview_has_questions (
    id int,
    interview_id int,
    question_id int,
    rating VARCHAR,
    PRIMARY KEY(id),
    CONSTRAINT fk_has_question_interview FOREIGN KEY (interview_id) REFERENCES interview(id),
    CONSTRAINT fk_has_question_question FOREIGN KEY (question_id) REFERENCES question(id)
);