package com.foro.foro.controller;


import com.foro.foro.domain.usuarios.DatosAutenticacionUsuario;
import com.foro.foro.domain.usuarios.Usuario;
import com.foro.foro.utils.security.DatosJWTToken;
import com.foro.foro.utils.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity autenticacion(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
        //var token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.clave());
        Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.correo(), datosAutenticacionUsuario.clave());
        var auntenticado = manager.authenticate(token);
        var jwtToken = tokenService.generarToken((Usuario) auntenticado.getPrincipal());

        return ResponseEntity.ok(new DatosJWTToken(jwtToken));
    }


}
