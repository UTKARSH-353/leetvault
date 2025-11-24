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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //Using Brute Force Approach by own
        
        List<Integer>values = new ArrayList<>();
        while(list1 != null){
            values.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            values.add(list2.val);
            list2 = list2.next;
        }
        Collections.sort(values); 

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int val: values){
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}


            //Optimised Solution(recursive approach)

// class Solution{
//     public ListNode mergeTwoLists( ListNode list1, ListNode list2){
//         if(list1 == null) return list2;
//         if(list2 == null) return list1;

//         if(list1.val <= list2.val){
//             list1.next = mergeTwoLists(list1.next, list2);
//             return list1;
//         }else{
//             list2.next = mergeTwoLists(list1, list2.next);
//             return list2;
//         }
//     }
// }            

    