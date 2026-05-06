import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in); //scanner
        String line1 = sc.nextLine(); //linha de numeros
        String[] numeros = line1.split(" "); //separa os números e coloca no array
        int length = (int) Math.sqrt(numeros.length); //lenght do tabuleiro vale a raiz quadrada da quantidade de números
        int[] numerosint = new int[numeros.length];
        int linhazero = 0, colunazero = 0;
        for (int i = 0; i < numeros.length; i++) //conversao das strings para inteiros
        {
            numerosint[i] = Integer.parseInt(numeros[i]);
            if(numerosint[i] == 0){             //calcula a posição do 0 na matriz
                linhazero = (i / length);
                colunazero = (i % length);
            }
            
        }
        Tabuleiro table = new Tabuleiro(length, numerosint); //cria o tabuleiro

        String line2 = sc.nextLine();   //leitura da string que contem os comandos
        table.printTable(); //printa o status inicial do tabuleiro
        for (char comando : line2.toCharArray()) //converte a string de comandos em um array de comandos, e itera por cada um deles
        {
            switch (comando)
            {
                case 'u':
                    if (table.up(linhazero, colunazero))
                    {
                        linhazero++;    //atualiza a posição do 0
                    }
                    break;
                case 'd':
                    if (table.down(linhazero, colunazero))
                    {
                        linhazero--;    //atualiza a posição do 0
                    }
                    break;
                case 'l':
                    if (table.left(linhazero, colunazero))
                    {
                        colunazero++;   //atualiza a posição do 0
                    }
                    break;
                case 'r':
                    if (table.right(linhazero, colunazero))
                    {
                        colunazero--;   //atualiza a posição do 0
                    }
                    break;
                default:
                    break;
            }
            table.printTable();
        }
        if (table.isSolved())
        {
            System.out.printf("Posicao final: true\n");
        }
        else{
            System.out.printf("Posicao final: false\n");
        }
    }
}