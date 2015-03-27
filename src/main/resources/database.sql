DROP DATABASE  IF EXISTS employees;
CREATE DATABASE employees;
USE employees;
CREATE table engineers (id int not null auto_increment,
                        firstName varchar(30) not null,
                        lastName varchar(30),
                        email varchar(30),
                        primary key (id));
