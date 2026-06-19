public abstract class Produto {
    protected int codbarra;
    protected String nome;

    public Produto(String nome, int codbarra){
        this.codbarra = codbarra;
        this.nome = nome;
    }

    public int getCodbarra() {
        return codbarra;
    }

    public String getNome() {
        return nome;
    }

    public abstract String qualCategoria();

    public abstract String toString();
}

