import java.util.Stack;

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

    // 使用栈结构实现逆序，每次将节点押入栈中，当栈中的长度为k的时候，就将其中的元素pop出来然后进行逆序
    public static Node reverse_List_everyi2(Node head,int k){
        if(k < 2){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node new_head = null;
        Node cur = head;
        Node pre = null;
        Node next = null;
        while(cur != null){
            next = cur.next;
            stack.push(cur);
            if(stack.size() == k){
                pre = reversebyStack(stack,pre,next);
                if (new_head == null){
                    new_head = cur;
                }
            }
            cur = next;
        }
        return new_head;
    }

    public static Node reversebyStack(Stack<Node> stack, Node pre, Node next){
        Node cur = stack.pop();
        if(pre != null){
            pre.next = cur;
        }
        Node temp = null;
        while(!stack.isEmpty()){
            temp = stack.pop();
            cur.next = temp;
            cur = temp;
        }
        cur.next = next;
        return cur;
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
        head = reverse_List_everyi2(head,2);
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