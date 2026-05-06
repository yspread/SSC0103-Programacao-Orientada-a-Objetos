import java.util.Collections;
import java.util.Random;
import java.util.Vector;


public class Baralho extends Vector<Carta> {
    private Random rand;

    public Baralho(int seed) {
        for (int naipe = 4; naipe >= 1; naipe--) {
            for (int tipo = 2; tipo <= 14; tipo++) {
                Carta c = new Carta(tipo, naipe);
                this.add(c);
            }
        }
        if (seed == 0)
            rand = new Random();
        else
            rand = new Random(seed);
    }

    public void embaralha() {
        Collections.shuffle(this, rand);
    }

    public Carta pegarCarta() {
        return this.remove(0);
    }

    public void resetBaralho(Carta[] mao, Vector<Carta> descarte) {
        Carta c;
        Collections.addAll(this, mao);
        while(!descarte.isEmpty()){
            c = descarte.remove(0);
            this.add(c);
        }
    }
}