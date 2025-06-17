import java.util.*;
public class GraphMatrix{
    private int[][] adjMatrix;
    private int numVertices;    
    public GraphMatrix(int numVertices){
        this.numVertices=numVertices;
        adjMatrix = new int[numVertices][numVertices];
    }
    public void addEdge(int from, int to){
        adjMatrix[from][to] = 1;
    }   
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i=0; i<numVertices;i++) {
            for (int j=0; j<numVertices;j++){
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int vertices = 4;
        GraphMatrix graph = new GraphMatrix(vertices);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(2,0);
        graph.addEdge(2,3);
        graph.addEdge(3,3);
        graph.printGraph();
    }
}
