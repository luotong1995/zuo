public class LSmallAndRBig {



    public static void solution1(NodeList head, int pivot){
        NodeList cur = head;
        NodeList head1 = null;
        NodeList head2 = null;
        NodeList head3 = null;
        NodeList next = null;
        NodeList r1 = null;
        NodeList r2 = null;
        NodeList r3 = null;
        while(cur != null){
            next = cur.next;
            if (cur.value < pivot){
                if(head1 == null){
                    head1 = cur;
                    r1 = cur;
                    cur.next = null;
                }else{
                    r1.next = cur;
                    r1 = cur;
                }
            }else if (cur.value > pivot){
                if(head3 == null){
                    head3 = cur;
                    r3 = cur;
                    cur.next = null;
                }else{
                    r3.next = cur;
                    r3 = cur;
                }
            }else{
                if(head2 == null){
                    head2 = cur;
                    r2 = cur;
                    cur.next = null;
                }else{
                    r2.next = cur;
                    r2 = cur;
                }
            }
            cur = next;
        }
        r1.next = head2;
        r2.next = head3;
        r3.next = null;
        head = head1;
    }

    //不带头节点的print
    public static void print_list(NodeList L){
        NodeList l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    public static void main(String[] args){
        NodeList head = null;
        NodeList r = null;
        NodeList p = null;
        int numbe[] = {1,5,4,2,4,8,4,9};
        for(int i = 0 ;i < numbe.length; i++){
            p = new NodeList(numbe[i]);
            // 创建链表的第一个节点
            if (head == null) {
                head = p;
                r = p;
                p.next = null;
            } else {
                r.next = p;
                r = p;
            }
        }
        r.next = null;

        print_list(head);
        System.out.println("--------------");
        solution1(head, 5);
        print_list(head);
        System.out.println("--------------");

    }


}



class NodeList{
    public int value;
    public NodeList next;
    public NodeList(int value){
        this.value = value;
    }
}