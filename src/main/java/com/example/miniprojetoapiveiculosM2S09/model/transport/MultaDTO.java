package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.model.Multa;
import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;

public record MultaDTO(Integer id, String local, String motivo, Float valor) {
    public MultaDTO(Multa multa){
        this(multa.getId(), multa.getLocal(), multa.getMotivo(), multa.getValor());
    }
}