package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.Role;
import com.example.miniprojetoapiveiculosM2S09.model.Usuario;

public record DetalhesUsuarioDTO(Integer id, String nome, String email, Role role) {
    public DetalhesUsuarioDTO(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
    }
}
