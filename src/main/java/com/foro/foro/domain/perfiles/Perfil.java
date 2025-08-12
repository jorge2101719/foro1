package com.foro.foro.domain.perfiles;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Perfil(DatosRegistroPerfil datosRegistroPerfil) {
        this.nombre = datosRegistroPerfil.nombre();
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    //public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String getAuthority() {
        return nombre;
    }


}
