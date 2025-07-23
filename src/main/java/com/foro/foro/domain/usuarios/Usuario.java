package com.foro.foro.domain.usuarios;

import com.foro.foro.domain.perfiles.Perfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String correo;
    private String clave;
    //private Boolean admin = false;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "perfil_usuario",
            joinColumns = @JoinColumn(name = "id_usuario"),
        inverseJoinColumns = @JoinColumn(name = "id_perfil")
    )
    private Set<Perfil> perfiles = new HashSet<>();

    public Usuario(DatosRegistroUsuario datos) {
        this.id = null;
        this.nombre = datos.nombre();
        this.correo = datos.correo();
        this.clave = datos.clave();
        //this.admin = datos.admin();
    }

    public void actualizarUsuario(DatosActualizarUsuario datos) {
        if (datos.nombre() != null) {
            this.nombre = datos.nombre();
        }

        if (datos.correo() != null) {
            this.correo = datos.correo();
        }

        if (datos.clave() != null) {
            this.clave = datos.clave();
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles.stream().map(p -> new SimpleGrantedAuthority(p.getNombre())).toList();
    }

    @Override
    public String getPassword() {
        return clave;
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
