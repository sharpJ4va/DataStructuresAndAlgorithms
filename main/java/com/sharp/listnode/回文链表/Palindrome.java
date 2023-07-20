package com.sharp.listnode.回文链表;

import com.sharp.listnode.单链表基础.ListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 *  回文链表
 */
//        方法1：将链表元素都赋值到数组中，然后可以从数组两端向中间对比。这种方法会被视为逃避链表，面试
//        不能这么干。
//        方法2：将链表元素全部压栈，然后一边出栈，一边重新遍历链表，一边比较两者元素值，只要有一个不相
//        等，那就不是。
//        方法3：优化方法2，先遍历第一遍，得到总长度。之后一边遍历链表，一边压栈。到达链表长度一半后就
//        不再压栈，而是一边出栈，一边遍历，一边比较，只要有一个不相等，就不是回文链表。这样可以节省一
//        半的空间。
//        方法4：优化方法3：既然要得到长度，那还是要遍历一次涟表才可以，那是不是可以一边遍历一边全部压
//        栈，然后第二遍比较的时候，只比较一半的元素呢？也就是只有一半的元素出钱，链表也只遍历一半，当
//        然可以。
//        方法5：反转链表法，先创建一个涟表newList,将原始链表oldList的元素值逆序保存到newList中，然后
//        重新一边遍历两个链表，一遍比较元素的值，只要有一个位置的元素值不一样，就不是回文链表。
//        方法6：优化方法5，我们只反转一半的元素就行了。先遍历一遍，得到总长度。然后重新遍历，到达一半
//        的位置后不再反转，就开始比较两个链表。
//        方法7：优化方法6，我们使用双指针思想里的快慢指针，fast一次走两步，slow一次走一步。当fast到达
//        表尾的时候，Sow正好到达一半的位置，那么接下来可以从头开始逆序一半的元素，或者从Sow开始逆序
//        半的元素，都可以。
//        方法8：在遍历的时候使用递归来反转一半链表可以吗？当然可以，再组合一下我们还能想出更多的方法，
//        解决问题的思路不止这些了，此时单纯增加解法数量没啥意义了。
public class Palindrome {
    /**
     *  将链表全部压栈， 然后一边出栈一边重新遍历链表，一边比较，只要有一个不相等就不是回文链表了
     * @param head
     * @return
     */
//    public boolean isPalindrome(ListNode head) {
//        ListNode temp = head;
//        Deque<Integer> stack = new LinkedList<>();
//        while(temp!=null){
//            stack.push(temp.val);
//            temp = temp.next;
//        }
//        while(head!=null){
//            if(head.val != stack.pop()){
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
//    }

    /**
     * 遍历得到长度的同时将链表压栈，遍历一半，出栈一半相比较
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        Deque<Integer> stack = new LinkedList<>();
        int len = 0;
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
            len++;
        }
        int a = 0;
        while(a < len/2){
            if(head.val != stack.pop()){
                return false;
            }
            head = head.next;
            a++;
        }
        return true;
    }
}
