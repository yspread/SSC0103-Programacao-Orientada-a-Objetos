public class Dvd extends Produto{

    public Dvd(int codbarras, String nome){
        super(nome, codbarras);
    }

    @Override
    public String qualCategoria(){
        return "DVD";
    }

    @Override
    public String toString(){
        return ("DVD :" + nome + "\nCódigo: " + codbarra + "\n");
    }
}
