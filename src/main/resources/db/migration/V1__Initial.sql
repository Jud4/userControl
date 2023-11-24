-- create user table
create table user_table (
                    id         bigint not null,
                    username   varchar(150) not null,
                    password   varchar(150) not null,
                    email      varchar(150) not null,
                    created_at timestamp,
                    primary key (id)
);
-- create a sequence for user table
create sequence user_seq as bigint increment 1;

-- create user_detail table
create table user_detail (
                         id bigint not null,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         age integer,
                         birth_day date,
                         user_id bigint,
                         primary key (id)
);
-- relation between user and user_detail
alter table user_detail add constraint FK_User_detail_RefUser foreign key (user_id)
    references user_table (id) on delete restrict on update restrict;

-- create a sequence for user_detail table
create sequence user_detail_seq as bigint increment 1;

-- create rol table
create table rol (
                      id integer not null,
                      name varchar(100) not null,
                      primary key (id)
);

-- create a sequence for rol table
create sequence rol_seq as integer increment 1;

-- create user_rol table
create table user_rol (
                      id integer not null,
                      active boolean not null,
                      created_at timestamp not null,
                      user_id bigint,
                      rol_id integer,
                      primary key (id)
);

-- create a sequence for user table
create sequence user_rol_seq as integer increment 1;

-- relation many to many
alter table user_rol add constraint FK_User_rol_RefUser foreign key (user_id)
    references user_table (id) on delete restrict on update restrict;

alter table user_rol add constraint FK_User_rol_RefRol foreign key (rol_id)
    references "rol" (id) on delete restrict on update restrict;