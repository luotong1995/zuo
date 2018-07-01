public class MidNode {

    public static NodeList getMidNode(NodeList head){
        if (head == null || head.next == null){
            return head;
        }
        NodeList mid = head;
        NodeList cur = head;
        while(cur.next != null && cur.next.next != null){
            mid = mid.next;
            cur = cur.next.next;
        }
        return mid;
    }

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

        for(int i = 0 ;i < 3; i++){
            p = new NodeList(i);
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
        NodeList mid = getMidNode(head);
        System.out.println("-------------------------");
        System.out.println(mid.value);
    }
}


class NodeList{
    public int value;
    public NodeList next;
    public NodeList(int value){
        this.value = value;
    }
}