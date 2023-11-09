package Data_Type.LinkedList_Operation;

import org.w3c.dom.Node;

import java.util.LinkedList;

public class LinkedList_Operation {

    private static class Node{
        private Node next;
        private String val;

        private Node(){
        }

        public String getVal() {
            return val;
        }

        public void setVal(String val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }




    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();

        Node e = new Node();
        e.next = null;
    }
}
