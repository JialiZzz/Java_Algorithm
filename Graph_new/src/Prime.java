import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Prime {
    public static class EdgeComparator implements Comparator<Edge>{

        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public static Set<Edge> primeMST(Graph g){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        HashSet<Node>set=new HashSet<>();
        Set<Edge>result=new HashSet<>();
        for(Node node:g.nodes.values()){
            if(!set.contains(node)){
                set.add(node);
                priorityQueue.addAll(node.edges);
                while (!priorityQueue.isEmpty()){
                    Edge edge = priorityQueue.poll();
                    Node toNode = edge.to;
                    if(!set.contains(toNode)){
                        set.add(toNode);
                        result.add(edge);
                        for (Edge nextEdge : toNode.edges){
                            priorityQueue.add(nextEdge);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[][] matrix = {{1,2,1},{1,3,3},{1,4,4},{2,1,1},{2,3,1},{2,4,1}};
        Graph g = createGraph.createGraph(matrix);
        for(Edge e : primeMST(g)){
            System.out.println(e.from+" "+e.to+" "+e.weight);
        }

    }


}
