package com.example.miniprojetoapiveiculosM2S09.model.transport;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class AutenticacaoRequest {

    @NotEmpty(message = "{required.field}")
    @Email(message = "{invalid.field}")
    private String email;

    @NotEmpty(message = "{required.field}")
    private String senha;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
