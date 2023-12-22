public class SwapNodesinPairs {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        if(head.next==null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur.next!=null||cur!=null){
            if(pre==null){
                cur.next=next.next;
                next.next=cur;

                head=next;
                pre= cur;
                cur=cur.next;
                if(cur.next!=null){
                    next=cur.next;
                }else{
                    next=null;
                }

            }
            else{
                pre.next=next;
                if(next.next!=null){
                    cur.next=next.next;
                }
                else {
                    cur.next=null;
                }
                next.next=cur;

                pre=cur;
                if(cur!=null){
                    cur=cur.next;
                    if(cur.next!=null){
                        next=cur.next;
                    }else{
                        next=null;
                    }
                }else{
                    cur=null;
                }


            }


        }
        return head;
    }

}
