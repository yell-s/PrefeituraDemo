package br.com.prefeitura.service;

import java.util.Map;
import java.util.Scanner;

import br.com.prefeitura.entity.Conserto;
import br.com.prefeitura.entity.Reclamacao;

public class ReclamacaoService {

    private Map<Integer, Reclamacao> reclamacoes;

    public ReclamacaoService(Map<Integer, Reclamacao> reclamacoes) {
        this.reclamacoes = reclamacoes;
    }

    public void registrarReclamacao(Scanner input, int numero) {
        System.out.print("Rua: ");
        String rua = input.nextLine();

        System.out.print("Número: ");
        int numEndereco = Integer.parseInt(input.nextLine());

        System.out.print("Bairro: ");
        String bairro = input.nextLine();

        System.out.print("Tamanho do buraco (0 a 10): ");
        int tamanho = Integer.parseInt(input.nextLine());
        if (tamanho < 0 || tamanho > 10) {
            System.out.println("Tamanho inválido. Deve ser entre 0 e 10.");
            return;
        }

        System.out.print("Localização (rua/calçada): ");
        String localizacao = input.nextLine();
        if (!localizacao.equalsIgnoreCase("rua") && !localizacao.equalsIgnoreCase("calçada")) {
            System.out.println("Localização inválida.");
            return;
        }

        Reclamacao rec = new Reclamacao(numero, rua, numEndereco, bairro, tamanho, localizacao);
        reclamacoes.put(numero, rec);
        System.out.println("Reclamação registrada com número: " + numero);
    }

    public void excluirReclamacao(Scanner input) {
        System.out.print("Número da reclamação para excluir: ");
        int numero = Integer.parseInt(input.nextLine());
        if (reclamacoes.containsKey(numero)) {
            reclamacoes.remove(numero);
            System.out.println("Reclamação removida.");
        } else {
            System.out.println("Reclamação não encontrada.");
        }
    }

    public void consultarReclamacao(Scanner input) {
        System.out.print("Número da reclamação para consultar: ");
        int numero = Integer.parseInt(input.nextLine());
        Reclamacao rec = reclamacoes.get(numero);
        if (rec != null) {
            System.out.println(rec);
        } else {
            System.out.println("Reclamação não encontrada.");
        }
    }

    public void registrarConserto(Scanner input) {
        System.out.print("Número da reclamação para registrar conserto: ");
        int numero = Integer.parseInt(input.nextLine());
        Reclamacao rec = reclamacoes.get(numero);
        if (rec == null) {
            System.out.println("Reclamação não encontrada.");
            return;
        }
        if (rec.getSituacao().equalsIgnoreCase("consertada")) {
            System.out.println("Esta reclamação já foi consertada.");
            return;
        }
        System.out.print("Valor do conserto: R$ ");
        double valor = Double.parseDouble(input.nextLine());
        Conserto cons = new Conserto(numero, valor);
        rec.setConserto(cons);
        rec.setSituacao("consertada");
        System.out.println("Conserto registrado.");
    }
}
