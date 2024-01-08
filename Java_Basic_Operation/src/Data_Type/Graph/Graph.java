package Data_Type.Graph;

import java.util.*;

public class Graph {
    private int numVertices;
    private List<Integer>[] adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        // For undirected graph, add the reverse edge as well
        adjList[dest].add(src);
    }

    public void DFS(int start) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer>stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            int cur = stack.pop();
            if(!visited[cur]){
                visited[cur]=true;
                System.out.print(cur+" ");
            }
            for(int neighbor : adjList[cur]){
                if(!visited[neighbor]){
                    stack.push(neighbor);
                }
            }
        }
        System.out.println(" ");
        visited = new boolean[numVertices];
        DFSUtil(start, visited);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList[vertex]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void BFS(int start) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(!visited[current]){
                visited[current] = true;
                System.out.print(current + " ");
            }
            for (int neighbor : adjList[current]) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }
    }

    public void dijkstra(int source) {
        int[] distance = new int[numVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().vertex;

            for (int v : adjList[u]) {
                int newDistance = distance[u] + 1;  // Assuming unweighted graph
                if (newDistance < distance[v]) {
                    distance[v] = newDistance;
                    pq.offer(new Node(v, newDistance));
                }
            }
        }

        // 输出最短距离
        System.out.println("\n从源节点到各节点的最短距离：");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("节点 " + i + ": " + distance[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(4, 7);
        graph.addEdge(4, 6);
        graph.addEdge(3, 6);


        System.out.println("DFS starting from vertex 0:");
        graph.DFS(1);

        System.out.println("\nBFS starting from vertex 0:");
        graph.BFS(1);

        // 使用Dijkstra算法找到从节点0到其他节点的最短距离
        graph.dijkstra(3);
    }

    static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}


