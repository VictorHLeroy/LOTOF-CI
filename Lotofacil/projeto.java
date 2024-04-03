import java.util.Scanner;
import java.util.Random;

public class projeto {
    public static void main(String[] args) {
        /*
         * nome da classe
         * nome da variavel
         * simbolo de recebe "="
         * palavra chave "new"
         */

        Scanner Entrada = new Scanner(System.in);
        Random RD = new Random();

        System.out.println("********************************");
        System.out.println("MENU LOTOFÁCIL:");
        System.out.println(" 1) Aposta de 0 a 100 ");
        System.out.println(" 2) Apostar de A a Z");
        System.out.println(" 3) Apostar em par ou ímpar");
        System.out.println(" 0) Sair");
        System.out.println("********************************");
        System.out.print(" Seleciona uma das opções: ");

        int opcao = Entrada.nextInt();
        while (opcao > 3 || opcao < 0) {
            System.out.println("Aposta inválida");
            System.out.print("Tente outra opção: ");
            opcao = Entrada.nextInt();
        }
        switch (opcao) {
            case 1: 
                System.out.print("Qual o número que deseja apostar de 0 a 100: ");
                int numero = Entrada.nextInt();
                while (numero < 0 || numero > 100) {
                    System.out.println("Numero inválido");
                    System.out.print("Tente outro número: ");
                    numero = Entrada.nextInt();
                }
                int numeroSorteado = RD.nextInt(0, 100);
                if (numero == numeroSorteado) {
                    System.out.println("Você ganhou R$1.000,00");
                }
                else{
                    System.out.println("Que pena! O número sorteado foi: " + numeroSorteado);
                }
            break;

            case 2:
            System.out.print("Qual a letra que deseja apostar de A a Z: ");
            char letra = Character.toUpperCase( Entrada.next().charAt(0));
            while (!Character.isLetter(letra)) {
                System.out.println("Letra inválida");
                System.out.print("Tente outra letra: ");
                letra  = Character.toUpperCase( Entrada.next().charAt(0));
            }
            char letraSorteada = (char)RD.nextInt(65, 90);
            while (!Character.isLetter(letraSorteada)) {
                letraSorteada = (char)RD.nextInt(65,90);

            }
            if (letra == letraSorteada) {
                System.out.println("Você ganhou R$500,00");
            }
            else{
                System.out.println("Que pena! A letra sorteada foi: " + letraSorteada);
            }
            break;

            case 3: 
            System.out.print("Digite um número: ");
            int numeroEscolhido = Entrada.nextInt();
            int imparOuPar = RD.nextInt(0,1);
            if (imparOuPar == 0) {
                if (numeroEscolhido % 2 == 0) {
                    System.out.println("Você ganhou R$100,00");
                }
                else {
                    System.out.println("Que pena! O número digitado é impar e a premiação foi para os números pares");
                }
            }
            else {
                if (numeroEscolhido % 2 != 0) {
                    System.out.println("Você ganhou R$100,00");
                }
                else {
                    System.out.println("Que pena! O número digitado é par e a premiação foi para os números impares");
                }
            }

            break;
        
            default:
            break;
        }
    }

}
