 create sequence hibernate_sequence start 1 increment 1;

create table comment (
    id int8 not null,
    comment_date timestamp,
    text varchar(2048) not null,
    user_id int8,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
 );

create table usr (
    id int8 not null,
    active boolean not null,
    name varchar(255) not null,
    passport_data varchar(255) not null,
    password varchar(255) not null,
    surname varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

alter table if exists comment
    add constraint comment_user_fk
    foreign key (user_id) references usr;

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;
