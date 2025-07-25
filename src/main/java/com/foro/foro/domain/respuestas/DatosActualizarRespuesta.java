package com.foro.foro.domain.respuestas;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
        @NotNull Long id,
        String mensaje,
        Boolean solucion
) {
}
