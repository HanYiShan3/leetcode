package org.algorithm;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author yishan
 */
public class sumTwoNumbers {
    /**
     * @Description:循环遍历数组，时间复杂度为O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * @Description:使用hash表，时间复杂度为O(n)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
           if(map.containsKey(target-nums[i])){
               return new int[]{map.get(target-nums[i]),i};
           }
           map.put(nums[i],i);
        }
      return new int[0];
    }

    /**
     * @Description:给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
         while (l1 != null || l2 != null) {
             int n1 = l1 != null ? l1.val : 0;
             int n2 = l2 != null ? l2.val : 0;
             int sum = n1 + n2 + carry;
             if (head == null) {
                 head = tail = new ListNode(sum % 10);
             } else {
                 tail.next = new ListNode(sum % 10);
                 tail = tail.next;
             }
             carry = sum / 10;
             if (l1 != null) {
                 l1 = l1.next;
             }
             if (l2 != null) {
                 l2 = l2.next;
             }
         } if (carry > 0) {
             tail.next = new ListNode(carry);
         }
         return head;
    }
    public static void main(String[] args) {

//        int[] nums=new int[]{2,7,11,15};
//        int target=17;
//        //格式化当前时间
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//        System.out.println(df.format(System.currentTimeMillis()));
//        int[] result=twoSum2(nums,target);
//        System.out.println("-"+df.format(System.currentTimeMillis()));
//        assert result != null;
//        System.out.println(result[0]+" and "+result[1]);
        ListNode listnode = new ListNode(4);    //创建首节点，节点的val是0.
        ListNode nextNode;                     //声明一个变量用来在移动过程中指向当前节点
        nextNode=listnode;                      //指向首节点

        //创建链表
        for(int i=1;i<3;i++){
            ListNode node = new ListNode(i);  //生成新的节点
            nextNode.next=node;               //把新节点连起来
            nextNode=nextNode.next;           //当前节点往后移动
        }       //当for循环完成之后 nextNode指向最后一个节点，
        //重新赋值让它指向首节点
        nextNode=listnode;
        ListNode head = addTwoNumbers(listnode,nextNode);
            System.out.println("节点:"+head);


    }


}
