
CREATE SCHEMA IF NOT EXISTS test;

CREATE TABLE IF NOT EXISTS test.category
(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR,
    dt_criation TIMESTAMP,
    dt_modification TIMESTAMP,
    deleted BOOL
);

CREATE TABLE IF NOT EXISTS test.product
(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL,
    description VARCHAR,
    dt_criation TIMESTAMP,
    dt_modification TIMESTAMP,
    deleted BOOL,
    id_category UUID,
    CONSTRAINT fk_category FOREIGN KEY(id_category) REFERENCES test.category(id)
);
