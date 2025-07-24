package com.foro.foro.domain.perfil_usuario;

import com.foro.foro.domain.perfiles.Perfil;
import com.foro.foro.domain.perfiles.PerfilRepository;
import com.foro.foro.domain.usuarios.Usuario;
import com.foro.foro.domain.usuarios.UsuarioRepository;
import com.foro.foro.utils.errores.ErrorDeConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilUsuarioRepository usuarioPerfilRepository;

    public DatosListaPerfilUsuario agregarPerfil(DatosRegistroPerfilUsuario datosRegistroUsuarioPerfil) {

        Usuario usuario;
        Perfil perfil;

        if (usuarioRepository.findById(datosRegistroUsuarioPerfil.id_usuario()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el usuario");
        }
        if (perfilRepository.findById(datosRegistroUsuarioPerfil.id_perfil()).isEmpty()) {
            throw new ErrorDeConsulta("No se halló el perfil");
        }

        usuario = usuarioRepository.getReferenceById(datosRegistroUsuarioPerfil.id_usuario());
        perfil = perfilRepository.getReferenceById(datosRegistroUsuarioPerfil.id_usuario());

        PerfilUsuario usuarioPerfil = new PerfilUsuario(null, usuario, perfil);

        PerfilUsuario usuarioPerfil1 = usuarioPerfilRepository.save(usuarioPerfil);

        return new DatosListaPerfilUsuario(usuarioPerfil1);
    }

    public List<DatosListaPerfilUsuario> mostrarUsuarioPerfil() {
        return usuarioPerfilRepository.findAll().stream().map(DatosListaPerfilUsuario::new).toList();
    }

    public void borrarUsuarioPerfil(Long id) {
        usuarioPerfilRepository.deleteById(id);
    }
}
