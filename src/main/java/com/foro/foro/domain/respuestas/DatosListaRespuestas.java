package com.foro.foro.domain.respuestas;

import java.time.LocalDateTime;

public record DatosListaRespuestas(
        Long id,
        String mensaje,
        String nombreTopico,
        LocalDateTime fecha,
        String nombreUsuario,
        Boolean solucion
) {

    public DatosListaRespuestas(Respuesta respuesta) {
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getTopico().getTitulo(),
                respuesta.getFecha(),
                respuesta.getUsuario().getNombre(),
                respuesta.getSolucion()
        );
    }
}
