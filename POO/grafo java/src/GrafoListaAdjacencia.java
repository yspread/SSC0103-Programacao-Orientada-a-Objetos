import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class GrafoListaAdjacencia extends Grafo{

    // Definição do nó
    private class Vertice{
        String nome;
        List<Vertice> vizinhos;

        public Vertice(String nome){
            this.nome = nome;
            this.vizinhos = new ArrayList<>();
        }
    }

    // Definição da "lista principal" como atributo
    private List<Vertice> todosVertices;

    // Método construtor
    public GrafoListaAdjacencia(){
        super();
        this.todosVertices = new ArrayList<>();
    }

    // Função auxiliar para busca de um vértice na lista
    private Vertice buscarVertice(String nome){
        for (Vertice v : todosVertices){
            if (v.nome.equals(nome)){
                return v;
            }
        }
        return null;
    }

    @Override
    public void adicionarVertice(String nome){
        if (buscarVertice(nome) == null){
            todosVertices.add(new Vertice(nome));
            todosVertices.sort(Comparator.comparing(v->v.nome));
            super.adicionarVertice(nome);
        }
    }

    @Override
    public void removerVertice(String nome){
        Vertice vRemover = buscarVertice(nome);
        if (vRemover != null){
            for (Vertice v : todosVertices){
                v.vizinhos.remove(vRemover);
            }
            todosVertices.remove(vRemover);
            //super.removerVertice(nome);
        }
    }

    @Override
    public void adicionarAresta(String origem, String destino){
        adicionarVertice(origem);
        adicionarVertice(destino);

        Vertice vOrigem = buscarVertice(origem);
        Vertice vDestino = buscarVertice(destino);

        // Adição dos vértices nas listas de adjacência
        if (!vOrigem.vizinhos.contains(vDestino)){
            vOrigem.vizinhos.add(vDestino);
        }
        if (!vDestino.vizinhos.contains(vOrigem)){
            vDestino.vizinhos.add(vOrigem);
        }
    }

    @Override
    public void removerAresta(String origem, String destino){
        Vertice vOrigem = buscarVertice(origem);
        Vertice vDestino = buscarVertice(destino);

        if (vOrigem != null && vDestino != null){
            vOrigem.vizinhos.remove(vDestino);
            vDestino.vizinhos.remove(vOrigem);
        }
    }

    @Override
    public boolean existeAresta(String origem, String destino){
        Vertice vOrigem = buscarVertice(origem);
        Vertice vDestino = buscarVertice(destino);

        if (vOrigem != null && vDestino != null){
            return vOrigem.vizinhos.contains(vDestino);
        }
        return false;
    }

    @Override
    public boolean existeVertice(String nome){
        return buscarVertice(nome) != null;
    }

    @Override
    public int grau(String nome){
        Vertice v = buscarVertice(nome);
        if (v != null){
            return v.vizinhos.size();
        }
        return 0;
    }

    @Override
    public int ordem(){
        return todosVertices.size();
    }

    @Override
    public int tamanho(){
        int totalArestas = 0;
        for (Vertice v : todosVertices){
            totalArestas += v.vizinhos.size();
        }

        return totalArestas /2;
    }

    @Override
    public String toString(){
        List<String> arestas = new ArrayList<>();
        List<String> verticesisolados = new ArrayList<>();

        for (Vertice u : todosVertices){

            if (u.vizinhos.isEmpty()){
                verticesisolados.add("\"" + u.nome + "\";");
            } else {
                for (Vertice v : u.vizinhos){
                    if (u.nome.compareTo(v.nome) < 0){
                        arestas.add("\"" + u.nome + "\" -- \"" + v.nome + "\";");
                    }
                }
            }
        }

        Collections.sort(arestas);
        Collections.sort(verticesisolados);

        StringBuilder sb = new StringBuilder();
        sb.append("graph {\n");

        for(String vertice : verticesisolados){
            sb.append("    ").append(vertice).append("\n");
        }

        // Imprime as arestas na sequência
        for (String aresta : arestas) {
            sb.append("    ").append(aresta).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}