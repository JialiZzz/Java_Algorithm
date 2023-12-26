package Algorithm.tree;

public class Node{
    int val;
    Node left;
    Node right;

    public Node(){

    }
    public  Node(int val){
        this.val=val;
    }

    public void insert(int value){
        if(value<=val){
            if(left==null){
                left=new Node(value);
            }
            else {
                left.insert(value);
            }
        }else{
            if(right==null){
                right=new Node(value);
            }
            else{
                right.insert(value);
            }
        }
    }


    public void inOrder(){
        if(left!=null){
            left.inOrder();
        }
        System.out.println(val);
        if(right!=null){
            right.inOrder();
        }

    }


    public static void main(String[] args){
        Node node= new Node(2);
        node.insert(1);
        node.insert(4);
        node.insert(7);
        node.inOrder();

    }


}
