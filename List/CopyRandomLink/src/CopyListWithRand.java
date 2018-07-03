import java.util.HashMap;

public class CopyListWithRand {
    public static Node solution1(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur,new Node(cur.value));
            cur = cur.next;
        }
        //第二次遍历设置next and random
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node solution2(Node head){
        Node cur = head;
        //第一次遍历将副本链表生成并设置next的 link
        while(cur != null){
            Node next = cur.next;
            Node node = new Node(cur.value);
            cur.next = node;
            node.next = next;
            cur = next;
        }

        //第二次遍历设置random的link
        cur = head;
        Node temp = null;
        while(cur != null){
            Node next = cur.next.next;
            temp = cur.next;
            temp.random = cur.random != null ? cur.random.next:null;
            cur = next;
        }
        //拆分链表
        cur = head;
        Node head2 = cur.next;
        while(cur != null){
            Node next = cur.next.next;
            temp = cur.next;
            cur.next = next;
            temp.next = next != null? next.next: null;
            cur = next;
        }
        return head2;
    }

    public static void print(Node head){
        Node cur = head;
        while(cur != null){
            System.out.println(cur);
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        Node head = null;
        Node node1 = new Node(1);

        Node node2 = new Node(2);

        Node node3 = new Node(3);

        Node node4 = new Node(4);

        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = null;
        node2.random = node1;
        node3.random = node4;
        node4.random = node2;
        node5.random = null;

        head = node1;
        print(head);
        System.out.println("-----------------");
        Node head2 = solution2(head);
        print(head2);


    }
}

class Node{
    public int value;
    public Node next;
    public Node random;
    public Node(int value){
        this.value = value;
    }

    @Override
    public String toString() {
        String next = "null";
        if (this.next != null){
            next = String.valueOf(this.next.value);
        }

        String random = "null";
        if (this.random != null){
            random = String.valueOf(this.random.value);
        }
        String s = String.valueOf(this.value) + " next: " + next + " random: " + random;
        return s;
    }
}
