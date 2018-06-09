public class ReverseList {

    public static Node reverseList(Node L){
        // 遍历一遍，并且使用头插法进行插入就对其进行了转置
        Node cur = L;
        Node new_L = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new_L;
            new_L = cur;
            cur = next;
        }
        return new_L;
    }

    public static DoubleNode reverseDoubleList(DoubleNode L){

        // 遍历一遍，并且使用头插法进行插入就对其进行了转置
        DoubleNode cur = L;
        DoubleNode new_L = null;
        DoubleNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = new_L;
//            new_L.last = cur;
            cur.last = next; //pre 的last指针指向原链表的下一个节点，即会成为其前一个节点，如果到链表的末端即为null
            new_L = cur;
            cur = next;
        }
        return new_L;
    }

    public static void print_list(Node L){
        Node l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    public static void print_double_list(DoubleNode L){
        DoubleNode l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    public static void main(String[] args){
        Node l1 = new Node(1);
        Node r = l1;
        for(int i = 2; i < 5 ; i++){
            Node temp = new Node(i);
            r.next = temp;
            r = temp;
        }
        r.next = null;

        print_list(l1);
        l1 = reverseList(l1);
        System.out.println("--------------");
        print_list(l1);



        System.out.println("双链表");
        DoubleNode l2 = new DoubleNode(1);
        l2.last = null;
        DoubleNode r2 = l2;
        for(int i = 2; i < 5 ; i++){
            DoubleNode temp = new DoubleNode(i);
            r2.next = temp;
            temp.last =r2;
            r2 = temp;
        }
        r2.next = null;

        print_double_list(l2);

        l2 = reverseDoubleList(l2);
        System.out.println("---------");

        print_double_list(l2);
    }
}


class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}

class DoubleNode{
    public int value;
    public DoubleNode next;
    public DoubleNode last;
    public DoubleNode(int value){
        this.value = value;
    }
}