create table cursos(

    id bigint not null auto_incremente,
    nombre varchar(100) not null unique,
    categoria varchar(100) not null,

    primary key(id)


);