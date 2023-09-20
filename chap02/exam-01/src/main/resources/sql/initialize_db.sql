DROP TABLE IF EXISTS t_user CASCADE;

CREATE TABLE IF NOT EXISTS t_user
(
    username VARCHAR(255) PRIMARY KEY,
    password VARCHAR(255)
);

-- mklinkj: 1234
INSERT INTO t_user (username, password)
VALUES ('mklinkj', '{bcrypt}$2a$10$xFdUr/HxR8HanLrJaGq7xuKKGoQcN5.hgxoeyQwg9yxjiId5/4nAm');

-- NTT DATA: 4321
INSERT INTO t_user (username, password)
VALUES ('NTT DATA', '{bcrypt}$2a$10$5mrk1eQ8OJ06XMwDb76QH.8d8RdKtcDBphgYOvdUTH1.oayvjf8ny');