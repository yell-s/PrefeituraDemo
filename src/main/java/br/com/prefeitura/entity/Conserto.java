package br.com.prefeitura.entity;

import java.time.LocalDateTime;

public class Conserto {
    private int numeroReclamacao;
    private LocalDateTime dataHoraConserto;
    private double valor;

    public Conserto(int numeroReclamacao, double valor) {
        this.numeroReclamacao = numeroReclamacao;
        this.valor = valor;
        this.dataHoraConserto = LocalDateTime.now();
    }
    
    public double getValor() {
        return valor;
    }
    public int getNumeroReclamacao() {
        return numeroReclamacao;
    }
    public LocalDateTime getDataHoraConserto() {
        return dataHoraConserto;
    }

    @Override
    public String toString() {
        return "Data/Hora do conserto: " + dataHoraConserto + ", Valor: R$ " + valor;
    }
}