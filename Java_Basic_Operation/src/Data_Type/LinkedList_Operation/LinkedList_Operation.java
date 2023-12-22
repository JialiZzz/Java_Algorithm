package Data_Type.LinkedList_Operation;


import java.util.HashMap;

public class LinkedList_Operation {
    private static class Node{
        int data;
        Node next;
        private Node(int data){
            this.data=data;
            next=null;
        }


    }

    public static class LinkedList{
        Node head;


        public void showResult(){
            Node cur = head;
            while (cur!=null){
                System.out.print(cur.data+" ");
                cur=cur.next;
            }
            System.out.println();
        }

        public void append(int data){
            if(head==null){
                Node next = new Node(data);
                head=next;
                return;
            }
            Node current=head;
            while (current.next!=null){
                current=current.next;
            }
            current.next=new Node(data);

        }


        public void deleteWithValue(int data){
            if(head==null) return;

            if(head.data==data){
                head=head.next;
                return;
            }
            Node current=head;

            while (current.next!=null){
                if(current.next.data==data){
                    current.next=current.next.next;
                    return;
                }
                else {
                    current=current.next;
                }
            }
            System.out.println("No Found!");
        }


        public void insertWithValue(int data,int val){
            //insert after the Node with data
            //if head not exist, return
            if(head==null) return;
            if(head.data==data){
                Node node = new Node(val);
                node.next=head.next;
                head.next=node;
                return;
            }
            Node current = head;
            while (current!=null){
                if(current.data==data){
                    Node node = new Node(val);
                    node.next=current.next;
                    current.next=node;
                    return;
                }
                current=current.next;
            }
            System.out.println("No Found!");


        }


    }



    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(6);
        linkedList.showResult();
        linkedList.deleteWithValue(4);
        linkedList.showResult();
        linkedList.insertWithValue(3,4);
        linkedList.showResult();
        linkedList.insertWithValue(4,5);
        linkedList.showResult();
        HashMap<Integer,LinkedList> hm = new HashMap<>();
        LinkedList[] ln = new LinkedList[12];
    }
}
