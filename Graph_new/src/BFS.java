import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


public class BFS {
    public static void bfs(Node node){
        if(node==null) return;
        Queue<Node>queue = new LinkedList<>();
        HashSet<Node>set = new HashSet<>(); //if visited
        queue.offer(node);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            set.add(cur);
            System.out.print(cur.value+" ");
            for(Node next: cur.nodes){
                if(set.contains(next)) continue;
                queue.offer(next);
                set.add(next);
            }
        }
    }


    public static void main(String[] args){
        int[][] matrix = {{1, 2, 3},{1,3,3},{2,3,3}};
        Graph g = createGraph.createGraph(matrix);
        BFS.bfs(g.nodes.get(1));

    }


}
