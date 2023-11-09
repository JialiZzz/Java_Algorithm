package Data_Type.Tree;

public class Binary_Tree {
    Node root;

    public void insert(Node node){
        root = insertHelper(root,node);
    }

    public Node insertHelper(Node root,Node node){
        int data = node.getData();
        if(root==null){
            return node;
        }
        else if(data < root.getData()){
            root.setLeftNode(insertHelper( root.getLeftNode(), node));
        }
        else if(data > root.getData()){
            root.setRightNode(insertHelper(root.getRightNode(),node));
        }
        return root;
    }

    public void display(){}

    public void displayHelper(Node root){}

    public boolean search(int data){return true;}

    private boolean searchHelper(Node root,int data){return true;}

    public void remove(int data){}

    public Node removeHelper(Node root,int data){return null;}

    private int successor(Node root){return 0;}

    private int predecessor(Node root){return 0;}




}
