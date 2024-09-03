/*Dado a sequência de Fibonacci, onde se inicia por
 0 e 1 e o próximo valor sempre será a soma dos 2 valores 
 anteriores (exemplo: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34...),
  escreva um programa na linguagem que desejar onde,
   informado um número, ele calcule a sequência de Fibonacci 
   e retorne uma mensagem avisando se 
o número informado pertence ou não a sequência. */

public class Exercicio2 {

    public static void main(String[] args) {
        int numero = 21;
        int a = 0;
        int b = 1;
        int proximo = 0;

        boolean pertence = false;

        while (proximo <= numero) {
            if (proximo == numero) {
                pertence = true;
                break;
            }
            proximo = a + b;
            a = b;
            b = proximo;
        }

        if (pertence) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
    }
}
