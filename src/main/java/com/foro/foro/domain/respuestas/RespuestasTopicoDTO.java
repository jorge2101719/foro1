package com.foro.foro.domain.respuestas;

import java.time.LocalDateTime;

public record TopicoDTO(
        String mensaje,
        LocalDateTime fecha,
        String nombre,
        Boolean solucion
) {

    public TopicoDTO(Respuesta respuesta) {
        this(
                respuesta.getMensaje(),
                respuesta.getFecha(),
                respuesta.getUsuario().getNombre(),
                respuesta.getSolucion()
        );
    }
}
