CREATE TABLE products
(
    id    bigserial primary key,
    name  varchar(255),
    price int
);
INSERT INTO products (name, price)
VALUES ('Bread1', 25),
       ('Bread2', 26),
       ('Bread3', 27),
       ('Bread4', 28),
       ('Bread5', 29),
       ('Cheese1', 32),
       ('Cheese2', 33),
       ('Cheese3', 34),
       ('Cheese4', 35),
       ('Cheese5', 36),
       ('Water1', 21),
       ('Water2', 23),
       ('Water3', 25),
       ('Water4', 10),
       ('Water5', 2),
       ('Milk1', 38),
       ('Milk2', 40),
       ('Milk3', 25),
       ('Milk4', 60),
       ('Coca-Cola', 85);