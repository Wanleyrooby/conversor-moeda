import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ServicoCambio servicoCambio = new ServicoCambio();

        String info = """
                *******************************
                *         INFORMAÇÕES         * 
                *   USD =>> Dólar Americano   *
                *   BRL =>> Real              *  
                *   EUR =>> Euro              *  
                *   CAD =>> Dólar Canadense   *  
                *   RUB =>> Rublo Russo       *  
                *   CNY =>> Yuan              *  
                *   ARS =>> Peso Argentino    *                     
                *******************************
                """;

        String menu = """
                    1 - USD => BRL
                    2 - EUR => USD
                    3 - CAD => BRL
                    4 - RUB => USD
                    5 - CNY => EUR
                    6 - ARS => BRL
                    0 - INFO
                    7 - SAIR
                    """;

        String moedaOrigem = "", moedaDestino = "";
        double valor = 0;

        while (true) {
            System.out.println("======================================");
            System.out.println(menu);
            System.out.print("Digite um número (0 a 7): ");
            int opcao = sc.nextInt();

            if (opcao == 7) {
                System.out.println("Encerrando...");
                break;
            }

            if (opcao == 0) {
                System.out.println(info);
                continue;
            }

            System.out.print("Digite o valor: ");
            valor = sc.nextDouble();


            switch(opcao) {
                case 1:
                    moedaOrigem = "USD";
                    moedaDestino = "BRL";
                    break;
                case 2:
                    moedaOrigem = "EUR";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaOrigem = "CAD";
                    moedaDestino = "BRL";
                    break;
                case 4:
                    moedaOrigem = "RUB";
                    moedaDestino = "USD";
                    break;
                case 5:
                    moedaOrigem = "CNY";
                    moedaDestino = "EUR";
                    break;
                case 6:
                    moedaOrigem = "ARS";
                    moedaDestino = "BRL";
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            try {
                double resultado = servicoCambio.converteMoeda(moedaOrigem, moedaDestino, valor);
                System.out.printf("Resultado: %.2f %s = %.2f %s%n",valor, moedaOrigem, resultado, moedaDestino);
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
    }
}
