/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
      
       ListNode left=head;
       ListNode right;
       ListNode prevLeft=null;
       ListNode result=null;
       int pair=2;
       if(head==null){
        return null;
       }
       
       while(true){
        right=left;
        for(int i=0;i<(pair-1);i++){
            if(right==null)
            break;
            right=right.next;
        }
        if(right!=null){
         ListNode nextleft=right.next;
        
         reverse(left,pair);
         if(prevLeft!=null)
            prevLeft.next=right;
            prevLeft=left;
            if(result==null)
            result=right;

            left=nextleft;

         }
         else{
            if(prevLeft!=null)
            prevLeft.next=left;
            if(result==null)
            result=left;
            break;
         }
       } 
       return result;
    }
      public void reverse(ListNode head ,int times){
            
            ListNode curr=head;
            ListNode prev=null;
            while(times-->0){
               ListNode next=curr.next;
               curr.next=prev;
               prev=curr;
               curr=next;
            }
            return;
        }
}