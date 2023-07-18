package com.sharp.listnode;

/**
 *  两个链表的第一个公共节点
 */
//        case:
//        ListNode head1 = new ListNode(1);
//        ListNode head8 = new ListNode(8);
//        ListNode head4 = new ListNode(4);
//        ListNode head5 = new ListNode(5);  以上为公共部分
//
//        ListNode headA = new ListNode(4);
//        ListNode.insertNode(headA,head1,2);
//        ListNode.insertNode(headA,head8,3);
//        ListNode.insertNode(headA,head4,4);
//        ListNode.insertNode(headA,head5,5);
//
//        ListNode headB = new ListNode(5);
//        ListNode.insertNode(headB,new ListNode(0),2);
//        ListNode.insertNode(headB,head1,3);
//        ListNode.insertNode(headB,head8,4);
//        ListNode.insertNode(headB,head4,5);
//        ListNode.insertNode(headB,head5,6);
public class FindFirstCommonNode {
    /**
     *  1.哈希表方法
     * @param headA
     * @param headB
     * @return
     */
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        Set<ListNode> set = new HashSet<>();
//        while(headA!=null){
//            set.add(headA);
//            headA = headA.next;
//        }
//        while(headB!=null){
//            if(set.contains(headB)){
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
//    }

    /**
     *  2.栈方法
     * @param headA
     * @param headB
     * @return
     */
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//            Deque<ListNode> stackA = new LinkedList<>();
//            Deque<ListNode> stackB = new LinkedList<>();   //Deque双向队列模拟 栈
//            while(headA != null){
//                stackA.push(headA);
//                headA = headA.next;
//            }
//            while(headB != null){
//                stackB.push(headB);
//                headB = headB.next;
//            }
//            ListNode preNode = null;
//            while( stackA.size()>0 && stackB.size()>0){
//                if(stackA.peek() == stackB.peek()){
//                    preNode = stackA.pop();
//                    stackB.pop();
//                }else{
//                    break;
//                }
//            }
//            return preNode;
//        }

    /**
     *  3.拼接两个字符串
     * @param headA
     * @param headB
     * @return
     */
    // 0-1-2-3-4-5
    // a-b-4-5
    //拼接后：
    // 0-1-2-3-4-5-a-b-4-5
    // a-b-4-5-0-1-2-3-4-5
    //遍历比较，4即是第一个公共节点
//    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if(headA == null || headB == null){
//            return null;
//        }
//        ListNode p1 = headA;
//        ListNode p2 = headB;
//        while (p1 != p2){
//            p1 = p1.next;
//            p2 = p2.next;
//            if(p1!=p2){
//                if(p1 == null){
//                    p1 = headB;
//                }
//                if(p2 == null){
//                    p2 = headA;
//                }
//            }
//        }
//        return p1;
//    }

    /**
     *  4.差和双指针 让长的先走两长度差值，后遍历比较，相同则是第一个公共结点
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        if(headA == null || headB == null){
            return null;
        }
        ListNode currentA = headA;
        ListNode currentB = headB;
        int lenA = 0,lenB = 0;
        while (currentA != null){
            currentA = currentA.next;
            lenA++;
        }
        while (currentB != null){
            currentB = currentB.next;
            lenB++;
        }
        currentA = headA;
        currentB = headB;
        int sub = lenA < lenB? lenB-lenA : lenA-lenB;
        if(lenA>lenB){
            int a = 0;
            while (a < sub){
                currentA = currentA.next;
                a++;
            }
        }
        if(lenA<lenB){
            int a= 0;
            while (a<sub){
                currentB = currentB.next;
                a++;
            }
        }
        while (currentA!=currentB){
            currentA = currentA.next;
            currentB = currentB.next;
        }
        return currentA;
    }


    }












