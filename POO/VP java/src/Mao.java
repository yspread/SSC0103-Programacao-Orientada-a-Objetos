import java.util.Arrays;
import java.util.Vector;

public class Mao {
    private Carta[] cartas;
    private Vector<Carta> descarte;
    private int pontuacao; //valor a ser recebido no final do jogo
    private int saldo;

    public Mao(int n, Baralho baralho, int saldo){
        this.saldo = saldo;
        cartas = new Carta[n];
        for (int i = 0; i < n; i++) {
            cartas[i] = baralho.pegarCarta();
        }
        descarte = new Vector<Carta>();
    }

    public void descartarCartas(boolean[] quais){
        int i = 0;
        for (boolean b : quais){
            if (b) descarte.add(cartas[i]);
            i++;
        }
    }

    //troca algumas cartas da mão
    public void trocarMao(Baralho baralho, boolean[] quais) {
        int i = 0;
        for (boolean b : quais) {

            if (b) cartas[i] = baralho.pegarCarta();
            i++;
        }
    }

    public int calculaPontuacao(int aposta) {
        int[] tipos = new int[cartas.length];
        for (int i = 0; i < cartas.length; i++) {
            tipos[i] = cartas[i].getTipo();
        }
        int[] naipes = new int[cartas.length];
        for (int i = 0; i < cartas.length; i++) {
            naipes[i] = cartas[i].getNaipe();
        }

        if (checkRoyalFlush(tipos, naipes)) {
            pontuacao = aposta * 200;
        } else if (checkStraightFlush(tipos, naipes)) {
            pontuacao = aposta * 100;
        } else if (checkQuadra(tipos)) {
            pontuacao = aposta * 50;
        } else if (checkFullHand(tipos)) {
            pontuacao = aposta * 20;
        } else if (checkFlush(naipes)) {
            pontuacao = aposta * 10;
        } else if (checkStraight(tipos)) {
            pontuacao = aposta * 5;
        } else if (checkTrinca(tipos)) {
            pontuacao = aposta * 2;
        } else if (checkDoisPares(tipos)) {
            pontuacao = aposta;
        } else {
            pontuacao = 0;
        }

        return pontuacao;
    }

    private boolean checkDoisPares(int[] tipos) {
        Arrays.sort(tipos);

        int paresEncontrados = 0;
        for (int j = 0; j < tipos.length - 1; j++) {

            // se a carta atual for igual a carta da direita, é um par
            if (tipos[j] == tipos[j + 1]) {
                paresEncontrados++;
                j++;
            }
        }
        return paresEncontrados == 2;
    }

    private boolean checkTrinca(int[] tipos) {
        boolean resp = false;
        Arrays.sort(tipos);
        if ((tipos[0] == tipos[1] && tipos[1] == tipos[2]) || (tipos[1] == tipos[2] && tipos[2] == tipos[3]) || (tipos[2] == tipos[3] && tipos[3] == tipos[4])) {
            resp = true;
        }
        return resp;
    }

    private boolean checkStraight(int[] tipos) {
        boolean resp = false;
        Arrays.sort(tipos);
        if (tipos[0] == tipos[1] - 1 && tipos[1] == tipos[2] - 1 && tipos[2] == tipos[3] - 1 && tipos[3] == tipos[4] - 1) {
            resp = true;
        }
        return resp;
    }

    private boolean checkFlush(int[] naipes) {
        boolean resp = false;
        if (naipes[0] == naipes[1] && naipes[1] == naipes[2] && naipes[2] == naipes[3] && naipes[3] == naipes[4]) {
            resp = true;
        }
        return resp;
    }

    private boolean checkFullHand(int[] tipos) {
        boolean resp = false;
        Arrays.sort(tipos);
        if (((tipos[0] == tipos[1] && tipos[3] == tipos[4]) && (tipos[1] == tipos[2] || tipos[2] == tipos[3])) && (tipos[2] != tipos[3] || tipos[2] != tipos[1])) {
            resp = true;
        }
        return resp;
    }

    private boolean checkQuadra(int[] tipos) {
        boolean resp = false;
        Arrays.sort(tipos);
        if ((tipos[0] == tipos[1] && tipos[1] == tipos[2] && tipos[2] == tipos[3]) || (tipos[1] == tipos[2] && tipos[2] == tipos[3] && tipos[3] == tipos[4])) {
            resp = true;
        }
        return resp;
    }

    private boolean checkStraightFlush(int[] tipos, int[] naipes) {
        boolean resp = false;
        if (checkFlush(naipes) && checkStraight(tipos)) {
            resp = true;
        }
        return resp;
    }

    private boolean checkRoyalFlush(int[] tipos, int[] naipes) {
        boolean resp = false;
        Arrays.sort(tipos);
        if (checkFlush(naipes) && tipos[4] == 14 && tipos[3] == 13 && tipos[2] == 12 && tipos[1] == 11 && tipos[0] == 10) {
            resp = true;
        }
        return resp;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < 5; i++) {
            int base = i * 8;
            for (Carta c : cartas) {
                String p = c.toString();
                s += p.substring(base, base + 7);
                s += " ";
            }
            s += "\n";
        }
        s += "  (1)     (2)     (3)     (4)     (5)";
        return s;
    }

    public Carta[] getCartas(){
        return cartas;
    }

    public Vector<Carta> getDescarte(){
        return descarte;
    }

}
