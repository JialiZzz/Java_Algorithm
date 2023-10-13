/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 15469
 */
public class Solution {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // get value in reverse list
        // add to a string
        // to number
        // for while loop  array range 
        int len1=0, len2=0;
        ListNode node1=l1, node2=l2;
        while(node1!=null){
            len1++;
            node1 = node1.next;
        }
        while(node2!=null){
            len2++;
            node2=node2.next;
        }
        int sum1[] = new int[len1];
        int sum2[] = new int[len2];
        for(int i = len1-1; i>=0; i--){
            sum1[i] = l1.val;
            l1 = l1.next;
        }
        for(int i = len2-1; i>=0; i--){
            sum2[i] = l2.val;
            l2 = l2.next;
        }
        
        // num to str
        String str1="",str2="";
        for(int i = 0; i<len1; i++){
            str1+=sum1[i];
        }
        for(int i = 0; i<len2; i++){
            str2+=sum2[i];
        }
        
        // str to num
        int x = Integer.parseInt(str1);
        int y = Integer.parseInt(str2);
        int sum = x+y;
        int sum3 = sum;
        int count=1;
        
        // add val to node
        ListNode nodeRe = new ListNode();
        if(sum3==0){
            nodeRe.val=0;
            nodeRe.next=null;
            return nodeRe;
        }
        while(sum3!=0){
            count++;
            sum3=sum3/10;
        }
        count--;
        int count2[] = new int[count], i=count-1;
        System.out.println("Count is "+count);
        
        // put each ith number into array
        
        System.out.println("S");
        while(i!=-1){
            int s = sum%10;     // mod
            count2[i]=s;
            i--;
            sum = sum/10;
        }

        //链表有问题
        //add val to linklist
        nodeRe.val=count2[count-1];
        nodeRe.next=null;
        ListNode current = nodeRe;
        for(int k = count-2; k>=0; k--){
            ListNode nodeNe = new ListNode(count2[k]);
            current.next = nodeNe;
            current = current.next;
            
        }

        return nodeRe;

    }
    
    public static void main(String[] args){
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        
        l1.next=l2;
        l2.next=l3;
        l3.next=null;
        
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(4);
        
        l4.next=l5;
        l5.next=null;
        l6.next=null;

        ListNode node = addTwoNumbers( l1,  l4);
        System.out.println();
        while(node!=null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
    
    
}
