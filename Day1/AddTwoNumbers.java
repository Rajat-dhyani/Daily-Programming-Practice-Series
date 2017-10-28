/**
 * Question : https://leetcode.com/problems/add-two-numbers/description/
 * Difficulty: Medium
 * Topic: LinkedList
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 *
 * My submission :
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode sumList = new ListNode(sum);
        l1 = l1.next;
        l2 = l2.next;
        ListNode tempSum = sumList;

        while (l1 != null && l2 != null){
            sum = (l1.val+l2.val+ carry) % 10;
            carry = (l1.val+l2.val+ carry) / 10;
            ListNode currentSum = new ListNode(sum);
            tempSum.next = currentSum;
            tempSum = currentSum;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null)
            addRemainingNode(tempSum, l1, carry);
        else if (l2 != null)
            addRemainingNode(tempSum, l2, carry);
        else if (carry>0){
           ListNode currentSum = new ListNode(carry);
           tempSum.next = currentSum;
        }
        return sumList;
    }

    public static void addRemainingNode(ListNode sumList,ListNode node, int carry){

        while (node != null){
            int sum = node.val;
            if (carry> 0){
                sum += carry;
                if ( sum == 10){
                    sum = 0;
                    carry = 1;
                } else {
                    carry = 0;
                }
            }
            ListNode currentSum = new ListNode(sum); // to remove conflict in future values of sumList
            sumList.next = currentSum;
            sumList = currentSum;
            node = node.next;
        }

        if (carry > 0){
           ListNode currentSum = new ListNode(carry);
           sumList.next = currentSum;
        }
    }
}


/**
 * efficient/ elegant solution
 *
 *
 class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		         ListNode p = l1, q = l2, curr = dummyHead;
		         int carry = 0;
		         while (p != null || q != null) {
		             int x = (p != null) ? p.val : 0;
		             int y = (q != null) ? q.val : 0;
		             int sum = carry + x + y;
		             carry = sum / 10;
		             curr.next = new ListNode(sum % 10);
		             curr = curr.next;
		             if (p != null) p = p.next;
		             if (q != null) q = q.next;
		         }
		         if (carry > 0) {
		             curr.next = new ListNode(carry);
		         }
        return dummyHead.next;
    }
 }
 *
 */
