import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Loja loja = new Loja();

        Produto[] livros = {
                new Livro("Harry Potter", 1001),
                new Livro("O Hobbit", 1002)
        };
        Produto[] cds = {
                new Cd(2001, "Utopia"),
                new Cd(2002, "Astroworld")
        };
        Produto[] dvds = {
                new Dvd(3001, "Parasita"),
                new Dvd(3002, "La La Land")
        };

        loja.addProdutos(livros, 10);
        loja.addProdutos(cds, 8);
        loja.addProdutos(dvds, 5);

        loja.mostrarEstoque();

        Produto encontrado = loja.buscarPorCodigoBarras(2001);
        System.out.println(encontrado != null ? encontrado : "Não encontrado.");

        Vector<Produto> resultados = loja.buscarPorNome("tropa");
        for (Produto p : resultados) {
            System.out.println(p);
        }

        System.out.println("Vendendo 3 unidades de Harry Potter (1001)...");
        loja.venderProduto(1001, 3);

        System.out.println("\nVendendo 100 unidades de La La Land (3002)...");
        loja.venderProduto(3002, 100);

        System.out.println();
        loja.mostrarEstoque();
    }
}