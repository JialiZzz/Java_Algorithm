import java.util.ArrayList;

public class Node {
    // value
    // in out edge
    // neighbor
    // edge
    public int value;
    public int in;
    public int out;
    public ArrayList<Edge>edges;
    public ArrayList<Node>nodes;

    public Node(int value){
        this.value=value;
        in=0;
        out=0;
        edges=new ArrayList<>();
        nodes=new ArrayList<>();
    }


}
