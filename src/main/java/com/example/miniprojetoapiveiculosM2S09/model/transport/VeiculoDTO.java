package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.TipoVeiculo;
import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;

public record VeiculoDTO(String placa, TipoVeiculo tipoVeiculo, String nome, Integer anoFabricacao, String cor) {

    public VeiculoDTO(Veiculo veiculo){
        this(veiculo.getPlaca(), veiculo.getTipoVeiculo(), veiculo.getNome(), veiculo.getAnoFabricacao(), veiculo.getCor());
    }
}