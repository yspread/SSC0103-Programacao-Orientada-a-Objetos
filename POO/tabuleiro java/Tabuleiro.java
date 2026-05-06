public class Tabuleiro {
    private int table[][];
    private int length;
    
    public Tabuleiro(int length, int order[]) // construtor do tabuleiro
    {
        table = new int[length][length];
        this.length = length; //length do tabuleiro equivale ao tamanho do lado da matriz quadrada
        int c = 0;
        for (int i = 0; i < length; i++) //transforma o vetor de numeros numa matriz
        {
            for (int j = 0; j < length; j++)
            {
                table[i][j] = order[c];
                c++;
            }
        }
    }

    public boolean up(int zerolinha, int zerocoluna)
    {
        if (zerolinha + 1 < length)
        {
            int temp = table[zerolinha + 1][zerocoluna];
            table[zerolinha + 1][zerocoluna] = 0; //o zero desce 1 posição, se possivel
            table[zerolinha][zerocoluna] = temp;
            return true;
        }
        return false;
    }

    public boolean down(int zerolinha, int zerocoluna)
    {
        if (zerolinha - 1 >= 0)
        {
            int temp = table[zerolinha - 1][zerocoluna];
            table[zerolinha - 1][zerocoluna] = 0; //o zero sobe 1 posição, se possivel
            table[zerolinha][zerocoluna] = temp;
            return true;
        } 
        return false;
    }

    public boolean right(int zerolinha, int zerocoluna)
    {
        if (zerocoluna - 1 >= 0)
        {
            int temp = table[zerolinha][zerocoluna - 1];
            table[zerolinha][zerocoluna - 1] = 0;   //o zero vai pra esquerda 1 posição, se possivel
            table[zerolinha][zerocoluna] = temp;
            return true;
        }
        return false;
    }

    public boolean left(int zerolinha, int zerocoluna)
    {
        if (zerocoluna + 1 < length)
        {
            int temp = table[zerolinha][zerocoluna + 1];
            table[zerolinha][zerocoluna + 1] = 0;   //o zero vai pra direita 1 posição, se possivel
            table[zerolinha][zerocoluna] = temp;
            return true;
        }
        return false;
    }

    public boolean isSolved()   //método verifica se o tabuleiro está resolvido, ou seja, os números estao em sequência
    {
        int c = 0;
        for (int i = 0; i < length; i++)
        {
            for (int j = 0; j < length; j++)
            {
                if(c != table[i][j])
                {
                    return false;
                }
                c++;
            }
        }
        return true;
    }

    public void printTable() //método para imprimir o tabuleiro
    {
        char c = '|';
        for(int i = 0; i < length; i++)
        {
            for(int j = 0; j < length; j++)
            {
                System.out.printf("+------");
            }
            System.out.printf("+\n");
            System.out.printf("%c", c);
            for(int j = 0; j < length; j++)
            {
                System.out.printf("%4d", table[i][j]);
                System.out.printf("%3c", c);
            }
            System.out.printf("\n");
        }
        for(int j = 0; j < length; j++)
        {
            System.out.printf("+------");
        }
        System.out.printf("+\n");
        System.out.printf("\n");
    }

}