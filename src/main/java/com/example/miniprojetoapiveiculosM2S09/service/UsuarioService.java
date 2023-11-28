package com.example.miniprojetoapiveiculosM2S09.service;

import com.example.miniprojetoapiveiculosM2S09.exception.RegistroJaExistenteException;
import com.example.miniprojetoapiveiculosM2S09.model.Usuario;
import com.example.miniprojetoapiveiculosM2S09.model.transport.CriarUsuarioDTO;
import com.example.miniprojetoapiveiculosM2S09.model.transport.DetalhesUsuarioDTO;
import com.example.miniprojetoapiveiculosM2S09.model.transport.UsuarioDTO;
import com.example.miniprojetoapiveiculosM2S09.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<DetalhesUsuarioDTO> listAll(){
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return usuarios.stream().map(DetalhesUsuarioDTO::new).toList();
    }

    public UsuarioDTO create(CriarUsuarioDTO body){
        if (usuarioRepository.existsByEmail(body.getEmail()))
            throw new RegistroJaExistenteException("Usuário", body.getEmail());

        String senhaCriptografada = passwordEncoder.encode(body.getSenha());
        body.setSenha(senhaCriptografada);

        Usuario newUsuario = this.usuarioRepository.save(new Usuario(body));
        return new UsuarioDTO(newUsuario);

    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);
        if (usuarioOpt.isEmpty())
            throw new UsernameNotFoundException("User not found");
        return usuarioOpt.get();
        // mesma coisa
//        return repo.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

    }
}
