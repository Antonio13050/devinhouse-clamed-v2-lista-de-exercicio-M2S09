package com.example.miniprojetoapiveiculosM2S09.exception;

public class RegistroJaExistenteException extends RuntimeException {

    private String nome;
    private String identificador;

    public RegistroJaExistenteException() {
    }

    public RegistroJaExistenteException(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public RegistroJaExistenteException(String nome, Integer identificador) {
        this(nome, identificador.toString());
    }

    public RegistroJaExistenteException(String nome, Long identificador) {
        this(nome, identificador.toString());
    }

    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        return String.format("Registro '%s' já cadastrado com identificador '%s'", nome, identificador);
    }

}