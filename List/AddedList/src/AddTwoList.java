import java.util.Stack;

public class AddTwoList {
    //直接将链表的值组合成为一个整形数，然后进行相加
    public static Node add(Node node1,Node node2){
        int temp1 = 0;
        Node cur = node1;
        while(cur!= null){
            temp1 = temp1* 10 + cur.value;
            cur = cur.next;
        }
        int temp2 = 0;
        cur = node2;
        while(cur!= null){
            temp2 = temp2* 10 + cur.value;
            cur = cur.next;
        }
        int result = temp1 + temp2;
        Node head = null;
        while(result != 0){
            int value = result % 10;
            Node p = new Node(value);
            if(head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
            result = result/10;
        }
        return head;
    }

    public static void insertList(Node head,int value){
        Node p = new Node(value);
        if(head == null){
            head = p;
            p.next = null;
        }else{
            p.next = head;
            head = p;
        }
    }

    //使用stack来实现
    public static Node add2(Node head1,Node head2){
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node cur = head1;
        while(cur != null){
            stack1.push(cur.value);
            cur = cur.next;
        }
        cur = head2;
        while(cur != null){
            stack2.push(cur.value);
            cur = cur.next;
        }
        int ca = 0;
        Node head = null;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            int a = stack1.pop();
            int b = stack2.pop();
            int c = a + b + ca;
            ca = c /10;
            c = c % 10;
            Node p = new Node(c);
            if(head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
        }

        if (stack1.isEmpty()){
            while(!stack2.isEmpty()){
                int b = stack2.pop();
                int c = b + ca;
                ca = c /10;
                c = c % 10;
                Node p = new Node(c);
                if(head == null){
                    head = p;
                    p.next = null;
                }else{
                    p.next = head;
                    head = p;
                }
            }
        }

        if (stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int b = stack2.pop();
                int c = b + ca;
                ca = c /10;
                c = c % 10;
                Node p = new Node(c);
                if(head == null){
                    head = p;
                    p.next = null;
                }else{
                    p.next = head;
                    head = p;
                }
            }
        }

        if(ca != 0) {
            Node p = new Node(ca);
            if(head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
        }
        return head;
    }


    //将链表逆序，实现将数字的从地位到高位的排列
    public static Node add3(Node head1,Node head2){
        int ca = 0;
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        Node cur1 = head1;
        Node cur2 = head2;
        Node head = null;
        while(cur1 != null && cur2 != null){
            int a = cur1.value;
            int b = cur2.value;
            int c = a + b + ca;
            ca = c / 10;
            c = c % 10;
            Node p = new Node(c);
            if(head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }


        if (cur1 == null){
            while(cur2 != null){
                int b = cur2.value;
                int c = b + ca;
                ca = c /10;
                c = c % 10;
                Node p = new Node(c);
                if(head == null){
                    head = p;
                    p.next = null;
                }else{
                    p.next = head;
                    head = p;
                }
                cur2 = cur2.next;
            }
        }

        if (cur2 == null){
            while(cur1 != null){
                int b = cur1.value;
                int c = b + ca;
                ca = c /10;
                c = c % 10;
                Node p = new Node(c);
                if(head == null){
                    head = p;
                    p.next = null;
                }else{
                    p.next = head;
                    head = p;
                }
                cur1 = cur1.next;

            }
        }

        if (ca != 0){
            Node p = new Node(ca);
            if(head == null){
                head = p;
                p.next = null;
            }else{
                p.next = head;
                head = p;
            }
        }
        reverseList(head1);
        reverseList(head2);
        return head;
    }


    public static Node reverseList(Node head){
        Node new_head = null;
        Node next = null;
        while(head != null){
            next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
        }
        return new_head;
    }

    //不带头节点的print
    public static void print_list(Node L){
        Node l2 = L;
        while(l2 != null){
            System.out.print(l2.value);
            l2 = l2.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        int a[] = {9,2,3};
        int b[] = {9,3,9};

        Node head1 = null;
        Node head2 = null;
        Node r = null;
        for(int i=0; i<a.length; i++){
            Node p = new Node(a[i]);
            if (head1 == null){
                head1 = p;
                r = p;
            }else{
                r.next = p;
                r = p;
            }
        }
        r.next = null;

        for(int i=0; i<b.length; i++){
            Node p = new Node(b[i]);
            if (head2 == null){
                head2 = p;
                r = p;
            }else{
                r.next = p;
                r = p;
            }
        }
        r.next = null;

        print_list(head1);
        System.out.println("----------------");
        print_list(head2);
        System.out.println("----------------");
        Node head3 = add(head1,head2);
        Node head4 = add2(head1,head2);
        Node head5 = add3(head1,head2);

        print_list(head3);
        print_list(head4);
        print_list(head5);

        System.out.println("----------------");

        print_list(head1);
        System.out.println("----------------");
        print_list(head2);

    }
}


class Node{
    public int value;
    public Node next;

    public Node(int value){
        this.value = value;
    }
}