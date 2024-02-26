import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    //nodes
    //edges
    public HashMap<Integer,Node>nodes;
    public HashSet<Edge>edges;

    public Graph(){
        nodes=new HashMap<Integer, Node>();
        edges=new HashSet<Edge>();
    }

}
