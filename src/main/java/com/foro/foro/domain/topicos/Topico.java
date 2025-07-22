package com.foro.foro.domain.topicos;


import com.foro.foro.domain.cursos.Curso;
import com.foro.foro.domain.respuestas.Respuesta;
import com.foro.foro.domain.usuarios.Usuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;

    private Usuario usuario;

    private Curso curso;

    private List<Respuesta> respuestaList;

    public Topico(@Valid DatosRegistroTopico datosRegistroTopico) {
    }

    public void actualizarTopico(@Valid DatosActualizarTopico datos) {
        boolean check = false;

        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
            check = true;
        }

        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
            check = true;
        }

        if (check) {
            this.fecha = LocalDateTime.now();
        }
    }

    public void desativaTopico() {
        this.status = false;
    }

    public void agregarRespuesta(Respuesta respuesta) {
        respuestaList.add(respuesta);
    }



}
