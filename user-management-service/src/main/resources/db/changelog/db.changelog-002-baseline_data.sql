--liquibase formatted sql

--changeset bernard:baseline_data
insert into users (id, email, password, role, status)
values (1, 'admin@demo.hr', '$2a$10$OeqIRToiX1kNjs7jPnhLdOtjjFoaCrH6MH8rwsiAade3kIoW87f8C', 'ROLE_ADMIN', 'ACTIVE');
insert into users (id, email, password, role, status)
values (2, 'user@demo.hr', '$2a$10$f8rJW2f4P81VZTSOCwyUsujTsT7qz97heRb3b1AAWhwjUxollaurW', 'ROLE_USER', 'ACTIVE');
