package Data_Type.Graph;

import java.util.ArrayList;

public class Vertex {
    private String data;
    private ArrayList<Edge> edges;

    public Vertex(String input){
        this.data=input;
        this.edges=new ArrayList<>();
    }


    public void addEdge(Vertex endVertex, Integer weight){
        this.edges.add(new Edge(this,endVertex,weight));

    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Edge> edges) {
        this.edges = edges;
    }

    public void removeEdge(Vertex endVertex){
        this.edges.removeIf(edge -> edge.getEnd().equals(endVertex));
    }


}
