package com.example.miniprojetoapiveiculosM2S09.controller;

import com.example.miniprojetoapiveiculosM2S09.enums.Role;
import com.example.miniprojetoapiveiculosM2S09.enums.TipoVeiculo;
import com.example.miniprojetoapiveiculosM2S09.model.Usuario;
import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;
import com.example.miniprojetoapiveiculosM2S09.model.transport.*;
import com.example.miniprojetoapiveiculosM2S09.service.UsuarioService;
import com.example.miniprojetoapiveiculosM2S09.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    public final VeiculoService veiculoService;

    @Autowired
    private UsuarioService usuarioService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }
    @GetMapping
    public ResponseEntity<List<DetalhesVeiculoDTO>> listAll(){
        List<DetalhesVeiculoDTO> response = this.veiculoService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@RequestBody @Valid CriarVeiculoDTO body){
        VeiculoDTO response = this.veiculoService.create(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<DetalhesVeiculoDTO> getById(@PathVariable("placa") String placa){
        DetalhesVeiculoDTO response = this.veiculoService.getVeiculo(placa);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{placa}/multas")
    public ResponseEntity<MultaDTO> createMulta(@PathVariable("placa") String placa, @RequestBody @Valid CriarMultaDTO body){
        MultaDTO response = this.veiculoService.createMulta(placa, body);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/dados")
    public ResponseEntity<?> carregarDados() {
        var veiculos = veiculoService.listAll();
        if (veiculos.isEmpty()) {
            CriarVeiculoDTO veiculo1 = new CriarVeiculoDTO("ABC-1234", TipoVeiculo.AUTOMOVEL, "Bat-Movel", 2022, "preto");
            CriarVeiculoDTO veiculo2 = new CriarVeiculoDTO("BCA-4321", TipoVeiculo.ONIBUS, "Enterprise", 1960, "prata");
            veiculoService.create(veiculo1);

            Veiculo veic1 = new Veiculo(veiculo1);
            Veiculo veic2 = new Veiculo(veiculo2);

            CriarMultaDTO multa1Veic1 = new CriarMultaDTO(veic1, "Farol apagado", "Gothan City", 250F);
            CriarMultaDTO multa2Veic1 = new CriarMultaDTO(veic1, "Insulfilm", "Gothan City", 100F);
            CriarMultaDTO multa1Veic2 = new CriarMultaDTO(veic2, "Excesso velocidade", "Hiper-espaço", 400F);
            veiculoService.createMulta(veiculo1.placa(),multa1Veic1);
            veiculoService.createMulta(veiculo1.placa(),multa2Veic1);
            veiculoService.createMulta(veiculo2.placa(),multa1Veic2);
        }
        var usuarios = usuarioService.listAll();
        if (usuarios.isEmpty()) {
            usuarioService.create(new CriarUsuarioDTO());
            usuarioService.create(new CriarUsuarioDTO("Spock", "spock@enterprise.com", "123456", Role.ADMIN));
            usuarioService.create(new CriarUsuarioDTO("Leonard McCoy", "mccoy@enterprise.com", "123456", Role.USUARIO));
            usuarioService.create(new CriarUsuarioDTO("Montgomery Scott", "scott@enterprise.com", "123456", Role.USUARIO));
        }
        return ResponseEntity.ok().build();
    }
}
