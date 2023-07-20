package com.sharp.listnode.双向链表基础;

/**
 * 双向链表
 */
public class DoublyLinkList {
    class DoubleNode{
        public int data; //数据域
        public DoubleNode next; //指向下一个结点
        public DoubleNode prev; //指向上一个结点
        public DoubleNode(int data){
            this.data = data;
        }
        //打印结点的数据域
        public void displayNode(){
            System.out.println("{" + data + "}");
        }
    }

    private DoubleNode first;
    private DoubleNode last;
    //初始化双向链表
    public DoublyLinkList(){
        first = null;
        last = null;
    }
    //从头部开始打印
    public void displayForward(){
        System.out.println("List(first---->last):");
        DoubleNode current = first;
        while (current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    //从尾部开始打印
    public void displayBackward(){
        System.out.println("List(last---->first):");
        DoubleNode current = last;
        while (current != null){
            current.displayNode();
            current = current.prev;
        }
        System.out.println();
    }

    /**
     * 头部插入
     * @param data
     */
    public void insertFirst(int data){
        DoubleNode newDoubleNode = new DoubleNode(data);
        if (last == null){
            //如果第一个结点是空
            last = newDoubleNode;
        } else {
            //如果不是第一个结点的情况
            //将未插入前的头结点的前驱指向新结点
          first.prev = newDoubleNode;
        }
        newDoubleNode.next =first;
        first = newDoubleNode;
    }

    /**
     * 尾部插入
     * @param data
     */
    public void insertLast(int data){
        DoubleNode newDoubleNode = new DoubleNode(data);
        if(last == null){
            //如果第一个结点是空
            first = newDoubleNode;
        }else {
            //如果不是第一个结点的情况
            //将未插入前的尾结点的后驱指向新结点
            //将新结点的前驱指向未插入前的尾结点
            newDoubleNode.prev = last;
            last.next = newDoubleNode;
        }
        //新插入尾结点，所以将last指向新结点
        last = newDoubleNode;
    }

    /**
     * 在某节点后插入新结点
     * @param key 某节点
     * @param data 新结点
     */
    public void insertAfter(int key,int data){
        DoubleNode newDoubleNode = new DoubleNode(data);
        DoubleNode current = first;
        while (current != null && current.data != key){
            current = current.next;
        }
        //若当前结点current为空
        if(current == null){
            if (last == null){
                first = newDoubleNode;
                last = newDoubleNode;
            }else {
                //找不到key值，则在链表尾部插入一个新结点
                last.next = newDoubleNode;
                newDoubleNode.prev = last;
                last = newDoubleNode;
            }
        }else {
            //找到key值，分两种情况
            if(current == last){
                //key值与最后结点的data相等
                newDoubleNode.next = null;
                last = newDoubleNode;
            }else {
                //两结点中插入
                newDoubleNode.next = current.next;
                current.next.prev = newDoubleNode;
            }
        }
        current.next = newDoubleNode;
        newDoubleNode.prev = current;
    }

    /**
     * 删除头结点
     * @return 返回删除的结点
     */
    public DoubleNode deleteFirst(){
        DoubleNode temp = first;
        if(first.next == null){
            //若链表只有一个结点，删除后链表为空，将last指向null
            last = null;
        }else {
            // 若有两个及以上结点，头部删除，则first.next将变成第一个结点，其前驱prev变成null
            first.next.prev = null;
        }
        //将first.next赋给first
        first = first.next;
        //返回删除的结点
        return temp;
    }

    /**
     * 从尾部删除结点
     * @return 返回删除的结点
     */
    public DoubleNode deleteLast(){
        DoubleNode temp = last;
        if(first.next == null){
            //如果链表只有一个结点，删除后为空链表，last指向null
            first = null;
        }else {
            //将上一个结点的next指向null
            last.prev.next = null;
        }
        last = last.prev;
        //返回删除的结点
        return temp;
    }

    /**
     * 删除指定结点
     * @param key 指定结点
     * @return
     */
    public DoubleNode deleteKey(int key){
        DoubleNode current = first;
        //遍历链表寻找该值所在结点
        while (current != null && current.data != key){
            current = current.next;
        }
        if(current == null){
            //若当前结点current为null则返回null
            return null;
        }else {
            if(current == first){
                //如果current 是第一个结点，则将first指向它，该结点的prev指向null，其余不变
                first = current.next;
                current.next.prev = null;
            }else if(current == last){
                //如果current是最后一个结点
                last = current.prev;
                current.prev.next = null;
            }else {
                //当前结点的上一个结点的next应指向当前节点的下一个结点
                current.prev.next = current.next;
                //当前结点的下一个结点的prev应指向当前结点的上一个结点
                current.next.prev = current.prev;
            }
        }
        return current;
    }
}































