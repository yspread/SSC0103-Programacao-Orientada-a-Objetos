public class Livro extends Produto{

    public Livro(String nome, int codbarras){
        super(nome, codbarras);
    }

    @Override
    public String qualCategoria(){
        return "Livro";
    }

    @Override
    public String toString(){
        return ("Livro :" + nome + "\nCódigo: " + codbarra + "\n");
    }
}
