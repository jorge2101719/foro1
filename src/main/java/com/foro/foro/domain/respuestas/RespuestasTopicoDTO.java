package com.foro.foro.domain.respuestas;

import java.time.LocalDateTime;

public record RespuestasTopicoDTO(
        String mensaje,
        LocalDateTime fecha,
        String nombre,
        Boolean solucion
) {

    public RespuestasTopicoDTO(Respuesta respuesta) {
        this(
                respuesta.getMensaje(),
                respuesta.getFecha(),
                respuesta.getAutor().getNombre(),
                respuesta.getSolucion()
        );
    }
}
