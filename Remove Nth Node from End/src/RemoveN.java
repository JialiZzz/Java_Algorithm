import java.util.ArrayList;
import java.util.List;

public class RemoveN {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){

        }
        ListNode(int value){
            this.val=value;
        }
        ListNode(int value,ListNode next){
            this.val=value;
            this.next=next;
        }


    }

    public ListNode removeNthFromEnd(ListNode head,int n){
        //head contains: none, one head, list
        //check if nth exist, check if
        List<ListNode> map = new ArrayList<>();
        if(head==null) return head;
        if(head.next==null&&n==1) return null;


        //-n
        ListNode current = head;
        while(current!=null){
            map.add(current);
            current=current.next;
        }
        int k=map.size();
        int location = k-n;
        current = map.get(location);
        ListNode pre = null;
        ListNode next = null;
        if(location-1>=0){
            pre = map.get(location-1);
        }
        if(location+1<k){
            next = map.get(location+1);
        }
        if(pre==null&&next!=null){
            current.next=null;
            head = next;
        }
        else if(pre!=null&&next==null){
            pre.next=null;
        }
        else if (pre!=null&&next!=null) {
            pre.next=next;
            current.next=null;
        }

        return head;
    }


}
