package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.Role;

public class CriarUsuarioDTO{
    private String nome;
    private String email;
    private String senha;
    private Role role;

    public CriarUsuarioDTO() {
    }

    public CriarUsuarioDTO(String nome, String email, String senha, Role role) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
