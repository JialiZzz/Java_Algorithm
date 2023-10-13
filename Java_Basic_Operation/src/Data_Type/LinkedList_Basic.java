/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data_Type;

/**
 *
 * @author 15469
 */
public class LinkedList_Basic {
    Node head;
    private static class Node{
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
        
    }
        // 遍历并打印链表中的所有节点数据
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }
    
    /*
    situation: null, position not exist, head, middle, end
     */
    public void insert(int position, int data){
        if(head==null){
            return;
        }
        Node current = head;
        Node newNode = new Node(data);
        Node preNode,nextNode;
        if(position==0){
            newNode.next=head;
            head = newNode;
            return;
        }
        for(int i = 0; i<position; i++){
            if(current==null){
                return;
            }
            preNode = current;
            current = current.next;
        }
        nextNode = current.next;
        if(nextNode==null){}
    }
    
    public void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;     //找到尾部   因为java是指向地址
        }
        current.next = newNode;
    }
    
    
    /*
    5 situation: empty, not contain, at head, at middle, at end
    at head:  delete head, return head point to next
    at middle: pre point to next
    at end: point to null
    */
    
    public void delete(int i){
        if(head==null){
            return;
        }
        if(head.data==i){
            head = head.next;
            return;
        }
        Node current = head;
        Node preNode = null;
        Node nextNode = null;
        while(current.data!=i){
            if(current==null){
                return;
            }
            preNode = current;
            current = current.next;
        }
        nextNode = current.next;
        if(nextNode==null){
            preNode.next = null;
            return;
        }
        else{
            preNode.next = nextNode;
            return;
        }
    }
    
    public Node reverse(){
        
        //point to pre current next  
        //null exist
        if(head==null){
            return null;
        }
        Node pre=null;
        Node current=head;
        Node next=current.next;
        while(current!=null){
            next=current.next;
            current.next=pre;
            pre = current;
            current = next;
        }
        head=pre;
        return pre;
    }
    
    
        public static void main(String[] args) {
        LinkedList_Basic list = new LinkedList_Basic();
        Node deleted = new LinkedList_Basic.Node(2);
        list.append(1);
        list.append(2);
        list.append(3);
        list.printList(); // 输出：1 2 3
        list.delete(1); // 删除值为3的节点
        list.printList(); // 输出：2 3

        System.out.println();
        list.append(3);
        list.append(3) ;      
        list.reverse();
        list.printList(); // 输出：3 3 3 2
    }
    
}
