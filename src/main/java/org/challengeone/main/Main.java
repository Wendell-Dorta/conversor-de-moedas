package org.challengeone.main;

import org.challengeone.models.ConsumirApi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsumirApi consumirApi = new ConsumirApi();
        Scanner scan = new Scanner(System.in);

        int opcao;
        do{
            System.out.println("""
                        ************************************************
                         Bem Vindo/a ao Conversor de Moedas =]
                         Escolha uma das opções a seguir:
                    
                         1 - Peso Argentino ==> Dolar
                         2 - Dolar ==> Peso Argentino
                         3 - Peso Colombiano ==> Dolar
                         4 - Dolar ==> Peso Colombiano
                         5 - Real Brasileiro ==> Dolar
                         6 - Dolar ==> Real Brasileiro
                    
                         0 - Sair
                        ************************************************
                    """);

            try {
                System.out.println("Escolha sua opção: ");
                opcao = scan.nextInt();
            } catch (Exception e){
                System.out.println("Opção Inválida! Escolha uma das opções do menu.\n");
                opcao = -1;
            }

            System.out.println("Digite o valor a ser convertido: ");
            Double valor = scan.nextDouble();

            switch (opcao) {
                case 1 -> consumirApi.converter("USD", valor, consumirApi.getDados("ARS", "USD"));
                case 2 -> consumirApi.converter("ARS", valor, consumirApi.getDados("USD", "ARS"));
                case 3 -> consumirApi.converter("USD", valor, consumirApi.getDados("COP", "USD"));
                case 4 -> consumirApi.converter("COP", valor, consumirApi.getDados("USD", "COP"));
                case 5 -> consumirApi.converter("USD", valor, consumirApi.getDados("BRL", "USD"));
                case 6 -> consumirApi.converter("BRL", valor, consumirApi.getDados("USD", "BRL"));
                case 0 -> System.out.println("Saindo...\n");
                default -> System.out.println("Opção Invalida! Insira uma opção válida\n");
            }
        } while (opcao != 0);
    }
}