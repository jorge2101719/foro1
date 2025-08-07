package com.foro.foro.domain.cursos;

import jakarta.validation.constraints.NotNull;

public record DatosListaCurso(
        @NotNull Long id,
        String nombre,
        String categoria
) {
    public DatosListaCurso(Curso curso) {
        this(
                curso.getId(),
                curso.getNombre(),
                curso.getCategoria()
        );
    }
}
