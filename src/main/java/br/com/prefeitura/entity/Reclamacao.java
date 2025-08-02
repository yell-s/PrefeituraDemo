package br.com.prefeitura.entity;

import java.time.LocalDateTime;

public class Reclamacao {

    private int numero;
    private String rua;
    private int numeroEndereco;
    private String bairro;
    private int tamanhoBuraco;
    private String localizacao; 
    private LocalDateTime dataHoraReclamacao;
    private String situacao; 
    private Conserto conserto;

    public Reclamacao(int numero, String rua, int numeroEndereco, String bairro, int tamanhoBuraco, String localizacao) {
        this.numero = numero;
        this.rua = rua;
        this.numeroEndereco = numeroEndereco;
        this.bairro = bairro;
        this.tamanhoBuraco = tamanhoBuraco;
        this.localizacao = localizacao;
        this.dataHoraReclamacao = LocalDateTime.now();
        this.situacao = "registrada";
        this.conserto = null;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Conserto getConserto() {
        return conserto;
    }
    
    public void setConserto(Conserto conserto) {
        this.conserto = conserto;
    }

    @Override
    public String toString() {
        return "Reclamação nº" + numero + "\nEndereço: " + rua + ", " + numeroEndereco + ", " + bairro +
                "\nTamanho do buraco: " + tamanhoBuraco +
                "\nLocalização: " + localizacao +
                "\nData/Hora da reclamação: " + dataHoraReclamacao +
                "\nSituação: " + situacao +
                (conserto != null ? ("\nConserto: " + conserto) : "");
    }
}
