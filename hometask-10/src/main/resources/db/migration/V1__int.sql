
create TABLE categories (id bigserial primary key, name varchar (255));
insert into categories (name) values
('Category1'),
('Category2'),
('Category3')
;

create TABLE products (id bigserial primary key, name varchar (255), price int, id_category bigint references categories(id) );
insert into products (name, price, id_category) values
('Product1', 1, 1),
('Product2', 2, 2),
('Product3', 3, 3),
('Product4', 4, 1),
('Product5', 5, 2),
('Product6', 6, 3),
('Product7', 7, 1),
('Product8', 8, 2),
('Product9', 9, 3),
('Product10', 10, 1),
('Product11', 11, 2),
('Product12', 12, 3),
('Product13', 13, 1)
;

