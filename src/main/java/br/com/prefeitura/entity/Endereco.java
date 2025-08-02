package br.com.prefeitura.entity;

public class Endereco {
    
    private String rua;
    private int numero;
    private String bairro;
    private String localizacao;

    public Endereco(String rua, int numero, String bairro, String localizacao) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.localizacao = localizacao;
    }

    public String getRua() {
        return this.rua;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getBairro() {
        return this.bairro;
    }

    public String getLocalizacao() {
        return this.localizacao;
    }

    @Override
    public String toString() {
        return "Rua " + rua + ", Nº " + numero + ", Bairro " + bairro + ", Localização: " + localizacao;
    }
}


