import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class GrafoMatrizAdjacencia extends Grafo{
    private List<List<Integer>> matrizadjacencia;

    public GrafoMatrizAdjacencia(){
        super();
        this.matrizadjacencia = new ArrayList<>(); //matriz inicialmente vazia
    }

    @Override
    public void adicionarVertice(String vertice) {
        if (existeVertice(vertice)){
            return;
        }
        super.adicionarVertice(vertice);
        //adiciona um elemento 0 no final de cada linha ja existente
        for (List<Integer> linha : matrizadjacencia) {
            linha.add(0);
        }
        List<Integer> novalinha = new ArrayList<>();
        for (int i = 0; i < vertices.size(); i++) {
            novalinha.add(0); // Inicializa sem conexões
        }
        matrizadjacencia.add(novalinha); //adiciona a nova linha na matriz
    }

    @Override
    public void removerVertice(String vertice){
        //verifica se o vértice existe, antes de remover
        if (!existeVertice(vertice)){
            return;
        }
        int indice = vertices.indexOf(vertice);

        //loop remove todos os elementos da coluna certa, indo linha por linha
        for (List<Integer> linha : matrizadjacencia){
            linha.remove(indice); //o índice do vértice na matriz é o mesmo que na lista de vértices
        }
        matrizadjacencia.remove(indice);
        vertices.remove(vertice); //remove da lista de vértices
    }

    @Override
    public void adicionarAresta(String origem, String destino){
        //caso algum dos vértices não exista, criamos
        if (!existeVertice(origem)){
            adicionarVertice(origem);
        }
        if (!existeVertice(destino)){
            adicionarVertice(destino);
        }

        if (existeAresta(origem, destino)){
            return;
        }

        int indexorigem = vertices.indexOf(origem);
        int indexdestino = vertices.indexOf(destino);

        //setamos os simétricos da matriz, equivalentes as posições da origem e de destino, como 1
        matrizadjacencia.get(indexorigem).set(indexdestino, 1);
        matrizadjacencia.get(indexdestino).set(indexorigem, 1);
    }

    @Override
    public void removerAresta(String origem, String destino){
        if (!existeVertice(origem) || !existeVertice(destino)){
            return;
        }
        if (!existeAresta(origem, destino)){
            return;
        }

        int indexorigem = vertices.indexOf(origem);
        int indexdestino = vertices.indexOf(destino);

        //setamos os simétricos da matriz, equivalentes as posições da origem e de destino, como 1
        matrizadjacencia.get(indexorigem).set(indexdestino, 0);
        matrizadjacencia.get(indexdestino).set(indexorigem, 0);
    }

    @Override
    public boolean existeAresta(String origem, String destino){
        if (!existeVertice(origem) || !existeVertice(destino)){
            return false;
        }

        int indexorigem = vertices.indexOf(origem);
        int indexdestino = vertices.indexOf(destino);

        //retorna true se a posição buscada valer 1
        return (matrizadjacencia.get(indexorigem).get(indexdestino) == 1);
    }

    @Override
    public int grau(String vertice){
        int grau = 0;
        if (!existeVertice(vertice)){
            return -1;
        }
        List<Integer> adjacentes = matrizadjacencia.get(vertices.indexOf(vertice));
        for (Integer aresta : adjacentes){
            if (aresta == 1){
                grau++;
            }
        }
        return grau;
    }

    @Override
    public int tamanho(){
        int tamanho = 0;
        int nvertices = vertices.size();

        for (int linha = 0; linha < nvertices; linha++) {
            for (int coluna = linha; coluna < nvertices; coluna++) {
                if (matrizadjacencia.get(linha).get(coluna) == 1){
                    tamanho++;
                }
            }
        }
        return tamanho;
    }

    @Override
    public String toString(){
        List<String> arestas = new ArrayList<>();
        List<String> verticesisolados = new ArrayList<>();

        for (int linha = 0; linha < vertices.size(); linha++) {
            for (int coluna = linha + 1; coluna < vertices.size(); coluna++) {
                if (matrizadjacencia.get(linha).get(coluna) == 1) {
                    String v1 = vertices.get(linha);
                    String v2 = vertices.get(coluna);

                    if(v1.compareTo(v2) < 0){
                        arestas.add(
                                "\"" + v1 + "\" -- \"" + v2 + "\";"
                        );
                    }
                    else {
                        arestas.add(
                                "\"" + v2 + "\" -- \"" + v1 + "\";"
                        );
                    }
                }
            }

            boolean isolado = true;
            for(int coluna = 0; coluna < vertices.size(); coluna++){
                if(matrizadjacencia.get(linha).get(coluna) == 1){
                    isolado = false;
                    break;
                }
            }

            if(isolado){
                verticesisolados.add(
                        "\"" + vertices.get(linha) + "\";"
                );
            }
        }

        Collections.sort(arestas);
        Collections.sort(verticesisolados);
        StringBuilder sb = new StringBuilder();
        sb.append("graph {\n");

        for(String vertice : verticesisolados){
            sb.append("    ").append(vertice).append("\n");
        }
        for (String aresta : arestas) {
            sb.append("    ").append(aresta).append("\n");
        }
        sb.append("}");

        return sb.toString();
    }
}
