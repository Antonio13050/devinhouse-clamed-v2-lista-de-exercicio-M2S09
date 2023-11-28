package com.example.miniprojetoapiveiculosM2S09.exception;

import org.springframework.security.core.AuthenticationException;

public class AutenticacaoFalhaException extends AuthenticationException {
    public AutenticacaoFalhaException(String msg) {
        super(msg);
    }
}
