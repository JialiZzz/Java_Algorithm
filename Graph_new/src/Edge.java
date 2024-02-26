public class Edge {
    //weight, from  to
    public int weight;
    public Node from;
    public Node to;

    public Edge(Node from,Node to, int weight){
        this.weight=weight;
        this.from=from;
        this.to=to;
    }


}
