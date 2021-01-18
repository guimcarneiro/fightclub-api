CREATE SCHEMA fightclub;

SET search_path TO fightclub;

CREATE TABLE wrestler (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    birth_date DATE,
    description VARCHAR(255),
    nacionality VARCHAR(50),
    avatar BYTEA,
    height INTEGER,
    category_id VARCHAR(60),
    num_wins INTEGER,
    num_losses INTEGER,
    created_at TIMESTAMP,
    skill_id INTEGER
);

CREATE TABLE skill (
    id SERIAL PRIMARY KEY,
    agility INTEGER,
    force INTEGER,
    nervousness INTEGER,
    technique INTEGER,
    endurance INTEGER
);

CREATE TABLE fight (
    id SERIAL PRIMARY KEY,
    category_id VARCHAR(60),
    winner_id INTEGER,
    loser_id INTEGER,
    happened_at TIMESTAMP
);

CREATE TABLE category (
    name VARCHAR(60) PRIMARY KEY,
    description VARCHAR(255)
);

ALTER TABLE wrestler
    ADD CONSTRAINT FK_wrestler_skill_id FOREIGN KEY (skill_id)
    REFERENCES skill(id);

ALTER TABLE wrestler
    ADD CONSTRAINT FK_wrestler_category_id FOREIGN KEY (category_id)
    REFERENCES category(name);

ALTER TABLE fight
    ADD CONSTRAINT FK_fight_category_id FOREIGN KEY (category_id)
    REFERENCES category(name);

ALTER TABLE fight
    ADD CONSTRAINT FK_fight_winner_id FOREIGN KEY (winner_id)
    REFERENCES wrestler(id);

ALTER TABLE fight
    ADD CONSTRAINT FK_fight_loser_id FOREIGN KEY (loser_id)
    REFERENCES wrestler(id);
