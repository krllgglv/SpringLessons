create table users (
  id                    bigserial,
  username              varchar(30) not null unique,
  password              varchar(80) not null,
  score                 int not null,
  primary key (id)
);

create table roles (
  id                    serial,
  name                  varchar(50) not null,
  primary key (id)
);

CREATE TABLE users_roles (
  user_id               bigint not null,
  role_id               int not null,
  primary key (user_id, role_id),
  foreign key (user_id) references users (id),
  foreign key (role_id) references roles (id)
);

insert into roles (name)
values
('ROLE_USER'), ('ROLE_ADMIN');

insert into users (username, password, score)
values
('user', '$2y$12$R4rBfX5HvZmJVe9gZKOfA.4HjuF3ds./qQrYKfz1dG6RJH/yaX2zm', 1),
('user1', '$2y$12$Ce7oWPikVyZnlHxjn0/zxuo/MkF3z2.F6cKstIXWRwFkHL5TEAkTm ', 2);

insert into users_roles (user_id, role_id)
values
(1, 1),
(1, 2);