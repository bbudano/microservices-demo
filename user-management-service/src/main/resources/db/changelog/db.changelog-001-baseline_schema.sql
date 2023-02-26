--liquibase formatted sql

--changeset generated:baseline_schema
create sequence dev.users_id_seq start with 10 increment by 10;

    create table dev.users (
       id bigint not null,
        email varchar(255) not null,
        password varchar(255) not null,
        role varchar(255) not null,
        status varchar(255) not null,
        primary key (id)
    );

    alter table if exists dev.users
       add constraint user_email_unique unique (email);
