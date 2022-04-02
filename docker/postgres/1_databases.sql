-- Create admin

CREATE ROLE exchange_admin LOGIN
    PASSWORD 'exchange_admin'
    SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

-- Create database

CREATE DATABASE exchange
    WITH OWNER = exchange_admin
    ENCODING = 'UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Create user

CREATE USER exchange_user WITH PASSWORD 'exchange_user' NOSUPERUSER;