package com.foro.foro.domain.usuarios;

import com.foro.foro.domain.cursos.Curso;
import com.foro.foro.domain.topicos.Topico;

public record DatosListaUsuario(
        Long id,
        String nombre
) {
    public DatosListaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNombre()
        );
    }

}
