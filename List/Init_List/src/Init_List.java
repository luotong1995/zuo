public class Init_List {

    //带头节点的头插法
    public static NodeList initList1(){
        //head节点尾头节点，此节点作为头节点实际上不存储内容
        NodeList head = new NodeList(0);
        head.next = null;
        for (int i = 1; i < 5; i ++){
            NodeList p = new NodeList(i);
            p.next = head.next;
            head.next = p;
        }
        return head;
    }

    //不带头节点的头插法
    public static NodeList initList2(){
        NodeList head = null;
        for (int i = 1; i < 5; i ++){
            NodeList p = new NodeList(i);
            if (head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
        }
        return head;
    }

    //带头节点的尾插法
    public static NodeList initList3(){
        //head节点尾头节点，此节点作为头节点实际上不存储内容
        NodeList head = new NodeList(0);
        head.next = null;
        NodeList r = head;
        for (int i = 1; i < 5; i ++){
            NodeList p = new NodeList(i);
            r.next = p;
            r = p;
        }
        r.next = null;
        return head;
    }

    public static NodeList initList4(){
        NodeList head = null;
        NodeList r = null;
        for (int i = 1; i < 5; i ++){
            NodeList p = new NodeList(i);
            if (head == null){
                head = p;
                r = p;
                p.next = null;
            }else{
                r.next = p;
                r = p;
            }
        }
        r.next = null;
        return head;
    }

    //不带头节点的print
    public static void print_list(NodeList L){
        NodeList l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    //带头节点的print
    public static void print_list2(NodeList L){
        NodeList l2 = L.next;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }

    public static void main(String[] args){
        NodeList head = initList1();
        print_list2(head);
        System.out.println("--------------");
        head = initList2();
        print_list(head);
        System.out.println("--------------");
        head = initList3();
        print_list2(head);
        System.out.println("--------------");
        head = initList4();
        print_list(head);
    }
}


class NodeList{
    public int value;
    public NodeList next;
    public NodeList(int value){
        this.value = value;
    }
}