package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.Role;
import com.example.miniprojetoapiveiculosM2S09.model.Usuario;

public record UsuarioDTO(String nome, String email, Role role) {
    public UsuarioDTO(Usuario usuario){
        this(usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
