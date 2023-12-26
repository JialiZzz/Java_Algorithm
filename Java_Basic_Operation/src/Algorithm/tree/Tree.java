package Algorithm.tree;

public class Tree {

        Node root;
        public void inOrder(Node root){
            if(root==null){
                return;
            }
            inOrder(root.left);
            System.out.println(root.val);
            inOrder(root.right);

        }





    public static void main(String[] args){
        Tree tree= new Tree();

        tree.inOrder(tree.root);

    }

}
