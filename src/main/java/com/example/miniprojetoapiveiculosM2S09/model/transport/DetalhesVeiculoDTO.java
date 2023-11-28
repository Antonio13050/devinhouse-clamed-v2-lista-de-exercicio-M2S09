package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.TipoVeiculo;
import com.example.miniprojetoapiveiculosM2S09.model.Multa;
import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;
import jakarta.persistence.*;

import java.util.List;

public record DetalhesVeiculoDTO(String placa, TipoVeiculo tipoVeiculo, String nome, Integer anoFabricacao, String cor, List<MultaDTO> multas) {
    public DetalhesVeiculoDTO(Veiculo veiculo){
        this(veiculo.getPlaca(), veiculo.getTipoVeiculo(), veiculo.getNome(), veiculo.getAnoFabricacao(), veiculo.getCor(), veiculo.getMultasComoObjeto());
    }
}
