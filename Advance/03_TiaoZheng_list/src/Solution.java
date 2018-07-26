public class Solution {


    public static void adjust(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        int length = 0;
        Node cur = head;
        while(cur != null){
            length ++;
            cur = cur.next;
        }
        // 创建一个长度为偶数的数组，与运算符可以判断是否是奇数
        Node[] nums = new Node[(length & 1) == 1? (length -1) : length];

        cur = head;
        for(int i= 0 ;i< nums.length;i++){
            nums[i] = cur;
            cur = cur.next;
        }
        Node[] help = new Node[nums.length];
        for(int i = 0; i< nums.length;i++){
            if(i < length / 2){
                help[i*2] = nums[i];
            }else{
                help[(i- nums.length/2)*2 + 1] = nums[i];
            }
        }

        Node r = null;
        for(int i = 0;i<help.length;i++){
            Node temp = help[i];
            if(i == 0){
                head = temp;
                r = temp;
            }
            r.next = temp;
            r = temp;
        }
        // 将最后一个节点连接在链表最后
        r.next = cur;

    }

    public static void adjust2(Node head){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        Node cur = head;
        int length = 0;
        while(cur != null){
            length ++;
            cur = cur.next;
        }
        cur = head;
        Node mid = head;
        while(cur.next != null && cur.next.next != null){
            mid = mid.next;
            cur = cur.next.next;
        }
        Node right = (length & 1) == 1 ? mid : mid.next;
        Node left = head;
        Node l_next = null;
        Node r_next = null;
        Node r = null;
        Node p = left;
        Node q = right;
        while(p != right){
            l_next = p.next;
            r_next = q.next;
            if (p != left){
                r.next = p;
            }
            p.next = q;
            r = q;
            p = l_next;
            q = r_next;
        }
        r.next = q;
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
        int a [] = {1,2,3,4,5,6,7,8,9};
        Node head = null;
        Node r = null;

        for( int item : a){
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
        adjust2(head);
        System.out.println();
        print_list(head);
    }
}


class Node{
    public int value;
    public Node next;
    public Node(int value){
        this.value = value;
    }
}

