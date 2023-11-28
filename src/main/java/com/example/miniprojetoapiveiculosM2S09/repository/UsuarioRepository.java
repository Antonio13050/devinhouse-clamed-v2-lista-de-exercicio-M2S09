package com.example.miniprojetoapiveiculosM2S09.repository;

import com.example.miniprojetoapiveiculosM2S09.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    boolean existsByEmail(String email);
}
