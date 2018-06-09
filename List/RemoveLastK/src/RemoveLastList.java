public class RemoveLastList {

    public static Node delLinkList(int k, Node L){
        Node T = L;
        while(T != null){
            k --;
            T = T.next;
        }
        if (k == 0) {
            L = L.next;
        }else if(k < 0){
            Node pre = L;
            Node temp = L;
            while(k != 0){
                k ++;
                pre = temp;
                temp = temp.next;
            }
//            删除倒数第K个节点
            pre.next = pre.next.next;
        }else if (k > 0){
            System.out.println("没有倒数第K个元素");
        }
        return L;
    }

    public static DoubleNode delDoubleLinkList(int k, DoubleNode L){
        DoubleNode T = L;
        while(T != null){
            k --;
            T = T.next;
        }
        if (k == 0) {
            L = L.next;
            L.last = null;
        }else if(k < 0){
            DoubleNode pre = L;
            DoubleNode temp = L;
            while(k != 0){
                k ++;
                pre = temp;
                temp = temp.next;
            }
//            删除倒数第K个节点
            DoubleNode newNode = pre.next.next;
            pre.next = newNode;
            if(newNode != null)
                newNode.last = pre;
        }else if (k > 0){
            System.out.println("没有倒数第K个元素");
        }
        return L;
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
        l1 = delLinkList(4 ,l1);
        System.out.println("删除之后");
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

        l2 = delDoubleLinkList(5,l2);
        System.out.println("双链表删除完成");

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
