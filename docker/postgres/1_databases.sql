CREATE ROLE demo_admin LOGIN
    PASSWORD 'demo_admin'
    SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION;

CREATE DATABASE demo
    WITH OWNER = demo_admin
    ENCODING = 'UTF-8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

\connect demo demo_admin;
CREATE SCHEMA dev;

ALTER ROLE demo_admin IN DATABASE demo SET search_path = dev, public;