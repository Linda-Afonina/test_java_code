-- liquibase formatted sql

-- changeset lafonina:1
CREATE TABLE wallet_table(
id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
balance DOUBLE PRECISION NOT NULL
);