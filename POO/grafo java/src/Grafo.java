import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public abstract class Grafo {
    //Atributo, lista de vértices
    protected List<String> vertices;

    //construtor base que será usado pelas subclasses
    protected Grafo() {
        this.vertices = new ArrayList<>(); //inicializa vertices como vazio
    }

    public void adicionarVertice(String vertice){
        if (!existeVertice(vertice)){
            vertices.add(vertice);
        }
    }
    public abstract void removerVertice(String vertice);
    public abstract void adicionarAresta(String origem, String destino);
    public abstract void removerAresta(String origem, String destino);
    public boolean existeVertice(String vertice){
        return vertices.contains(vertice);
    }
    public abstract boolean existeAresta(String origem, String destino);
    public abstract int grau(String vertice);
    public int ordem(){
        return vertices.size();
    }
    public abstract int tamanho();
    public abstract String toString();
}
