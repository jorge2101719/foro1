create table perfil_usuario(

    id bigint not null auto_increment,
    id_usuario bigint not null,
    id_perfil not null,


    primary key(id),

    constraint fk_perfil_usuario_id_usuario foreign key(id_usuario) references usuarios(id),

    constraint fk_perfil_usuario_id_perfil foreign key(id_perfil) references perfiles(id)

);