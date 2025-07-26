package com.foro.foro.domain.cursos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cursos")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre_curso;
    private String categoria;

    public Curso(DatosRegistroCurso datosRegistroCurso) {
        this.nombre_curso = datosRegistroCurso.nombre();
        this.categoria = datosRegistroCurso.categoria();
    }

    public void actualizarCurso(DatosActualizarCurso datosActualizarCurso) {
        if (datosActualizarCurso.nombre() != null) {
            this.nombre_curso = datosActualizarCurso.nombre();
        }

        if (datosActualizarCurso.categoria() != null) {
            this.categoria = datosActualizarCurso.categoria();
        }
    }

}
