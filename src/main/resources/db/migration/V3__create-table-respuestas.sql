create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(1000) not null,
    topico_id bigint not null,
    fecha datetime not null,
    id_usuario bigint not null,
    solucion tinyint,

    primary key(id),

    constraint fk_respuestas_topico_id foreign key(topico_id) references topico(id),

    constraint fk_respuestas_id_id_usuario foreign key(id_usuario) references usuario(id)


);