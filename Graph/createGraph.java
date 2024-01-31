public class createGraph {
    public static Graph createGraph(int[][] martix){
        Graph graph = new Graph();
        // node node length
        for(int i=0;i<martix.length;i++){
            int from = martix[i][0];
            int to = martix[i][1];
            int value = martix[i][2];

            if(!graph.nodes.containsKey(from)){
                graph.nodes.put(from,new Node(from));
            }
            if(!graph.nodes.containsKey(to)){
                graph.nodes.put(to,new Node(to));
            }
            Node fromNode = graph.nodes.get(from);
            Node toNode = graph.nodes.get(to);
            Edge newEdge = new Edge(fromNode,toNode,value);
            graph.edges.add(newEdge);
        }
        return graph;
    }
}
