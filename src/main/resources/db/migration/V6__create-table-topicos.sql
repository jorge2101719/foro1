create table topicos(

    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    mensaje varchar(500) not null,
    fecha date not null,
    status tinyint not null,
    id_usuario bigint not null,
    id_curso bigint not null,
    respuestas int,

    primary key(id),

    constraint fk_topicos_id_usuario foreign key(id_usuario) references usuarios(id),

    constraint fk_topicos_id_id_curso foreign key(id_curso) references cursos(id)





);