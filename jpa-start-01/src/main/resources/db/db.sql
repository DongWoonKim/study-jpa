show databases;

CREATE DATABASE jpa_basic;
USE jpa_basic;

CREATE TABLE member (
    id VARCHAR(255) PRIMARY KEY NOT NULL,
    NAME VARCHAR(255),
    AGE INTEGER
);

SELECT * FROM member;