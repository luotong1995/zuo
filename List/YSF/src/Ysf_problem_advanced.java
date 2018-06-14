public class Ysf_problem_advanced {
    public static Node del_M_node(Node head, int m){
        return head;
    }




//TODO 这个题目需要重新进行看
    public static void print_last_node(Node L){
        System.out.println(L.value);
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
