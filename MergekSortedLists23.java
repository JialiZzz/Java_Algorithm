public class MergekSortedLists23 {

      public class ListNode {
         int val;
          ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode node = new ListNode();
            ListNode head = new ListNode();
            node = head;
            if(lists==null) return node;

            if(isEmpty(lists)){
                return node;
            }

            while (isEmpty(lists)==false){
                int val=0;
                int count=0;
                for(int i=0;i< lists.length;i++){
                    if(lists[i]!=null){
                        val=lists[i].val;
                        count=i;
                        break;
                    }
                }
                for(int i=0;i< lists.length;i++){
                    if(lists[i]!=null){
                        if(val>lists[i].val){
                            val=lists[i].val;
                            count=i;
                        }
                    }
                }
                node = lists[count];
                node = node.next;
                lists[count]=lists[count].next;
            }


            return head;
        }

        public boolean isEmpty(ListNode[] lists){
            int k=0;
            for(int i=0; i<lists.length;i++){
                if(lists[i]==null){
                    k++;
                }
            }
            if(k==lists.length) return true;

            return false;
        }

    }


}
