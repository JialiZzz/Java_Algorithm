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
            root.setLeftNode(insertHelper(root.getLeftNode(), node));
        }
        else if(data > root.getData()){
            root.setRightNode(insertHelper(root.getRightNode(),node));
        }
        return root;
    }

    public void display(){
        displayHelper(root);

    }

    public void displayHelper(Node root){
        if(root!=null){
            displayHelper(root.getLeftNode());
            System.out.print(root.getData()+" ");
            displayHelper(root.getRightNode());
        }
    }

    public boolean search(int data){
        return searchHelper( root, data);
    }

    private boolean searchHelper(Node root,int data){
        if(root==null) return false;
        if(root.getData()==data) return true;
        if(root.getData()>data) return searchHelper(root.getLeftNode(),data);
        if(root.getData()<data) return searchHelper(root.getRightNode(),data);
        return false;
    }

    public void remove(int data){

        if(search(data)){
            removeHelper(root,data);
        }else {
            System.out.println(data+" could not be found!");
        }


    }

    public Node removeHelper(Node root,int data){
        if(root==null) return root;
        else if(data < root.getData()){
            removeHelper(root.getLeftNode(),data);
        }
        else if(data > root.getData()){
            removeHelper(root.getRightNode(),data);
        }else {
            if(root.getLeftNode()==null&&root.getRightNode()==null){
                root = null;
            }
            else if(root.getRightNode()!=null){  //find a successor to replace
                root.setData(successor(root));
                root.setRightNode(removeHelper(root.getRightNode(),data));
            }
            else {          //find a predecessor to replace
                root.setData(predecessor(root));
                root.setLeftNode(removeHelper(root.getLeftNode(),data));
            }
        }

        return root;
    }

    private int successor(Node root){  //find the least value below right child of this root
        root = root.getRightNode();
        while (root.getLeftNode()!=null){
            root=root.getLeftNode();
        }
        return root.getData();
    }

    private int predecessor(Node root){
        root = root.getLeftNode();
        while (root.getRightNode()!=null){
            root=root.getRightNode();
        }
        return root.getData();
    }


    public static void main(String[] args){
        Binary_Tree tree = new Binary_Tree();
        tree.insert(new Node(5));
        tree.insert(new Node(1));
        tree.insert(new Node(9));
        tree.insert(new Node(7));
        tree.insert(new Node(6));
        tree.display();
        System.out.println(tree.search(9));
    }


}
