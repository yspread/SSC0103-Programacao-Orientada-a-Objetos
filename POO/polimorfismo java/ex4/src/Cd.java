public class Cd extends Produto{

    public Cd(int codbarras, String nome) {
        super(nome, codbarras);
    }

    @Override
    public String qualCategoria(){
        return "CD";
    }

    @Override
    public String toString(){
        return ("CD :" + nome + "\nCódigo: " + codbarra + "\n");
    }
}
