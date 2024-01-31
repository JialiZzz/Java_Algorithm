import java.util.HashMap;

class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        //reverse k nodes at a time
        //hashmap <index,node>
        //n/k time swap
        HashMap<Integer,ListNode> hm = new HashMap<>();
        ListNode cur = head;
        ListNode node = new ListNode();
        int i=1;
        while(cur!=null){
            hm.put(i,cur);
            cur=cur.next;
            i++;
        }
        int group = (i-1)/k;
        if(group==0) return head;

        for(int j=1;j<=group;j++){
            int m = j*k;
            for(int s=0;s<k;s++){
                node = hm.get(m);
                node.next = new ListNode();
                node=node.next;
                m--;
            }
        }
        int res = i-(i%k)+1;
        for(;res<=i;res++){
            node=hm.get(res);
            node=node.next;
        }
        if(node!=null) node.next=null;
        return head;
    }





    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        reverseKGroup(head,2);
    }

}