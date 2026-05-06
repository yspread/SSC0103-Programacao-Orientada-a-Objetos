import java.util.Arrays;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String comando, printString;
        String quaisTrocar; //contem os inteiros que correspondem a quais cartas trocar
        int qualCarta;
        boolean[] quais = new boolean[5]; //contem um array de bools, que indicam quais cartas devem ser trocadas
        int aposta, premio;

        System.out.print("Semente: ");
        int seed = sc.nextInt();

        Baralho baralho = new Baralho(seed);
        baralho.embaralha();

        System.out.print("Saldo inicial: ");
        int saldo = sc.nextInt();
        sc.nextLine();

        while(true){
            Arrays.fill(quais, false);
            if (saldo == 0){
                System.out.println("Seu saldo acabou. Tente jogar outra vez.");
                break;
            }
            System.out.println("Saldo atual: $" + saldo);

            System.out.print("Digite o valor da aposta of 'F' para terminar ==> ");
            comando = sc.nextLine();
            if(comando.equals("F")){
                System.out.println("Terminando o jogo... Parabéns você ainda tem saldo de $" + saldo);
                break;
            }

            aposta = Integer.parseInt(comando);
            if (aposta > saldo){
                System.out.println("Saldo insuficiente. Tecle enter para continuar ");
                sc.nextLine();
            }
            else {
                baralho.embaralha();

                //System.out.println(baralho);
                saldo -= aposta;

                Mao mao = new Mao(5, baralho, saldo);
                System.out.println();
                printString = mao.toString();
                System.out.println(printString);
                Arrays.fill(quais, false);

                //System.out.println(baralho);
                //primeira troca
                System.out.println("Digite o número das cartas que você deseja trocar, separados por espaços: ");
                quaisTrocar = sc.nextLine();
                if (!quaisTrocar.isBlank()) {
                    String[] posicoesTrocar = quaisTrocar.trim().split("\\s+");
                    for (int i = 0; i < posicoesTrocar.length; i++) {
                        qualCarta = Integer.parseInt(posicoesTrocar[i]);
                        quais[qualCarta - 1] = true;
                    }
                    mao.descartarCartas((quais));
                    mao.trocarMao(baralho, quais);
                }
                printString = mao.toString();
                System.out.println(printString);
                Arrays.fill(quais, false);

                //System.out.println(baralho);
                //segunda troca
                System.out.println("Digite o número das cartas que você deseja trocar, separados por espaços: ");
                quaisTrocar = sc.nextLine();
                if (!quaisTrocar.isBlank()) {
                    String[] posicoesTrocar = quaisTrocar.trim().split("\\s+");
                    for (int i = 0; i < posicoesTrocar.length; i++) {
                        qualCarta = Integer.parseInt(posicoesTrocar[i]);
                        quais[qualCarta - 1] = true;
                    }
                    mao.descartarCartas(quais);
                    mao.trocarMao(baralho, quais);
                }
                printString = mao.toString();
                System.out.println(printString);

                //resultados da rodada
                premio = mao.calculaPontuacao(aposta);
                if (premio == 0) {
                    System.out.println("Peninha... não ganhou nada nessa rodada");
                } else {
                    System.out.println("Parabéns. Você acrescentou $" + premio + " ao seu saldo");
                    saldo += premio;
                }
                System.out.println("Tecle enter para continuar");
                sc.nextLine();
                baralho.resetBaralho(mao.getCartas(), mao.getDescarte());
            }

        }
        sc.close();
    }
}