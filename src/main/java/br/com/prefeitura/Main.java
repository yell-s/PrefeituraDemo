package br.com.prefeitura;

import br.com.prefeitura.entity.Reclamacao;
import br.com.prefeitura.service.ReclamacaoService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, Reclamacao> reclamacoes = new HashMap<>();
        ReclamacaoService service = new ReclamacaoService(reclamacoes);

        int option;
        do {
            System.out.println("\nMenu de opções:");
            System.out.println("1) Registrar reclamação");
            System.out.println("2) Excluir reclamação");
            System.out.println("3) Consultar reclamação");
            System.out.println("4) Registrar conserto");
            System.out.println("0) Sair");
            System.out.print("Escolha: ");
            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1 -> service.registrarReclamacao(input, gerarNumeroReclamacao(reclamacoes));
                case 2 -> service.excluirReclamacao(input);
                case 3 -> service.consultarReclamacao(input);
                case 4 -> service.registrarConserto(input);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (option != 0);

        System.out.println("Programa finalizado.");
    }
    
//  Gera número sequencial para cada reclamação
    private static int gerarNumeroReclamacao(Map<Integer, Reclamacao> reclamacoes) {
        return reclamacoes.size() + 1;
    }
}
