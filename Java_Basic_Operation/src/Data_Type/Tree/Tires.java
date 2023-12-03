package Data_Type.Tree;

import java.util.HashMap;

public class Tires {
    private class Node{
        private HashMap<Character,Node> map;
        boolean isCompleted;

        public Node() {
            this.map = new HashMap<>();
        }

        public boolean findNode(char c){
            if(map.get(c)==null) return false;
            return true;
        }

        public void insert(char c, Node node){

            map.put(c,node);
        }

        public void delete(char c, Node node){
            if(findNode( c)){
                map.remove(c);
            }
        }


    }

    Node root;

    public Tires() {
        this.root = new Node();
    }


    public Node nextNode(Node node,char c){
        return node.map.get(c);

    }

    public void insertNode(char c){
        Node node = new Node();
        root.map.put(c,node);
    }
    public boolean findWord(String s){

        return findWordHelper(s,0,root);
    }

    public boolean findWordHelper(String s,int index,Node node){
        if(index==s.length()) return true;
        if(node.findNode(s.charAt(index))){
            findWordHelper( s, index+1, node.map.get(s.charAt(index)));
        }
        return false;
    }

    public static void main(String[] args){
        Tires tr = new Tires();


        tr.insertNode('a');
        Node c = tr.nextNode(tr.root, 'a');

    }


}
