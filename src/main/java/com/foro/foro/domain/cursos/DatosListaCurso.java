package com.foro.foro.domain.cursos;

import jakarta.validation.constraints.NotNull;

public record DatosListadoCurso(
        @NotNull Long id,
        String nombre,
        String categoria
) {
}
