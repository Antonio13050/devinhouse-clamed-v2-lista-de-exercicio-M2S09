package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.enums.TipoVeiculo;
import jakarta.validation.constraints.NotBlank;

public record CriarVeiculoDTO(@NotBlank String placa, TipoVeiculo tipoVeiculo, String nome, Integer anoFabricacao, String cor ) {
}
