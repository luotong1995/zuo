public class Ysf_problem {
    public static Node del_M_node(Node head, int m){
        // 如果头节点为空，m的值小于1直接返回
        if (head == null || m < 1){
            return head;
        }
        Node L = head;
        int len = 0;
        while(L.next != head){
            len ++;
            L = L.next;
        }
        // 如果链表的长度为1，也直接返回
        if (len == 1 ){
            return head;
        }

        Node pre = head;
        Node p = head.next;
        int i = 1;//用来计数此时报数为几
        while(p.next != p){
            i ++;
            if(i == m){
                i = 0;
                System.out.println( "del" + p.value);
                pre.next = p.next;
                p = pre.next;
            }else {
                pre = p;
                p = p.next;
            }
        }
        return p;
    }

    public static void print_last_node(Node L){
        System.out.println(L.value);
    }


    public static void print_list(Node L){
        Node l2 = L;
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
        r.next = l1;

        l1 = del_M_node(l1, 2);
        System.out.println("--------------");
        print_last_node(l1);
    }
}


class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}