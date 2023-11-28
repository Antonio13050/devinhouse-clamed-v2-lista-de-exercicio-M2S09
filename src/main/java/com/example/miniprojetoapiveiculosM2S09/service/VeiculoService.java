package com.example.miniprojetoapiveiculosM2S09.service;

import com.example.miniprojetoapiveiculosM2S09.exception.RegistroNaoEncontradoException;
import com.example.miniprojetoapiveiculosM2S09.model.Multa;
import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;
import com.example.miniprojetoapiveiculosM2S09.model.transport.*;
import com.example.miniprojetoapiveiculosM2S09.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository){
        this.veiculoRepository = veiculoRepository;
    }

    public List<DetalhesVeiculoDTO> listAll(){
        List<Veiculo> veiculos = veiculoRepository.findAll();
        return veiculos.stream().map(DetalhesVeiculoDTO::new).toList();
    }

    @Transactional
    public VeiculoDTO create(CriarVeiculoDTO body){
        Veiculo newVeiculo = this.veiculoRepository.save(new Veiculo(body));
        return new VeiculoDTO(newVeiculo);
    }

    public DetalhesVeiculoDTO getVeiculo(String placa){
        return this.veiculoRepository.findById(placa).map(DetalhesVeiculoDTO::new)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Veiculo", placa));
    }

    @Transactional
    public MultaDTO createMulta(String placa, CriarMultaDTO body){
        Veiculo veiculo = this.veiculoRepository.findById(placa)
                .orElseThrow(() -> new RegistroNaoEncontradoException("Veiculo", placa));
        Multa multa = new Multa(body.getLocal(), body.getMotivo(), body.getValor(), veiculo);
        veiculo.getMultas().add(multa);

        return new MultaDTO(multa);
    }
}
