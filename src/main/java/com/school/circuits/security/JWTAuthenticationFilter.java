package com.school.circuits.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.circuits.entities.Users;
import com.school.circuits.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;
import static com.school.circuits.security.SecurityConstants.*;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;
    private com.school.circuits.repository.UsersRepository UsersRepository;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, com.school.circuits.repository.UsersRepository UsersRepository) {
        this.authenticationManager = authenticationManager;
        this.UsersRepository = UsersRepository;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            Users creds = new ObjectMapper()
                    .readValue(req.getInputStream(), Users.class);

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getNombreusuario(),
                            creds.getClave(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        ArrayList<String> authorities = new ArrayList<>();
        for (GrantedAuthority grantedAuthority : auth.getAuthorities()) {
            authorities.add(grantedAuthority.getAuthority());
        }
        String UserName = ((User) auth.getPrincipal()).getUsername();
        Users user = UsersRepository.findByNombreusuario(UserName).get();
        logger.info(user.getIdpersona());
        String token = JWT.create()
                .withSubject(((User) auth.getPrincipal()).getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .withClaim("idPersona", user.getIdpersona())
                .withClaim("correo", user.getCorreo())
                .withClaim("perfil", user.getPerfil())
                .withClaim("idUsuario",user.getIdusuario() )
                .sign(HMAC512(SECRET.getBytes()));
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        res.getWriter().write(
                "{\"" + SecurityConstants.HEADER_STRING + "\":\"" + SecurityConstants.TOKEN_PREFIX+token + "\"}"
        );
    }

}
