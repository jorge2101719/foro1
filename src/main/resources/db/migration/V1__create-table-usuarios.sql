create table usuarios(

id bigint not null auto_increment,
nombre varchar(100) not null,
correo varchar(100) not null unique,
clave varchar(250) not null,

primary key(id)

);