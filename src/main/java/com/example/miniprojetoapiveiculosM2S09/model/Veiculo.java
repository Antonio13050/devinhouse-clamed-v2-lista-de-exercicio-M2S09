package com.example.miniprojetoapiveiculosM2S09.model;

import com.example.miniprojetoapiveiculosM2S09.enums.TipoVeiculo;
import com.example.miniprojetoapiveiculosM2S09.model.transport.CriarVeiculoDTO;
import com.example.miniprojetoapiveiculosM2S09.model.transport.MultaDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "VEICULOS")
public class Veiculo {

    @Id
    private String placa;
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipoVeiculo;
    private String nome;
    private Integer anoFabricacao;
    private String cor;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "veiculo")
    private List<Multa> multas;

    public Veiculo() {
    }

    public Veiculo(CriarVeiculoDTO body) {
        this.placa = body.placa();
        this.tipoVeiculo = body.tipoVeiculo();
        this.nome = body.nome();
        this.anoFabricacao = body.anoFabricacao();
        this.cor = body.cor();
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public String getCor() {
        return cor;
    }

    public List<Multa> getMultas() {
        return multas;
    }

    public List<MultaDTO> getMultasComoObjeto(){
        return this.multas.stream().map(MultaDTO::new).toList();
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", tipoVeiculo=" + tipoVeiculo +
                ", nome='" + nome + '\'' +
                ", anoFabricacao=" + anoFabricacao +
                ", cor='" + cor + '\'' +
                ", multas=" + multas +
                '}';
    }
}
