package com.foro.foro.utils.security;


import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.foro.foro.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class TokenService {

    //@Value("12345678")
    @Value("${api.security.token.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("auth0")
//                    .withSubject(usuario.getCorreo())
//                    .withClaim("id", usuario.getId())
//                    .withExpiresAt(expiracion())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("No se creó el token");
        }
    }

    public String getSubject(String token) {
        DecodedJWT verifier = null;

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("foro")
                    .build()
                    .verify(token);
            verifier.getSubject();
        } catch (JWTVerificationException e) {
            System.out.println(e.getMessage());
        }
        assert verifier != null;
        if (verifier.getSubject() == null) {
            throw new RuntimeException("Verificador invalido");
        }
        return verifier.getSubject();
    }

//    private Instant expiracion() {
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }

}
