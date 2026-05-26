create database todolist;
use todolist;

create table tarefas(
id int auto_increment primary key,
titulo_tarefa varchar(200) not null,
concluida TINYINT(1) DEFAULT 0,
data_hora datetime DEFAULT CURRENT_TIMESTAMP
);