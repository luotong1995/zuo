public class Solution {
    public static Node reverse_List_everyi(Node head, int k){

        Node new_head = null;
        Node pre = null;
        Node start = null;
        Node cur = null;
        Node next = null;

        int length = 1;
        cur = head;
        while(cur != null){
            next = cur.next;
            if(length == k) {

                if (pre == null){
                    start = head;
                    new_head = cur;
                }else{
                    start = pre.next;
                }
                reverse2(pre,start,cur,next);
                //此时要进行反转
                pre = start;
                length = 0;
            }
            cur = next;
            length ++;
        }
        return new_head;
    }


    // 给定四个节点分别是pre ，start，end，next反转start --> end之间的节点
    public static void reverse2(Node pre, Node start, Node end, Node next){

        Node cur = start.next;
        Node temp = start;
        Node next_temp = null;
        while(cur != next){
            next_temp = cur.next;
            cur.next = temp;
            temp = cur;
            cur = next_temp;
        }
        if(pre != null){
            pre.next = end;
        }
        start.next = next;
    }

    public static void reverse(Node pre, Node start, Node end, Node next){

        Node cur = start;
        Node temp = null;
        Node rear = next;
        while(cur != next){
            if(pre != null) {
                pre.next = cur;
            }
            temp = cur.next;
            cur.next = rear;
            rear = cur;
            cur = temp;
        }
    }

    public static void print_list(Node L){
        Node l2 = L;
        while(l2 != null){
            System.out.print(l2.value);
            l2 = l2.next;
        }
    }

    public static void main(String[] args){
        Node head = null;
        Node r = null;
        int a[] = {1,2,3,4,5,6,7};
        for (int i : a){
            Node p = new Node(i);
            if(head == null){
                head = p;
                r = p;
                p.next = null;
            }else{
                r.next = p;
                r = p;
            }
        }

        print_list(head);
        System.out.println("----------");
        head = reverse_List_everyi(head,2);
        print_list(head);
        System.out.println("----------");

    }
}


class Node{
    int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}