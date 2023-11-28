package com.example.miniprojetoapiveiculosM2S09.exception;

public class RegistroNaoEncontradoException extends RuntimeException {

    private String nome;
    private String identificador;

    public RegistroNaoEncontradoException() {
    }

    public RegistroNaoEncontradoException(String nome, String identificador) {
        this.nome = nome;
        this.identificador = identificador;
    }

    public RegistroNaoEncontradoException(String nome, Integer identificador) {
        this(nome, identificador.toString());
    }

    public RegistroNaoEncontradoException(String nome, Long identificador) {
        this(nome, identificador.toString());
    }


    public String getMessage() {
        if (nome == null || identificador == null)
            return null;
        return String.format("Registro '%s' nnao encontrado com identificador '%s'", nome, identificador);
    }

}