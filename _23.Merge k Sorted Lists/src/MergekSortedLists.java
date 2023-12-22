public class MergekSortedLists {
        int s;


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1=list1;
        ListNode head2=list2;
        ListNode head = new ListNode();
        ListNode cur=head;
        //if head1 or head2 is null, return another one
        if(head1 == null){
            return list2;
        }
        if(head2 == null){
            return list1;
        }
        while(head1!=null||head2!=null){
            if(head1!=null&&head2!=null){
                if(head1.val<head2.val){
                    cur.next=head1;
                    cur=cur.next;
                    head1=head1.next;
                }else{
                    cur.next=head2;
                    cur=cur.next;
                    head2=head2.next;
                }
            }
            else if(head1==null){
                cur.next=head2;
                break;
            }
            else if(head2==null){
                cur.next=head1;
                break;
            }



        }

        return head.next;

    }


      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }


      public  ListNode mergeKLists(ListNode[] lists) {
          ListNode node = new ListNode();
          ListNode head;

          if(lists==null) return null;
          int k=0;
          for(int i=0;i<lists.length;i++){
              if(lists[i]==null){
                  k++;
              }
          }
          if(k== lists.length) return null;
          head = node;
          s=0;
          while(s< lists.length){
              int hisIndex;
              int maxIndex=-1;
              s=0;
              for(int i=0;i<lists.length;i++){
                  if(lists[i]==null){
                      s++;
                  }
                  else{
                      hisIndex=i;
                      if(maxIndex==-1){
                          maxIndex=hisIndex;
                      }
                      else if(lists[maxIndex].val>lists[hisIndex].val){
                          maxIndex=hisIndex;
                      }
                  }
              }
              if(maxIndex!=-1){
                  head.next=lists[maxIndex];
                  head=head.next;
                  lists[maxIndex]=lists[maxIndex].next;
              }
          }

          return node.next;
        }


    public static void main(String[] args){
        ListNode n = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        n.next=n1;
        ListNode[] lists = {n,n2};
        MergekSortedLists m = new MergekSortedLists();
        ListNode g =m.mergeKLists(lists);
        while (g!=null){
            System.out.println(g.val);
            g=g.next;
        }

    }

}
