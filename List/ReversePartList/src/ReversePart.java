public class ReversePart {

    public static void print_list(Node L){
        Node l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }


    public static Node reversePart(Node L, int from ,int to){
        Node from_node = null;
        Node to_node = null;
        Node T = L;
        int len = 0;
        while(T != null){
            len ++;
            if (len == from - 1){
                from_node = T;
            }
            if (len == to + 1){
                to_node = T;
            }
            T = T.next;
        }

        if (from > to || from < 1 || to > len){
            return L;
        }

        Node node1 = L;
//        如果from==1的时候pre_node == null,此时需要将其从头from 到to进行反转，此时的pre_node = L
        if(from_node == null){
            node1 = L;
        }else{
            node1 = from_node.next;
        }

        // 使用头插法进行插入链表
        Node node2 = node1.next;
        Node next = null;
        node1.next = to_node;
        while(node2 != to_node){
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        // 如果from==1的时候也就是from_node == null 的时候就直接返回node1，否则就将from_node.next = node1 返回L
        if (from_node != null){
            from_node.next = node1;
            return L;
        }

        return node1;
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
        l1 = reversePart(l1 , 2 ,3);
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