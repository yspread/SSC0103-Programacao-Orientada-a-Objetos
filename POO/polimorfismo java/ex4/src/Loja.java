import java.util.Vector;

public class Loja {
    private Vector<Produto> estoque;
    private Vector<Integer> quantidades; // quantidade[i] corresponde ao estoque[i]
    private int qtdprodutos;

    public Loja(){
        this.estoque = new Vector<>();
        this.quantidades = new Vector<>();
        this.qtdprodutos = 0;
    }

    public void addProdutos(Produto[] produtos, int quantidade){
        for (Produto produtoatual : produtos) {
            int indice = buscarIndicePorCodigo(produtoatual.getCodbarra());

            if (indice != -1) {
                // produto já existe no estoque: apenas soma a quantidade
                int qtdAtual = this.quantidades.get(indice);
                this.quantidades.set(indice, qtdAtual + quantidade);
            } else {
                this.estoque.add(produtoatual);
                this.quantidades.add(quantidade);
                this.qtdprodutos++;
            }
        }
    }

    public Produto buscarPorCodigoBarras(int codbarra){
        int indice = buscarIndicePorCodigo(codbarra);
        if (indice == -1) {
            return null;
        }
        return this.estoque.get(indice);
    }

    public Vector<Produto> buscarPorNome(String nome){
        Vector<Produto> resultado = new Vector<>();
        String nomeBusca = nome.toLowerCase();

        for (Produto produtoatual : this.estoque) {
            if (produtoatual.getNome().toLowerCase().contains(nomeBusca)) {
                resultado.add(produtoatual);
            }
        }
        return resultado;
    }

    public boolean venderProduto(int codbarra, int quantidade){
        int indice = buscarIndicePorCodigo(codbarra);

        if (indice == -1) {
            System.out.println("Produto com código " + codbarra + " não encontrado.");
            return false;
        }

        int qtdAtual = this.quantidades.get(indice);
        if (qtdAtual < quantidade) {
            System.out.println("Estoque insuficiente para o produto: " + this.estoque.get(indice).getNome());
            return false;
        }

        this.quantidades.set(indice, qtdAtual - quantidade);
        return true;
    }

    public void mostrarEstoque(){
        System.out.println("===== ESTOQUE DA LOJA =====");

        Vector<String> categorias = new Vector<>();
        Vector<Integer> totalPorCategoria = new Vector<>();

        for (int i = 0; i < this.estoque.size(); i++) {
            Produto produtoatual = this.estoque.get(i);
            int qtdAtual = this.quantidades.get(i);

            System.out.println(produtoatual.toString() + "Quantidade: " + qtdAtual + "\n");

            String categoria = produtoatual.qualCategoria();
            int indiceCategoria = categorias.indexOf(categoria);
            if (indiceCategoria == -1) {
                categorias.add(categoria);
                totalPorCategoria.add(qtdAtual);
            } else {
                int totalAtual = totalPorCategoria.get(indiceCategoria);
                totalPorCategoria.set(indiceCategoria, totalAtual + qtdAtual);
            }
        }

        System.out.println("===== Totais por categoria =====");
        for (int i = 0; i < categorias.size(); i++) {
            System.out.println(categorias.get(i) + ": " + totalPorCategoria.get(i) + " itens");
        }
    }

    private int buscarIndicePorCodigo(int codbarra){
        for (int i = 0; i < this.estoque.size(); i++) {
            if (this.estoque.get(i).getCodbarra() == codbarra) {
                return i;
            }
        }
        return -1;
    }
}
