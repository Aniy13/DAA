import java.util.*;

class AllPairShortestPath {
    final static int INF = 99999;
    int V;

    void floydWarshall(int dist[][]) {
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        printSolution(dist);
    }
    void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        int graph[][] = new int[V][V];
        System.out.println("Enter the adjacency matrix for the graph:");

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
                if (i == j) {
                    graph[i][j] = 0;
                } else if (graph[i][j] == 0) {
                    graph[i][j] = INF;
                }
            }
        }
        AllPairShortestPath a = new AllPairShortestPath();
        a.V = V;
        a.floydWarshall(graph);

        scanner.close();
    }
}
