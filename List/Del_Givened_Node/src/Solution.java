import java.util.Stack;

public class Solution {

    public static Node del_k(Node head, int k){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        while(cur != null){
            if(cur.value != k){
                stack.push(cur);
            }
            cur = cur.next;
        }

        Node new_head = null;
        while(!stack.isEmpty()){
            Node p = stack.pop();
            if(new_head == null){
                new_head = p;
                p.next = null;
            }else{
                p.next = new_head;
                new_head = p;
            }
        }
        return new_head;
    }


    //不带头节点的print
    public static void print_list(Node L){
        Node l2 = L;
        while(l2 != null){
            System.out.println(l2.value);
            l2 = l2.next;
        }
    }



    public static void main(String[] args){
        int[] a = {1,2,3,4,3,3,3};
        Node head = null;
        Node r = null;
        for(int item : a){
            Node p = new Node(item);
            if(head == null){
                head = p;
                r = p;
            }else{
                r.next = p;
                r = p;
            }
        }
        r.next = null;

        print_list(head);

        Node new_head = del_k(head, 3);

        print_list(new_head);

    }
}

class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}
