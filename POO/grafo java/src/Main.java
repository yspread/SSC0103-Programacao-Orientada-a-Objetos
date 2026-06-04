//Rafael Pavon Diesner - 16898096
//Gustavo de Faria Fernandes - 16871221

import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        // Instanciando os grafos
        GrafoListaAdjacencia grafoLista = new GrafoListaAdjacencia();
        GrafoMatrizAdjacencia grafoMatriz = new GrafoMatrizAdjacencia();
        GrafoPonderadoMatrizAdjacencia grafoPonderado = new GrafoPonderadoMatrizAdjacencia();

        Scanner scanner = new Scanner(System.in);

        // Leitura da entrada
        while(scanner.hasNextLine()){
            String linha = scanner.nextLine().trim();

            if (linha.isEmpty()){
                continue;
            }

            String[] partes = linha.split("\\s+");
            String comando = partes[0];

            switch (comando){
                // Inserção: i v1 v2 p
                case "i":
                    if (partes.length >= 3){
                        String v1 = partes[1];
                        String v2 = partes[2];

                        // Caso não tenha peso definido assume-se 0 para ponderado
                        int peso = (partes.length >= 4) ? Integer.parseInt(partes[3]) : 0;

                        // Inserindo nos grafos
                        grafoLista.adicionarAresta(v1,v2);
                        grafoMatriz.adicionarAresta(v1, v2);
                        grafoPonderado.adicionarAresta(v1,v2, peso);
                    }
                    break;

                // Remoção: d v1 v2 (para Aresta) ou d v1 Vertice (para vértice)
                case "d":
                    if (partes.length == 3){
                        String v1 = partes[1];
                        String v2 = partes[2];

                        grafoLista.removerAresta(v1,v2);
                        grafoMatriz.removerAresta(v1,v2);
                        grafoPonderado.removerAresta(v1,v2);
                    } else if (partes.length == 2){
                        String v1 = partes[1];

                        grafoLista.removerVertice(v1);
                        grafoMatriz.removerVertice(v1);
                        grafoPonderado.removerVertice(v1);
                    }
                    break;

                // Impressão
                case "p":
                    System.out.println("Lista de Adjacencia");
                    System.out.println(grafoLista.toString());

                    System.out.println("Matriz de Adjacencia");
                    System.out.println(grafoMatriz.toString());

                    System.out.print("Ponderado - ");
                    System.out.println("Matriz de Adjacencia");
                    System.out.println(grafoPonderado.toString());
                    break;

                default:
                    break;
            }
        }
    }
}