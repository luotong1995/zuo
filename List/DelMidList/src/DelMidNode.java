public class DelMidNode {

    public static Node delNode(Node L){
        if (L == null || L.next == null)
            return L;
        if (L.next.next == null)
            return L.next;
        Node pre = L;
        Node cur = L.next.next;
        while(cur.next != null && cur.next.next != null){
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return L;
    }

    public static Node delNode(Node L, int a, int b) {
        if (a == 0 || a > b)
            return L;
        int len = 0;
        Node cur = L;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        // 删除的节点为r
        int r = (int)Math.ceil((double)a * len / (double) b);
        Node pre = L;
        Node T = L;
        int i = 1;
        while(T != null ){
            pre = T;
            i++;
            if (i == r){
                break;
            }
            T = T.next;
        }
        pre.next = pre.next.next;
        return L;
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
        r.next = null;

        print_list(l1);

        l1 = delNode(l1,1,2);
        System.out.println("--------------");
        print_list(l1);
    }
}


class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}