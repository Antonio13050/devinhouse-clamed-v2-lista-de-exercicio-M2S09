package com.example.miniprojetoapiveiculosM2S09.controller;

import com.example.miniprojetoapiveiculosM2S09.model.transport.*;
import com.example.miniprojetoapiveiculosM2S09.service.AutenticacaoService;
import com.example.miniprojetoapiveiculosM2S09.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@RequestBody CriarUsuarioDTO body){
        UsuarioDTO response = this.usuarioService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DetalhesUsuarioDTO>> listAll(){
        List<DetalhesUsuarioDTO> response = this.usuarioService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/autenticar")
    public ResponseEntity<AutenticacaoResponse> autenticar(@RequestBody @Valid AutenticacaoRequest body){
        var token = this.autenticacaoService.autenticar(body.getEmail(), body.getSenha());
        return ResponseEntity.ok(new AutenticacaoResponse(token));
    }
}
