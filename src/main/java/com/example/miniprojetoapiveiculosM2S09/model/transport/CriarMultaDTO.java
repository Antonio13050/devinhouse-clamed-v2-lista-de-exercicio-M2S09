package com.example.miniprojetoapiveiculosM2S09.model.transport;

import com.example.miniprojetoapiveiculosM2S09.model.Veiculo;

public class CriarMultaDTO{

    private String local;
    private String motivo;
    private Float valor;
    private Veiculo veiculo;

    public CriarMultaDTO() {
    }

    public CriarMultaDTO(String local, String motivo, Float valor) {
        this.local = local;
        this.motivo = motivo;
        this.valor = valor;
    }

    public CriarMultaDTO(Veiculo veiculo, String motivo, String local,  Float valor) {
        this.local = local;
        this.motivo = motivo;
        this.valor = valor;
        this.veiculo = veiculo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}