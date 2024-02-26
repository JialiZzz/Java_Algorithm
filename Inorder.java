import java.util.HashSet;
import java.util.Stack;

public class Inorder {
    public static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val){
            this.val=val;
            left=null;
            right=null;
        }
    }

    public static void inOrder(Node node){
        Stack<Node>stack=new Stack<>();
        Stack<Node>res=new Stack<>();
        HashSet<Node>set = new HashSet<>();
        stack.push(node);
        set.add(node);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            Node left=cur.left;
            Node right=cur.right;
            if(left!=null&& !set.contains(left)){
                stack.push(left);
                stack.push(node);
                set.add(left);
            }
            else if(right!=null&& !set.contains(right)){
                stack.push(node);
                stack.push(right);
                set.add(right);
            }
            else{
                res.add(cur);
            }
        }
        while(!res.isEmpty()){
            System.out.print(res.pop().val+" ");
        }

    }


    public void insertNode(Node cur,int val){
        if(cur==null) cur=new Node(val);
        else{
            if(cur.val>val) insertNode(cur.left,val);
            else insertNode(cur.right,val);
        }
    }

    public static void preOrder(Node node){
        if(node==null) return;
        System.out.print(node.val+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void postOrder(Node node){
        if(node==null) return;
        System.out.print(node.val+" ");
        postOrder(node.right);
        postOrder(node.left);
    }

    public static void inOrder1(Node node) {
        if (node == null)
            return;

        Stack<Node> stack = new Stack<>();
        Node current = node;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

    public static void main(String[] args) {
        // Creating the root node with value 1
        Node root = new Node(1);

        // Creating left and right children for the root
        root.left = new Node(2);
        root.right = new Node(3);

        // Adding further nodes to demonstrate a binary tree structure
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // Printing the values of the nodes to verify the binary tree structure
        System.out.println("Root: " + root.val);
        System.out.println("Left child of root: " + root.left.val);
        System.out.println("Right child of root: " + root.right.val);
        System.out.println("Left child of left child of root: " + root.left.left.val);
        System.out.println("Right child of left child of root: " + root.left.right.val);
        System.out.println("Left child of right child of root: " + root.right.left.val);
        System.out.println("Right child of right child of root: " + root.right.right.val);
        inOrder1(root);
    }


}
