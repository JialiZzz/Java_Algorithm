import java.util.*;

public class sortTopology {

    //key node
    //val in

    public static List<Node> sortTopology(Graph g){
        HashMap<Node,Integer>inMap=new HashMap<>();
        Queue<Node>zeroInQueue = new LinkedList<>();

        for(Node node:g.nodes.values()){
            inMap.put(node, node.in);
            if(node.in==0){
                zeroInQueue.offer(node);
            }
        }
        List<Node> res = new ArrayList<>();
        while (!zeroInQueue.isEmpty()){
            Node cur = zeroInQueue.poll();
            res.add(cur);
            for(Node next : cur.nodes){
                inMap.put(next,inMap.get(next)-1);
                if(next.in==0){
                    zeroInQueue.offer(next);
                }
            }
        }

        return res;

    }

    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3},{2,3,3},{2,3,3}};
        Graph g = createGraph.createGraph(matrix);
        List<Node> res=sortTopology.sortTopology(g);
        for(Node s : res){
            System.out.print(s.value+" ");
        }
        HashSet<Node>s=new HashSet<>();
        for(Node n : s){}
    }



}
