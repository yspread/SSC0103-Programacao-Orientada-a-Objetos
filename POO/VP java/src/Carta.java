import java.util.Random;

//A=14, J=11, Q=12, K=13
//Ouros = 1, Espadas = 2, Copas = 3, Paus = 4
public class Carta {
    private int[] valorCarta = new int[2]; //tipo e naipe respectivamente

    public Carta(int tipo, int naipe){
        valorCarta[0] = tipo;
        valorCarta[1] = naipe;
    }

    public int getTipo(){
        return valorCarta[0];
    }

    public int getNaipe() {
        return valorCarta[1];
    }

    public String toString(){
        String s = "+-----+\n";
        s += "|     |\n";
        String tipo, naipe, carta;
        switch(valorCarta[1]){
            case 1 -> naipe = "♦";
            case 2 -> naipe = "♠";
            case 3 -> naipe = "♥";
            case 4 -> naipe = "♣";
            default -> naipe = "0";
        }
        switch(valorCarta[0]){
            case 2, 3, 4, 5, 6, 7, 8, 9, 10 -> tipo = String.valueOf(valorCarta[0]);
            case 11 -> tipo = "J";
            case 12 -> tipo = "Q";
            case 13 -> tipo = "K";
            case 14 -> tipo = "A";
            default -> tipo = "0";
        }
        if (valorCarta[0] != 10){
            s+= ("| " + tipo + " " + naipe + " |\n");
        }
        else{
            s+= ("| " + tipo + naipe + " |\n");
        }
        s += "|     |\n";
        s += "+-----+\n";
        return s;
    }
}
