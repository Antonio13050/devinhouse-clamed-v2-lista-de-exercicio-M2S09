package com.example.miniprojetoapiveiculosM2S09.service;

import com.example.miniprojetoapiveiculosM2S09.exception.AutenticacaoFalhaException;
import com.example.miniprojetoapiveiculosM2S09.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String autenticar(String email, String password) {
        try {
            // The authentication manager provides secure authentication and throws exception if it fails
            var authToken = new UsernamePasswordAuthenticationToken(email, password);
            Authentication authenticate = authenticationManager.authenticate(authToken);
            var usuario  = (Usuario) authenticate.getPrincipal();
            String token = tokenService.gerarToken(usuario);
            return token;
        } catch (AuthenticationException e) {
            throw new AutenticacaoFalhaException("Invalid User or Password");
        }
    }
}
